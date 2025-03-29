package com.ecommerce.metier;

import java.util.List;

public interface IGestionArticle {
    // Créer un nouvel article
    void creerArticle(Article article);

    // Récupérer un article par son ID
    Article getArticleById(int id);

    // Récupérer tous les articles
    List<Article> getAllArticles();

    // Mettre à jour un article
    void updateArticle(Article article);

    // Supprimer un article
    void deleteArticle(int id);
}
