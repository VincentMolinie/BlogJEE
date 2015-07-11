package service;

import dao.UserDAO;
import entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Created by vince on 7/11/15.
 */
@ApplicationScoped
public class UserService {
    @Inject
    private UserDAO dao;

    public User findByUsername(String username) {
        return dao.findByUsername(username);
    }
}
