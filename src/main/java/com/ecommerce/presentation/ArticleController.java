package com.ecommerce.presentation;

import com.ecommerce.metier.Article;
import com.ecommerce.metier.IGestionArticle;
import com.ecommerce.metier.GestionArticle;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ArticleController extends HttpServlet {

    private IGestionArticle gestionArticle;

    @Override
    public void init() throws ServletException {
        // Now works fine with no-args constructor
        this.gestionArticle = new GestionArticle();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Vérifier si l'utilisateur est connecté (sinon redirection)
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String action = request.getParameter("action");
        if (action == null || action.isEmpty()) {
            // Liste des articles
            List<Article> articles = gestionArticle.getAllArticles();
            request.setAttribute("articles", articles);
            request.getRequestDispatcher("/WEB-INF/views/listeArticles.jsp").forward(request, response);
        }
        else if (action.equals("detail")) {
            // Détail d'un article
            String idStr = request.getParameter("id");
            if (idStr != null) {
                int id = Integer.parseInt(idStr);
                Article art = gestionArticle.getArticleById(id);
                request.setAttribute("article", art);
                request.getRequestDispatcher("/WEB-INF/views/detailArticle.jsp").forward(request, response);
            } else {
                // Pas d'id => liste
                response.sendRedirect(request.getContextPath() + "/ArticleController");
            }
        }
        else if (action.equals("ajout")) {
            // Formulaire d'ajout
            request.getRequestDispatcher("/WEB-INF/views/ajoutArticle.jsp").forward(request, response);
        }
        else {
            // Action inconnue => liste
            response.sendRedirect(request.getContextPath() + "/ArticleController");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        if (action.equals("ajout")) {
            // Récupérer les données du formulaire
            String titre = request.getParameter("titre");
            String desc  = request.getParameter("description");
            double prix  = Double.parseDouble(request.getParameter("prix"));

            // Créer l'article
            Article article = new Article();
            article.setTitre(titre);
            article.setDescription(desc);
            article.setPrix(prix);

            gestionArticle.creerArticle(article);

            // Redirection vers la liste
            response.sendRedirect(request.getContextPath() + "/ArticleController");
        }
        else {
            // Autres actions => liste
            response.sendRedirect(request.getContextPath() + "/ArticleController");
        }
    }
}
