package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/produits/*") // Protect all URLs under /produits
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // Cast ServletRequest and ServletResponse to HTTP-specific classes
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Get the session (do not create a new one if it doesn't exist)
        HttpSession session = httpRequest.getSession(false);

        // Check if the user is logged in
        boolean isLoggedIn = (session != null && session.getAttribute("user") != null);

        if (isLoggedIn) {
            // User is logged in, allow the request to proceed
            chain.doFilter(request, response);
        } else {
            // User is not logged in, redirect to the login page
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic (if needed)
    }

}