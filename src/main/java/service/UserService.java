package service;

import dao.UserDAO;
import entity.User;

import javax.inject.Inject;

/**
 * Created by vince on 7/11/15.
 */
public class UserService extends Service {
    @Inject
    private UserDAO dao;

    public User findByUsername(String username) {
        return dao.findByUsername(username);
    }
}
