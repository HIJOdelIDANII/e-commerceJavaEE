package com.ecommerce.presentation;

import com.ecommerce.metier.IGestionUser;
import com.ecommerce.metier.GestionUser;
import com.ecommerce.metier.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Controller pour la gestion de l'inscription (création de compte).
 */
public class InscriptionController extends HttpServlet {

    private IGestionUser gestionUser;

    @Override
    public void init() throws ServletException {
        this.gestionUser = new GestionUser();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Afficher le formulaire d'inscription
        request.getRequestDispatcher("/WEB-INF/views/inscription.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email    = request.getParameter("email");

        // Créer l'utilisateur
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);

        // Appel à la couche métier pour l'enregistrement
        gestionUser.creerUser(newUser);

        // Redirection ou affichage d'un message de succès
        // Par exemple, on redirige vers la page de login
        response.sendRedirect(request.getContextPath() + "/login");
    }
}
