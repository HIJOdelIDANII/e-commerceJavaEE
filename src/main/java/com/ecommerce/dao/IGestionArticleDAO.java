package com.ecommerce.dao;

import com.ecommerce.metier.Article;
import java.util.List;

public interface IGestionArticleDAO {
    void creerArticle(Article a);
    List<Article> getAllArticles();
    Article getArticleById(int id);
    void supprimerArticle(int id);
}
