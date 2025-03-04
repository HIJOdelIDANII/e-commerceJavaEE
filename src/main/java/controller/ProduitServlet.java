package controller;

import dao.ProduitDAO;
import model.Produit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProduitServlet", urlPatterns = {"/produits"})
public class ProduitServlet extends HttpServlet {
    private ProduitDAO produitDAO = new ProduitDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        HttpSession session = request.getSession(false);

        // Ensure user is logged in
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            switch (action != null ? action : "") {
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteProduit(request, response);
                    break;
                case "details":  // New case for showing product details
                    showDetails(request, response);
                    break;
                default:
                    listProduits(request, response);
                    break;
            }
        } catch (Exception e) {
            handleError(request, response, e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");

        try {
            switch (action != null ? action : "") {
                case "add":
                    addProduit(request, response);
                    break;
                case "update":
                    updateProduit(request, response);
                    break;
                default:
                    listProduits(request, response);
                    break;
            }
        } catch (Exception e) {
            handleError(request, response, e);
        }
    }

    // Display all products
    private void listProduits(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("produits", produitDAO.getAllProduits());
        request.getRequestDispatcher("/listeProduits.jsp").forward(request, response);
    }

    // Show the edit form for a specific product
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Produit existingProduit = produitDAO.getProduitById(id);
        if (existingProduit != null) {
            request.setAttribute("produit", existingProduit);
            request.getRequestDispatcher("/modifierProduit.jsp").forward(request, response);
        } else {
            response.sendRedirect("produits");
        }
    }

    // Add a new product
    private void addProduit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        Produit produit = new Produit();
        populateProduitFromRequest(produit, request);

        if (isValidProduit(produit)) {
            produitDAO.addProduit1(produit);
            response.sendRedirect("produits");
        } else {
            request.setAttribute("error", "Invalid product data");
            request.getRequestDispatcher("/ajouterProduit.jsp").forward(request, response);
        }
    }

    // Update an existing product
    private void updateProduit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Produit produit = produitDAO.getProduitById(id);

        if (produit != null) {
            populateProduitFromRequest(produit, request);
            if (isValidProduit(produit)) {
                produitDAO.updateProduit(produit);
                response.sendRedirect("produits");
            } else {
                request.setAttribute("error", "Invalid product data");
                request.setAttribute("produit", produit);
                request.getRequestDispatcher("/modifierProduit.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("produits");
        }
    }

    // Delete a product
    private void deleteProduit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        produitDAO.deleteProduit(id);
        response.sendRedirect("produits");
    }

    // Show product details
    private void showDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Produit produit = produitDAO.getProduitById(id);

        if (produit != null) {
            request.setAttribute("produit", produit);
            request.getRequestDispatcher("/detailsProduit.jsp").forward(request, response);
        } else {
            response.sendRedirect("produits");  // Redirect if product not found
        }
    }

    // Populate the product object with data from the form
    private void populateProduitFromRequest(Produit produit, HttpServletRequest request) {
        produit.setNom(request.getParameter("nom"));
        produit.setDescription(request.getParameter("description"));

        String prixStr = request.getParameter("prix");
        if (prixStr != null && !prixStr.trim().isEmpty()) {
            try {
                produit.setPrix(Double.parseDouble(prixStr));
            } catch (NumberFormatException e) {
                produit.setPrix(0.0);  // Set default value if invalid
            }
        } else {
            produit.setPrix(0.0);  // Set default value if empty
        }

        produit.setImage(request.getParameter("image"));
    }

    // Validate product data
    private boolean isValidProduit(Produit produit) {
        return produit.getNom() != null && !produit.getNom().trim().isEmpty() && produit.getPrix() > 0;
    }

    // Error handling method
    private void handleError(HttpServletRequest request, HttpServletResponse response, Exception e)
            throws ServletException, IOException {
        e.printStackTrace();
        request.setAttribute("error", "Operation failed: " + e.getMessage());
        listProduits(request, response);
    }
}
