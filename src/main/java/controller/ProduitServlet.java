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

        // Redirect unauthenticated users
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

    private void listProduits(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("produits", produitDAO.getAllProduits());
        request.getRequestDispatcher("/listeProduits.jsp").forward(request, response);
    }

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

    private void addProduit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        Produit produit = new Produit();
        populateProduitFromRequest(produit, request);

        if (isValidProduit(produit)) {
            produitDAO.addProduit(produit);
            response.sendRedirect("produits");
        } else {
            request.setAttribute("error", "Invalid product data");
            request.getRequestDispatcher("/ajouterProduit.jsp").forward(request, response);
        }
    }

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

    private void deleteProduit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        produitDAO.deleteProduit(id);
        response.sendRedirect("produits");
    }

    private void populateProduitFromRequest(Produit produit, HttpServletRequest request) {
        produit.setNom(request.getParameter("nom"));
        produit.setDescription(request.getParameter("description"));
        try {
            produit.setPrix(Double.parseDouble(request.getParameter("prix")));
        } catch (NumberFormatException e) {
            produit.setPrix(0.0);
        }
        produit.setImage(request.getParameter("image"));
    }

    private boolean isValidProduit(Produit produit) {
        return !produit.getNom().isEmpty() && produit.getPrix() > 0;
    }

    private void handleError(HttpServletRequest request, HttpServletResponse response, Exception e)
            throws ServletException, IOException {
        e.printStackTrace();
        request.setAttribute("error", "Operation failed: " + e.getMessage());
        listProduits(request, response);
    }
}