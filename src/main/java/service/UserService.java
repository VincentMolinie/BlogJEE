package service;

import entity.User;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by vince on 7/11/15.
 */
public class UserService extends AbstractService {
    @GET
    @Path("/read/{userId}")
    @Produces("application/json")
    public User find(@PathParam("userId") Integer id) {
        return dao.find(User.class, id);
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    public User update(User user) {
        return dao.update(user);
    }

    @GET
    @Path("/read/all")
    @Produces("application/json")
    public List<User> findAll() {
        return dao.findAll(User.class);
    }

    @PUT
    @Path("/write")
    @Consumes("application/json")
    public User create(User user) {
        return dao.create(user);
    }

    @DELETE
    @Path("/del/{userId}")
    public void delete(@PathParam("userId") Integer id) {
        User user = find(id);
        dao.delete(user);
    }
}
