package dao;

import entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by vince on 7/11/15.
 */
@ApplicationScoped
public class UserDAO {
    @Inject
    private EntityManager entityManager;
    
    public User findByUsername(String username) {
        return (User) entityManager.createQuery("from user where user.username == " + username).getSingleResult();
    }
}
