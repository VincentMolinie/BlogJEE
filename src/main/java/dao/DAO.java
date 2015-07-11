package dao;

import entity.Model;
import log.Logged;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by vince on 4/25/15.
 */
@ApplicationScoped
public class DAO {
    @PersistenceContext(unitName = "jpaUnit")
    protected EntityManager entityManager;

    @Logged
    public <BEAN extends Model> BEAN find(final Class<BEAN> clazz, final Integer id) {
        return entityManager.find(clazz, id);
    }

    @Logged
    public <BEAN extends Model> List<BEAN> findAll(final Class<BEAN> clazz) {
        return entityManager.createQuery(String.format("from %s",
                clazz.getName())).getResultList();
    }

    @Logged
    @Transactional
    public <BEAN extends Model> BEAN update(final BEAN bean) {
        entityManager.merge(bean);
        return bean;

    }

    @Logged
    @Transactional
    public <BEAN extends Model> BEAN create(final BEAN bean) {
        entityManager.persist(bean);
        return bean;
    }

    @Logged
    @Transactional
    public <BEAN extends Model> void delete(final BEAN bean) {
        entityManager.remove(bean);
    }

}
