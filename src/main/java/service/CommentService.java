package service;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by vince on 7/11/15.
 */
public class CommentService extends AbstractService {
    @GET
    @Path("/read/{messageId}")
    @Produces("application/json")
    public CommentService find(@PathParam("messageId") Integer id) {
        return dao.find(CommentService.class, id);
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    public CommentService update(CommentService message) {
        return dao.update(message);
    }

    @GET
    @Path("/read/all")
    @Produces("application/json")
    public List<CommentService> findAll() {
        return dao.findAll(CommentService.class);
    }

    @PUT
    @Path("/write")
    @Consumes("application/json")
    public CommentService create(CommentService message) {
        return dao.create(message);
    }

    @DELETE
    @Path("/del/{messageId}")
    public void delete(@PathParam("messageId") Integer id) {
        CommentService message = find(id);
        dao.delete(message);
    }
}
