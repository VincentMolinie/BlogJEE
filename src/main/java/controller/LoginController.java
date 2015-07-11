package controller;

import dao.UserDAO;
import entity.User;
import service.Login;
import service.UserService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * Created by F on 11/07/2015.
 */
@ViewScoped
@Named("login")
public class LoginController implements Serializable {
    @Inject
    private UserService userService;

    private Login login = new Login();
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public void SignIn()
    {
        User user = userService.findByUsername(username);
        boolean valid = (password.equals(user.getPassword()));
        FacesContext context = FacesContext.getCurrentInstance();

        if (valid)
        {
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            session.setAttribute("username", username);
            //return "postArticle";
        }
        else
        {
            context.addMessage(null, new FacesMessage("Incorrect identifiers", "Please enter correct identifiers"));
            //return "login";
        }
    }

    public void logout()
    {
        login.logout();
    }
}
