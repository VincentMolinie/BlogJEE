package webservices;

import entity.User;
import org.codehaus.jackson.map.ObjectMapper;
import service.Service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by F on 11/07/2015.
 */
@RequestScoped
@Named
@Path("/user")
@Produces("application/json; charset=UTF-8")
public class UserService {

    @Inject
    Service service;

    @GET
    @Path("get/{userId}")
    public User getUser(@PathParam("userId") final Integer userId) {
        return service.find(User.class, userId);
    }

    @POST
    @Path("/add")
    @Consumes("application/json")
    public User addUser(String value) throws IOException {
        User user = new ObjectMapper().readValue(value, User.class);
        return service.create(user);
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    public User updateUser(String value) throws IOException {
        User user = new ObjectMapper().readValue(value, User.class);
        return service.update(user);
    }

    @POST
    @Path("/delete")
    @Consumes("application/json")
    public String deleteUser(String value) throws IOException {
        User user = new ObjectMapper().readValue(value, User.class);
        service.delete(user);
        return "OK";
    }

    @GET
    @Path("/all")
    public Collection<User> getAllUsers(@Context final HttpServletRequest request) {
        return service.findAll(User.class);
    }
}