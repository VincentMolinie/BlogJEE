package webservices;

import tools.ResponseCorsFilter;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

/**
 * Created by F on 11/07/2015.
 */
@ApplicationPath("/api")
public class API extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return getRestResourceClasses();
    }
    private Set<Class<?>> getRestResourceClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        resources.add(UserService.class);
        resources.add(ArticleService.class);
        resources.add(CategoryService.class);
        resources.add(CommentService.class);
        resources.add(ResponseCorsFilter.class);
        return resources;
    }
}
