package controller;

import entity.Comment;
import service.Service;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
import java.util.Collection;

/**
 * Created by vince on 7/11/15.
 */
@ViewScoped
@Named("comment")
public class CommentController implements Serializable {
    @Inject
    Service service;

    private Comment comment = new Comment();


    public Comment get() {
        if (comment.getId() == null)
            return null;
        int id = comment.getId();
        comment = new Comment();
        return service.find(Comment.class, comment.getId());
    }

    public void add() throws IOException {
        comment.setDate(new Date(Calendar.DATE));
        service.create(comment);
        comment = new Comment();
    }

    public void update() throws IOException {
        service.update(comment);
        comment = new Comment();
    }

    public void delete() throws IOException {
        service.delete(comment);
        comment = new Comment();
    }

    public Collection<Comment> getAll() {
        return service.findAll(Comment.class);
    }
}
