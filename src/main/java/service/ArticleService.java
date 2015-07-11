package service;

import entity.Article;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by vince on 7/11/15.
 */
public class ArticleService extends AbstractService {
    @GET
    @Path("/read/{articleId}")
    @Produces("application/json")
    public Article find(@PathParam("articleId") Integer id) {
        return dao.find(Article.class, id);
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    public Article update(Article article) {
        return dao.update(article);
    }

    @GET
    @Path("/read/all")
    @Produces("application/json")
    public List<Article> findAll() {
        return dao.findAll(Article.class);
    }

    @PUT
    @Path("/write")
    @Consumes("application/json")
    public Article create(Article article) {
        return dao.create(article);
    }

    @DELETE
    @Path("/del/{articleId}")
    public void delete(@PathParam("articleId") Integer id) {
        Article article = find(id);
        dao.delete(article);
    }
}
