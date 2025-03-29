package com.ecommerce.presentation;

import com.ecommerce.metier.IGestionUser;
import com.ecommerce.metier.GestionUser;
import com.ecommerce.metier.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/inscription")
public class InscriptionController extends HttpServlet {

    private IGestionUser gestionUser;

    @Override
    public void init() throws ServletException {
        gestionUser = new GestionUser();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Show the inscription JSP
        request.getRequestDispatcher("/WEB-INF/views/inscription.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email    = request.getParameter("email");

        // Build the user object
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);

        // Call business logic to create user
        gestionUser.creerUser(newUser);

        // Redirect to login or a success page
        response.sendRedirect(request.getContextPath() + "/login");
    }
}
