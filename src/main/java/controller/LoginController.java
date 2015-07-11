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

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String login()
    {
        System.out.println(login.getUsername());
        return login.login(login.getUsername(), login.getPassword());
    }

    public void logout()
    {
        login.logout();
    }
}
