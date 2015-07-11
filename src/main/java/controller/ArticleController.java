package controller;


import entity.Article;
import entity.Category;
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
@Named("article")
public class ArticleController implements Serializable {
    @Inject
    Service service;

    private Integer userid = new Integer(1);
    private Integer categoryid = new Integer(0);
    private Article article = new Article();

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Article get() {
        int id = article.getId();
        article = new Article();
        return service.find(Article.class, article.getId());
    }

    public void add() throws IOException {
        User user = service.find(User.class, userid);
        Category category = service.find(Category.class, categoryid);
        article.setDate(new Date(Calendar.DATE));
        article.setUser(user);
        article.setCategory(category);
        service.create(article);
        article = new Article();
    }

    public void update() throws IOException {
        service.update(article);
        article = new Article();
    }

    public void delete() throws IOException {
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
