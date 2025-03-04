package dao;

import model.Produit;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProduitDAO {
    private static String dbUrl;
    private static String dbUser;
    private static String dbPassword;
    static {
        try (InputStream input = ProduitDAO.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            dbUrl = prop.getProperty("db.url");
            dbUser = prop.getProperty("db.user");
            dbPassword = prop.getProperty("db.password");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load database properties");
        }
    }
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    public List<Produit> getAllProduits() {
        List<Produit> produits = new ArrayList<>();
        String sql = "SELECT * FROM produits";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

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

    public void addProduit(Produit produit) throws SQLException {
        String sql = "INSERT INTO produits (nom, description, prix, image) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, produit.getNom());
            stmt.setString(2, produit.getDescription());
            stmt.setDouble(3, produit.getPrix());
            stmt.setString(4, produit.getImage());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    produit.setId(generatedKeys.getInt(1));
                }
            }
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