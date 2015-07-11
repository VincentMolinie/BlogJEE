package webservices;

import entity.Article;
import entity.Category;
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
@Path("/category")
@Produces("application/json; charset=UTF-8")
public class CategoryService {
    @Inject
    Service service;

    @GET
    @Path("get/{categoryId}")
    public Category getCategory(@PathParam("categoryId") final Integer categoryId) {
        return service.find(Category.class, categoryId);
    }

    @POST
    @Path("/add")
    @Consumes("application/json")
    public Category addCategory(String value) throws IOException {
        Category category = new ObjectMapper().readValue(value, Category.class);
        return service.create(category);
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    public Category updateCategory(String value) throws IOException {
        Category category = new ObjectMapper().readValue(value, Category.class);
        return service.update(category);
    }

    @POST
    @Path("/delete")
    @Consumes("application/json")
    public String deleteCategory(String value) throws IOException {
        Category category = new ObjectMapper().readValue(value, Category.class);
        service.delete(category);
        return "OK";
    }

    @GET
    @Path("/all")
    public Collection<Category> getAllCategories(@Context final HttpServletRequest request) {
        return service.findAll(Category.class);
    }
}
