package service;

import dao.DAO;
import entity.Model;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

/**
 * Created by F on 11/07/2015.
 */
@ApplicationScoped
public class Service {

    @Inject
    private DAO dao;

    public <BEAN extends Model> BEAN create(final BEAN bean) {
        return dao.create(bean);
    }

    public <BEAN extends Model> BEAN update(final BEAN bean) {
        return dao.update(bean);
    }

    public <BEAN extends Model> void delete(final BEAN bean) {
        dao.delete(bean);
    }

    public <BEAN extends Model> BEAN find(final Class<BEAN> entityClass, final Integer id) {
        return dao.find(entityClass, id);
    }

    public <BEAN extends Model> Collection<BEAN> findAll(final Class<BEAN> entityClass) {
        return dao.findAll(entityClass);
    }
}
