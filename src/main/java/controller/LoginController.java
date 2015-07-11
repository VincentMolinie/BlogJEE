package controller;

import service.Login;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by F on 11/07/2015.
 */
@Named("login")
public class LoginController {
    @Inject
    private Login login;

    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String password;

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String login()
    {
        System.err.println(username);
        return login.login(username, password);
    }

    public void logout()
    {
        login.logout();
    }
}
