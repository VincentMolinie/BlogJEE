package controller;

import entity.Comment;
import service.Service;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by vince on 7/11/15.
 */
public class CommentController {
    @Inject
    Service service;

    private Comment comment = new Comment();


    public Comment getComment() {
        int id = comment.getId();
        comment = new Comment();
        return service.find(Comment.class, comment.getId());
    }

    public void addComment() throws IOException {
        service.create(comment);
        comment = new Comment();
    }

    public void updateComment() throws IOException {
        service.update(comment);
        comment = new Comment();
    }

    public void deleteComment() throws IOException {
        service.delete(comment);
        comment = new Comment();
    }

    public Collection<Comment> getAll() {
        return service.findAll(Comment.class);
    }
}
