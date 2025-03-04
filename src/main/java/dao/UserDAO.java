package dao;

import model.User;
import org.mindrot.jbcrypt.BCrypt;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class UserDAO {
    private static String dbUrl;
    private static String dbUser;
    private static String dbPassword;

    // Static block to load database properties
    static {
        try (InputStream input = UserDAO.class.getClassLoader().getResourceAsStream("db.properties")) {
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

    // Method to get a database connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    // Method to find a user by username
    public User findUserByUsername(String username) {
        User user = null;
        String sql = "SELECT * FROM users WHERE username = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password")); // Already hashed
                    user.setEmail(rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Method to create a new user
    public boolean createUser(User user) {
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, hashedPassword);
            stmt.setString(3, user.getEmail());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to validate user credentials
    public boolean validateUser(String username, String password) {
        User user = findUserByUsername(username);
        return user != null && BCrypt.checkpw(password, user.getPassword());
    }
}