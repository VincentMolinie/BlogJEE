package service;

import entity.Comment;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by vince on 7/11/15.
 */
public class CommentService extends AbstractService {
    @GET
    @Path("/read/{commentId}")
    @Produces("application/json")
    public Comment find(@PathParam("commentId") Integer id) {
        return dao.find(Comment.class, id);
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    public Comment update(Comment comment) {
        return dao.update(comment);
    }

    @GET
    @Path("/read/all")
    @Produces("application/json")
    public List<Comment> findAll() {
        return dao.findAll(Comment.class);
    }

    @PUT
    @Path("/write")
    @Consumes("application/json")
    public Comment create(Comment comment) {
        return dao.create(comment);
    }

    @DELETE
    @Path("/del/{commentId}")
    public void delete(@PathParam("commentId") Integer id) {
        Comment comment = find(id);
        dao.delete(comment);
    }
}
