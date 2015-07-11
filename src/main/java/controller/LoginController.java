package controller;

import entity.User;
import service.UserService;
import tools.HashGenerateException;
import tools.PasswordHelper;

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

    public void SignIn() throws HashGenerateException {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);

        if (session.getAttribute("username") == null)
        {
            User user = userService.findByUsername(username);
            boolean valid = PasswordHelper.compareHash(password, user.getPassword());

            if (valid)
            {
                session.setAttribute("username", username);
            }
            else
            {
                context.addMessage(null, new FacesMessage("Incorrect identifiers", "Please enter correct identifiers"));
            }
        }
        else
            logout();

    }

    public void logout()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.invalidate();
    }
}
