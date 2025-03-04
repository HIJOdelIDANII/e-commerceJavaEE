<%@ page import="model.Produit" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 10px; text-align: left; border: 1px solid #ddd; }
        th { background-color: #f2f2f2; }
        a { color: #4CAF50; text-decoration: none; padding: 5px 10px; }
        a:hover { background-color: #f0f0f0; }
        .actions { display: flex; gap: 10px; }
    </style>
</head>
<body>

<%
    Object user = session.getAttribute("user");
    if (user != null) {
%>
<a href="ajouterProduit.jsp">Add Product</a> |
<a href="auth">Logout</a>
<% } %>

<h2>Product List</h2>

<%
    List<Produit> produits = (List<Produit>) request.getAttribute("produits");
    if (produits != null && !produits.isEmpty()) {
%>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <% for (Produit produit : produits) { %>
    <tr>
        <td><%= produit.getNom() %></td>
        <td><%= produit.getPrix() %> €</td>
        <td class="actions">
            <a href="produits?action=details&id=<%= produit.getId() %>">Details</a>
            <a href="produits?action=delete&id=<%= produit.getId() %>" onclick="return confirm('Are you sure?');">Delete</a>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
<% } else { %>
<p>No products available.</p>
<% } %>

</body>
</html>
