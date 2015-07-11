package controller;


import entity.Article;
import entity.User;
import service.Service;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by vince on 7/11/15.
 */
@ViewScoped
@Named("article")
public class ArticleController implements Serializable {
    @Inject
    Service service;

    private Integer userid = new Integer(1);
    private Article article = new Article();


    public Article get() {
        if (article.getId() == null)
            return null;
        int id = article.getId();
        article = new Article();
        return service.find(Article.class, article.getId());
    }

    public void addArticle() throws IOException {
        User user = service.find(User.class, userid);
        article.setUser(user);
        service.create(article);
        article = new Article();
    }

    public void updateArticle() throws IOException {
        service.update(article);
        article = new Article();
    }

    public void deleteArticle() throws IOException {
        service.delete(article);
        article = new Article();
    }

    public Collection<Article> getAll() {
        return service.findAll(Article.class);
    }

    public Integer getUserid() {
        return userid;
    }
}
