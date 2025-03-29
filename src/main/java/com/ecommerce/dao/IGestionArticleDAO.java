package com.ecommerce.dao;

import com.ecommerce.metier.Article;
import java.util.List;

public interface IGestionArticleDAO {
    void ajouterArticle(Article article);
    Article trouverArticleParId(int id);
    List<Article> listerArticles();
    void modifierArticle(Article article);
    void supprimerArticle(int id);
}
