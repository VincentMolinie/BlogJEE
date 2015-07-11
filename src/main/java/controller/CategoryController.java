package controller;

import entity.Article;
import entity.Category;
import service.Service;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Created by vince on 7/11/15.
 */
public class CategoryController {
    @Inject
    Service service;

    private Category category = new Category();


    public Category getCategory() {
        int id = category.getId();
        category = new Category();
        return service.find(Category.class, category.getId());
    }

    public List<Article> getArticles() {
        Category selectedCategory = getCategory();
        return selectedCategory.getArticles();
    }

    public void addCategory() throws IOException {
        service.create(category);
        category = new Category();
    }

    public void updateCategory() throws IOException {
        service.update(category);
        category = new Category();
    }

    public void deleteCategory() throws IOException {
        service.delete(category);
        category = new Category();
    }

    public Collection<Category> getAll() {
        return service.findAll(Category.class);
    }
}
