package com.ecommerce.metier;

import com.ecommerce.dao.IGestionArticleDAO;
import com.ecommerce.dao.GestionArticleDAO;

import java.util.List;

public class GestionArticle implements IGestionArticle {

    private IGestionArticleDAO articleDAO;

    public GestionArticle() {
        articleDAO = new GestionArticleDAO();
    }

    @Override
    public void creerArticle(Article a) {
        articleDAO.creerArticle(a);
    }

    @Override
    public List<Article> getAllArticles() {
        return articleDAO.getAllArticles();
    }

    @Override
    public Article getArticleById(int id) {
        return articleDAO.getArticleById(id);
    }

    @Override
    public void supprimerArticle(int id) {
        articleDAO.supprimerArticle(id);
    }
}
