package dao;

import entity.User;

import javax.enterprise.context.ApplicationScoped;

/**
 * Created by vince on 7/11/15.
 */
@ApplicationScoped
public class UserDAO extends DAO {
    public User findByUsername(String username) {
        return (User) entityManager.createQuery("from user where user.username == " + username).getSingleResult();
    }
}
