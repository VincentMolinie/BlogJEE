package service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

/**
 * Created by F on 11/07/2015.
 */
@SessionScoped
public class Login {
    @Inject
    private dao.Login login;

    public String getPassword()
    {
        return login.getPassword();
    }

    public String getUsername()
    {
        return login.getUsername();
    }

    public void setPassword(String password)
    {
        login.setPassword(password);
    }

    public void setUsername(String username)
    {
        login.setUsername(username);
    }

    public String login(String username, String password)
    {
        return login.login(username, password);
    }

    public void logout()
    {
        login.logout();
    }
}
