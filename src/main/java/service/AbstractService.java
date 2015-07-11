package service;

import dao.DAO;

import javax.inject.Inject;

/**
 * Created by vince on 4/25/15.
 */
public abstract class AbstractService {
    @Inject
    protected DAO dao;
}
