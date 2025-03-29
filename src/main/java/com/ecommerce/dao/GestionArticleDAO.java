package com.ecommerce.dao;

import com.ecommerce.metier.Article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestionArticleDAO implements IGestionArticleDAO {

    private Connection connection;

    public GestionArticleDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // or com.mysql.cj.jdbc.Driver
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ecommerce",
                    "root",
                    ""
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ajouterArticle(Article article) {
        String sql = "INSERT INTO articles(titre, description, prix) VALUES(?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, article.getTitre());
            ps.setString(2, article.getDescription());
            ps.setDouble(3, article.getPrix());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Article trouverArticleParId(int id) {
        Article article = null;
        String sql = "SELECT * FROM articles WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    article = new Article(
                            rs.getInt("id"),
                            rs.getString("titre"),
                            rs.getString("description"),
                            rs.getDouble("prix")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return article;
    }

    @Override
    public List<Article> listerArticles() {
        List<Article> liste = new ArrayList<>();
        String sql = "SELECT * FROM articles";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Article art = new Article(
                        rs.getInt("id"),
                        rs.getString("titre"),
                        rs.getString("description"),
                        rs.getDouble("prix")
                );
                liste.add(art);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }

    @Override
    public void modifierArticle(Article article) {
        String sql = "UPDATE articles SET titre=?, description=?, prix=? WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, article.getTitre());
            ps.setString(2, article.getDescription());
            ps.setDouble(3, article.getPrix());
            ps.setInt(4, article.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerArticle(int id) {
        String sql = "DELETE FROM articles WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
