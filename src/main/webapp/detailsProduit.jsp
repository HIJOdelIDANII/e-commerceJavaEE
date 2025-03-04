<%@ page import="model.Produit" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product Details</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        h1 { color: #333; }
        .product-details { margin-top: 20px; }
        .product-details img { max-width: 300px; border: 1px solid #ccc; }
        .product-details p { margin: 10px 0; }
        .error { color: red; }
        a { display: inline-block; margin-top: 20px; color: #4CAF50; text-decoration: none; }
        a:hover { text-decoration: underline; }
    </style>
</head>
<body>

<h1>Product Details</h1>

<%
    Produit produit = (Produit) request.getAttribute("produit");
    if (produit != null) {
%>
<div class="product-details">
    <p><strong>ID:</strong> <%= produit.getId() %></p>
    <p><strong>Name:</strong> <%= produit.getNom() %></p>
    <p><strong>Description:</strong> <%= produit.getDescription() %></p>
    <p><strong>Price:</strong> <%= produit.getPrix() %> €</p>
    <p><strong>Image:</strong><br>
        <img src="<%= produit.getImage() %>" alt="<%= produit.getNom() %>" onerror="this.src='default.png';">
    </p>
</div>
<% } else { %>
<p class="error">Product not found.</p>
<% } %>

<p><a href="produits">← Back to Product List</a></p>

</body>
</html>
