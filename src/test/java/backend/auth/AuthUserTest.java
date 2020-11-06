package backend.auth;

import backend.Bundle;
import model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class AuthUserTest {

    @Test
    public void signUpTest() {
        Auth userAuth = new AuthUser();
        Bundle data = new Bundle();
        data.putString("email", "alan.turing@manchester.edu");
        data.putString("dni", "123456");
        data.putString("name", "Alan Turing");
        data.putString("password", "enigma");
        userAuth.signUp(data, new Auth.OnRegisterListener() {
            @Override
            public void onRegister(User user) {
                assertEquals(user.getEmail(), "alan.turing@manchester.edu");
                assertEquals(user.getDni(), "123456");
            }

            @Override
            public void onFail(String message) {
                fail(message);
            }
        });
    }

    @Test
    public void logInTest() {
        Auth userAuth = new AuthUser();
        userAuth.logIn("alan.turing@manchester.edu", "enigma", new Auth.OnLogInListener() {
            @Override
            public void onLogIn(User user) {
                assertEquals(user.getEmail(), "alan.turing@manchester.edu");
                assertEquals(user.getDni(), "123456");
            }

            @Override
            public void onFail(String message) {
                fail();
            }
        });
    }

    @Test
    public void logOutTest() {
        Auth userAuth = new AuthUser();
        userAuth.logOut(new Auth.OnLogOutListener() {
            @Override
            public void onLogOut() {
                userAuth.getCurrentUser(new Auth.OnGetUserListener() {
                    @Override
                    public void onGetUser(User user) {
                        fail();
                    }

                    @Override
                    public void onNoUserLoggedIn() {

                    }
                });
            }

            @Override
            public void onFail() {
                fail();
            }
        });
    }

    @Test
    public void getCurrentUserTest() {
        Auth userAuth = new AuthUser();
        userAuth.getCurrentUser(new Auth.OnGetUserListener() {
            @Override
            public void onGetUser(User user) {
                assertEquals(user.getEmail(), "alan.turing@manchester.edu");
            }

            @Override
            public void onNoUserLoggedIn() {
                fail();
            }
        });
    }

}