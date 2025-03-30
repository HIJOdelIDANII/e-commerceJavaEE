package com.ecommerce.dao;

import com.ecommerce.metier.Article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestionArticleDAO implements IGestionArticleDAO {

    private Connection connection;

    public GestionArticleDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3333/ecommerce", "my_user", "my_password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void creerArticle(Article a) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO articles (titre, description, prix) VALUES (?, ?, ?)");
            ps.setString(1, a.getTitre());
            ps.setString(2, a.getDescription());
            ps.setDouble(3, a.getPrix());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Article> getAllArticles() {
        List<Article> list = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM articles");
            while (rs.next()) {
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.setTitre(rs.getString("titre"));
                a.setDescription(rs.getString("description"));
                a.setPrix(rs.getDouble("prix"));
                list.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Article getArticleById(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM articles WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Article a = new Article();
                a.setId(rs.getInt("id"));
                a.setTitre(rs.getString("titre"));
                a.setDescription(rs.getString("description"));
                a.setPrix(rs.getDouble("prix"));
                return a;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void supprimerArticle(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM articles WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
