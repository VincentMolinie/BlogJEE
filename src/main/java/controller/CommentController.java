package controller;

import entity.Article;
import entity.Comment;
import entity.User;
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
    private Integer userid = new Integer(1);



    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Comment get() {
        if (comment.getId() == null)
            return null;
        int id = comment.getId();
        comment = new Comment();
        return service.find(Comment.class, comment.getId());
    }

    public void add(int id) {
        Article article = service.find(Article.class, id);
        User user = service.find(User.class, userid);
        comment.setUser(user);
        comment.setArticle(article);
        comment.setDate(new Date(System.currentTimeMillis()));
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
