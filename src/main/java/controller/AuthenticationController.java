package controller;

import entity.User;
import service.Service;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by vince on 7/11/15.
 */
@ViewScoped
@Named("yooo")
public class AuthenticationController {
    @Inject
    private Service service;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void Login() {

    }

    public String logout() {
        String page="/login?logout=true&faces-redirect=true";
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.logout();
        } catch (ServletException e) {
            context.addMessage(null, new FacesMessage("Logout failed!"));
            page="/login?logout=false&faces-redirect=true";
        }
        return page;
    }

    public void Register() {

    }
}
