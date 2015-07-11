package dao;

import entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by vince on 7/11/15.
 */
@ApplicationScoped
public class UserDAO {
    @PersistenceContext(unitName = "jpaUnit")
    private EntityManager entityManager;

    public User findByUsername(String username) {

        return (User) entityManager.createQuery("select u from User u where u.username like '" + username + "'").getSingleResult();
    }
}
