package com.ecommerce.presentation;

import com.ecommerce.metier.Article;
import com.ecommerce.metier.IGestionArticle;
import com.ecommerce.metier.GestionArticle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/ArticleController")
public class ArticleController extends HttpServlet {

    private IGestionArticle gestionArticle;

    @Override
    public void init() throws ServletException {
        gestionArticle = new GestionArticle();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Check user session if needed
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            // Not logged in => redirect
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // Determine the 'action' parameter to decide what's next
        String action = request.getParameter("action");
        if (action == null || action.isEmpty()) {
            // Show the list
            List<Article> articles = gestionArticle.getAllArticles();
            request.setAttribute("articles", articles);
            request.getRequestDispatcher("/WEB-INF/views/listeArticles.jsp").forward(request, response);
        }
        else if (action.equals("detail")) {
            // Show detail of a single article
            String idStr = request.getParameter("id");
            if (idStr != null) {
                int id = Integer.parseInt(idStr);
                Article art = gestionArticle.getArticleById(id);
                request.setAttribute("article", art);
                request.getRequestDispatcher("/WEB-INF/views/detailArticle.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/ArticleController");
            }
        }
        else if (action.equals("ajout")) {
            // Show add form
            request.getRequestDispatcher("/WEB-INF/views/ajoutArticle.jsp").forward(request, response);
        }
        else {
            // Unknown action => go back to the list
            response.sendRedirect(request.getContextPath() + "/ArticleController");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Check session again for POST
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
            // Creating a new article
            String titre = request.getParameter("titre");
            String description = request.getParameter("description");
            double prix = Double.parseDouble(request.getParameter("prix"));

            Article article = new Article();
            article.setTitre(titre);
            article.setDescription(description);
            article.setPrix(prix);

            gestionArticle.creerArticle(article);

            // Redirect to the list
            response.sendRedirect(request.getContextPath() + "/ArticleController");
        }
        else {
            // Other POST actions not implemented
            response.sendRedirect(request.getContextPath() + "/ArticleController");
        }
    }
}
