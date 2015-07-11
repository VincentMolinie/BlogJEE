package controller;

import entity.User;
import service.Service;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by vince on 7/11/15.
 */
@ViewScoped
@Named("user")
public class UserController implements Serializable {
    @Inject
    Service service;

    private User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User get() {
        int id = user.getId();
        user = new User();
        return service.find(User.class, user.getId());
    }

    public void add() throws IOException {
        service.create(user);
        user = new User();
    }

    public void update() throws IOException {
        service.update(user);
        user = new User();
    }

    public void delete() throws IOException {
        service.delete(user);
        user = new User();
    }

    public Collection<User> getAll() {
        return service.findAll(User.class);
    }
}
