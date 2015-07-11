package controller;

import entity.User;
import service.Service;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by vince on 7/11/15.
 */
public class UserController {
    @Inject
    Service service;

    private User user = new User();

    public User getUser() {
        int id = user.getId();
        user = new User();
        return service.find(User.class, user.getId());
    }

    public void addUser() throws IOException {
        service.create(user);
        user = new User();
    }

    public void updateUser() throws IOException {
        service.update(user);
        user = new User();
    }

    public void deleteUser() throws IOException {
        service.delete(user);
        user = new User();
    }

    public Collection<User> getAll() {
        return service.findAll(User.class);
    }
}
