package backend.auth;

import backend.Bundle;
import model.User;

public interface Auth {

    /**
     * Retorna el usuario actualmente loggeado
     *
     * @return
     */
    void getCurrentUser(OnGetUserListener listener);

    /**
     * @param listener
     */
    void logOut(OnLogOutListener listener);

    /**
     * Loggea al usuario
     *
     * @param email
     * @param pwd
     */
    void logIn(String email, String pwd, OnLogInListener listener);

    /**
     * @param data @return
     */
    void signUp(Bundle data, OnRegisterListener listener);

    interface OnLogInListener {
        void onLogIn(User user);

        void onFail(String message);
    }

    interface OnRegisterListener {
        void onRegister(User user);

        void onFail(String message);
    }

    interface OnGetUserListener {
        void onGetUser(User user);

        void onNoUserLoggedIn();
    }

    interface OnLogOutListener {
        void onLogOut();

        void onFail();
    }
}
