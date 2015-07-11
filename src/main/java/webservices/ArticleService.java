package webservices;

import entity.Article;
import entity.User;
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
@Path("/article")
@Produces("application/json; charset=UTF-8")
public class ArticleService {
    @Inject
    Service service;

    @GET
    @Path("get/{articleId}")
    public Article getArticle(@PathParam("articleId") final Integer articleId) {
        return service.find(Article.class, articleId);
    }

    @POST
    @Path("/add")
    @Consumes("application/json")
    public Article addArticle(String value) throws IOException {
        Article article = new ObjectMapper().readValue(value, Article.class);
        return service.create(article);
    }

    @POST
    @Path("/update")
    @Consumes("application/json")
    public Article updateArticle(String value) throws IOException {
        Article article = new ObjectMapper().readValue(value, Article.class);
        return service.update(article);
    }

    @POST
    @Path("/delete")
    @Consumes("application/json")
    public String deleteArticle(String value) throws IOException {
        Article article = new ObjectMapper().readValue(value, Article.class);
        service.delete(article);
        return "OK";
    }

    @GET
    @Path("/all")
    public Collection<Article> getAllArticles(@Context final HttpServletRequest request) {
        return service.findAll(Article.class);
    }
}
