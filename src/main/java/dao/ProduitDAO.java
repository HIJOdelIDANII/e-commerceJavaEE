package dao;

import model.Produit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO {


    private Connection getConnection() throws SQLException {
        return DB.getConnection();  // Fetch the connection from DB.java
    }


    public List<Produit> getAllProduits() {
        List<Produit> produits = new ArrayList<>();
        String sql = "SELECT * FROM produits";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("get out");

            while (rs.next()) {
                Produit p = new Produit();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setDescription(rs.getString("description"));
                p.setPrix(rs.getDouble("prix"));
                p.setImage(rs.getString("image"));
                produits.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }


    public Produit getProduitById(int id) {
        String sql = "SELECT * FROM produits WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Produit p = new Produit();
                    p.setId(rs.getInt("id"));
                    p.setNom(rs.getString("nom"));
                    p.setDescription(rs.getString("description"));
                    p.setPrix(rs.getDouble("prix"));
                    p.setImage(rs.getString("image"));
                    return p;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addProduit1(Produit produit) throws SQLException {
        String sql = "INSERT INTO produits (nom, description, prix, image) VALUES (?, ?, ?, ?)"; // dw ?? are placeholders

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // Set parameters in the PreparedStatement
            stmt.setString(1, produit.getNom());
            stmt.setString(2, produit.getDescription());
            stmt.setDouble(3, produit.getPrix());
            stmt.setString(4, produit.getImage());

            // Execute the update (INSERT statement)
            int rowsAffected = stmt.executeUpdate();

            // If insert was successful, get the generated keys
            if (rowsAffected > 0) {
                System.out.println("debug 00");

                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    System.out.println("debug 01");
                    if (generatedKeys.next()) {
                        System.out.println("debug 02");
                        // Set the generated product ID
                        produit.setId(generatedKeys.getInt(1));
                    }
                }
            } else {
                // If no rows were affected, throw an exception
                throw new SQLException("Inserting product failed, no rows affected.");
            }

        } catch (SQLException e) {
            // Log the error for debugging purposes
            System.err.println("Error while inserting product: " + e.getMessage());

            // Rethrow the exception with a more specific message
            throw new SQLException("Failed to add product due to database error", e);
        }
    }



    public void updateProduit(Produit produit) throws SQLException {
        String sql = "UPDATE produits SET nom = ?, description = ?, prix = ?, image = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produit.getNom());
            stmt.setString(2, produit.getDescription());
            stmt.setDouble(3, produit.getPrix());
            stmt.setString(4, produit.getImage());
            stmt.setInt(5, produit.getId());
            stmt.executeUpdate();
        }
    }


    public void deleteProduit(int id) throws SQLException {
        String sql = "DELETE FROM produits WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
