package com.ecommerce.metier;

import com.ecommerce.dao.IGestionArticleDAO;
import com.ecommerce.dao.GestionArticleDAO;

import java.util.List;

public class GestionArticle implements IGestionArticle {

    private IGestionArticleDAO articleDAO;

    /**
     * No-args constructor for default usage in controllers:
     * e.g.  this.gestionArticle = new GestionArticle();
     */
    public GestionArticle() {
        // Provide a default DAO implementation
        this.articleDAO = new GestionArticleDAO();
    }

    /**
     * Optional constructor to allow explicit DAO injection.
     */
    public GestionArticle(IGestionArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    @Override
    public void creerArticle(Article article) {
        articleDAO.ajouterArticle(article);
    }

    @Override
    public Article getArticleById(int id) {
        return articleDAO.trouverArticleParId(id);
    }

    @Override
    public List<Article> getAllArticles() {
        return articleDAO.listerArticles();
    }

    @Override
    public void updateArticle(Article article) {
        articleDAO.modifierArticle(article);
    }

    @Override
    public void deleteArticle(int id) {
        articleDAO.supprimerArticle(id);
    }
}
