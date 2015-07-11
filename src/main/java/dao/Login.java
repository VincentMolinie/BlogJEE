package dao;

import entity.User;

import javax.servlet.http.HttpSession;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


/**
 * Created by F on 11/07/2015.
 */
@ManagedBean
@SessionScoped
public class Login {
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
    private String password;

    public String login(String username, String password)
    {
        User user = new UserDAO().findByUsername("username");
        boolean valid = (user.getPassword() == password);
        FacesContext context = FacesContext.getCurrentInstance();

        if (valid)
        {
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            session.setAttribute("username", username);
            return "postArticle";
        }
        else
        {
            context.addMessage(null, new FacesMessage("Incorrect identifiers", "Please enter correct identifiers"));
            return "login";
        }
    }

    public String logout()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.invalidate();
        return "login";
    }
}
