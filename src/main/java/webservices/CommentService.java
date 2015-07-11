package webservices;

import entity.Category;
import entity.Comment;
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
@Path("/comment")
@Produces("application/json; charset=UTF-8")
public class CommentService {
    @Inject
    Service service;

    @GET
    @Path("get/{categoryId}")
    public Comment getComment(@PathParam("commentId") final Integer commentId) {
        return service.find(Comment.class, commentId);
    }

    @POST
    @Path("/add")
    @Consumes("application/json")
    public Comment addComment(String value) throws IOException {
        Comment comment = new ObjectMapper().readValue(value, Comment.class);
        return service.create(comment);
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    public Comment updateComment(String value) throws IOException {
        Comment comment = new ObjectMapper().readValue(value, Comment.class);
        return service.update(comment);
    }

    @POST
    @Path("/delete")
    @Consumes("application/json")
    public String deleteArticle(String value) throws IOException {
        Comment comment = new ObjectMapper().readValue(value, Comment.class);
        service.delete(comment);
        return "OK";
    }

    @GET
    @Path("/all")
    public Collection<Comment> getAllComments(@Context final HttpServletRequest request) {
        return service.findAll(Comment.class);
    }
}
