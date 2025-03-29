package com.ecommerce.presentation;

import com.ecommerce.metier.IGestionUser;
import com.ecommerce.metier.GestionUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")  // <--- This is your URL pattern
public class AuthenticationController extends HttpServlet {

    private IGestionUser gestionUser;

    @Override
    public void init() throws ServletException {
        // Create or inject your metier (business) class
        gestionUser = new GestionUser();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Show the login JSP
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean isValid = gestionUser.login(username, password);

        if (isValid) {
            // Create session & store user info
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Redirect to Bienvenue (or wherever)
            response.sendRedirect(request.getContextPath() + "/Bienvenue");
        } else {
            // Send back to login with error
            request.setAttribute("errorMsg", "Identifiants incorrects");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }
}
