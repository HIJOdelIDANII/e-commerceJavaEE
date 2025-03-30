package com.ecommerce.metier;

import java.util.List;

public interface IGestionArticle {
    void creerArticle(Article a);
    List<Article> getAllArticles();
    Article getArticleById(int id);
    void supprimerArticle(int id); // <-- add this line
}

