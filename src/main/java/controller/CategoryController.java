package controller;

import entity.Article;
import entity.Category;
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
@Named("category")
public class CategoryController implements Serializable {
    @Inject
    Service service;

    private Category category = new Category();

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category get() {
        int id = category.getId();
        category = new Category();
        return service.find(Category.class, id);
    }

    public Collection<Article> getArticles(int id) {
        Category selectedCategory = service.find(Category.class, id);
        return selectedCategory.getArticles();
    }

    public void add() throws IOException {
        service.create(category);
        category = new Category();
    }

    public void update() throws IOException {
        service.update(category);
        category = new Category();
    }

    public void delete() throws IOException {
        service.delete(category);
        category = new Category();
    }

    public Collection<Category> getAll() {
        return service.findAll(Category.class);
    }
}
