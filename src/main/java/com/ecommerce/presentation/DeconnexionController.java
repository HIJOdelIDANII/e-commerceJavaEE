package com.ecommerce.presentation;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Controller pour la déconnexion (invalider la session).
 */
public class DeconnexionController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Redirection vers la page de login ou d'accueil
        response.sendRedirect(request.getContextPath() + "/login");
    }
}
