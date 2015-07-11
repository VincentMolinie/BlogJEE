package tools;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.LogRecord;

/**
 * Created by F on 11/07/2015.
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.xhtml" })
public class RoleAuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException
    {
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            HttpSession session = httpRequest.getSession(false);

            String requestUri = httpRequest.getRequestURI();

            if (requestUri.contains("/login.xhtml")
                || (session != null && session.getAttribute("username") != null))
                chain.doFilter(request, response);
            else
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.xhtml");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void destroy() {

    }
}
