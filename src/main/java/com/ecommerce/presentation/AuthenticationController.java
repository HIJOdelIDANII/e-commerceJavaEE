package com.ecommerce.presentation;

import com.ecommerce.metier.IGestionUser;
import com.ecommerce.metier.GestionUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class AuthenticationController extends HttpServlet {

    private IGestionUser gestionUser;

    @Override
    public void init() throws ServletException {

        gestionUser = new GestionUser();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean isValid = gestionUser.login(username, password);

        if (isValid) {

            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            response.sendRedirect(request.getContextPath() + "/Bienvenue");
        } else {

            request.setAttribute("errorMsg", "Identifiants incorrects");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }
}
