package controller;

import entity.User;
import org.codehaus.jackson.map.ObjectMapper;
import service.Service;
import webservices.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by Durieux on 11/07/2015.
 */
@ApplicationScoped
@Named("index")
public class IndexController {

}
