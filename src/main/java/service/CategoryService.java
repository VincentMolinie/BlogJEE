package service;

import entity.Category;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by vince on 7/11/15.
 */
public class CategoryService extends AbstractService {
    @GET
    @Path("/read/{categoryId}")
    @Produces("application/json")
    public Category find(@PathParam("categoryId") Integer id) {
        return dao.find(Category.class, id);
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    public Category update(Category category) {
        return dao.update(category);
    }

    @GET
    @Path("/read/all")
    @Produces("application/json")
    public List<Category> findAll() {
        return dao.findAll(Category.class);
    }

    @PUT
    @Path("/write")
    @Consumes("application/json")
    public Category create(Category category) {
        return dao.create(category);
    }

    @DELETE
    @Path("/del/{categoryId}")
    public void delete(@PathParam("categoryId") Integer id) {
        Category category = find(id);
        dao.delete(category);
    }
}
