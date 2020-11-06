package backend.auth;

import backend.*;
import model.User;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AuthUser implements Auth {

    private static final String AUTH_FILE_PATH = "login";
    private final DataBaseRead sqlDataBaseRead;
    private final DataBaseWrite sqlDataBaseWrite;

    public AuthUser() {
        sqlDataBaseRead = DataBaseReadSQLite.getInstance();
        sqlDataBaseWrite = DataBaseWriteSQLite.getInstance();
    }

    @Override
    public void getCurrentUser(OnGetUserListener listener) {
        String currLoggedInEmail = getLoggedEmail();
        if (currLoggedInEmail != null && !currLoggedInEmail.equals("")) {
            getUserForEmail(currLoggedInEmail, new GetUserForEmailListener() {
                @Override
                public void onGetUser(User user) {
                    listener.onGetUser(user);
                }

                @Override
                public void onFail() {
                    listener.onNoUserLoggedIn();
                }
            });
        } else {
            listener.onNoUserLoggedIn();
        }
    }

    private String getLoggedEmail() {
        String currLoggedInEmail = null;
        try {
            File f = new File(AUTH_FILE_PATH);
            f.createNewFile();
            Scanner scanner = new Scanner(f);
            if (scanner.hasNext()) {
                currLoggedInEmail = scanner.next();
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return currLoggedInEmail;
    }

    public void saveLoggedEmail(String email) {
        try {
            File f = new File(AUTH_FILE_PATH);
            f.createNewFile();
            PrintWriter writer = new PrintWriter(f);
            writer.print(email);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getUserForEmail(String currLoggedInEmail, GetUserForEmailListener listener) {
        Bundle bundle = new Bundle();
        bundle.putString("email", currLoggedInEmail);
        sqlDataBaseRead.getUserList(bundle, userList -> {
            if (userList.size() > 0) {
                listener.onGetUser(userList.get(0));
            } else {
                listener.onFail();
            }
        });
    }

    @Override
    public void logOut(OnLogOutListener listener) {
        saveLoggedEmail("");
        listener.onLogOut();
    }

    @Override
    public void logIn(String email, String pwd, OnLogInListener listener) {
        getUserForEmail(email, new GetUserForEmailListener() {
            @Override
            public void onGetUser(User user) {
                if (user != null) {
                    if (!user.is_valid()) {
                        listener.onFail("el usuario está desactivado");
                    } else if (!user.getPassword().equals(pwd)) {
                        listener.onFail("Contraseña errónea");
                    } else {
                        saveLoggedEmail(user.getEmail());
                        listener.onLogIn(user);
                    }
                } else {
                    listener.onFail("Email erróneo");
                }
            }

            @Override
            public void onFail() {
                listener.onFail("error al loggear");
            }
        });
    }

    @Override
    public void signUp(Bundle data, OnRegisterListener listener) {
        String email = data.getString("email", "");
        getUserForEmail(email, new GetUserForEmailListener() {
            @Override
            public void onGetUser(User user) {
                listener.onFail("Email ya en uso");
            }

            @Override
            public void onFail() {
                User newUser = new User(
                        data.getString("dni", ""),
                        data.getString("name", ""),
                        email,
                        data.getString("password", ""),
                        "", // TODO
                        "", // TODO
                        "Rol1", // TODO
                        true
                );
                sqlDataBaseWrite.write(newUser, result -> {
                    if (result) {
                        saveLoggedEmail(newUser.getEmail());
                        listener.onRegister(newUser);
                    } else {
                        listener.onFail("no se pudo registrar");
                    }
                });
            }
        });
    }

    private interface GetUserForEmailListener {
        void onGetUser(User user);

        void onFail();
    }
}
