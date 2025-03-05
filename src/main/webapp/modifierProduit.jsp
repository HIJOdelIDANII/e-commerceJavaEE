<%@ page import="model.Produit" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        form { max-width: 500px; margin: auto; padding: 15px; border: 1px solid #ccc; background-color: #f9f9f9; }
        input, textarea, button { width: 100%; padding: 10px; margin: 10px 0; }
        button { background-color: #4CAF50; color: white; border: none; cursor: pointer; }
        button:hover { background-color: #45a049; }
        .error { color: red; font-weight: bold; text-align: center; }
        a { display: inline-block; margin-top: 15px; }
    </style>
</head>
<body>

<h1>Edit Product</h1>

<%
    Produit produit = (Produit) request.getAttribute("produit");
    if (produit != null) {
%>

<form action="produits" method="post">
    <input type="hidden" name="action" value="update" /> <!-- Action to identify that we are updating a product -->
    <input type="hidden" name="id" value="<%= produit.getId() %>" /> <!-- Pass product ID to identify which product to update -->

    <label for="nom">Product Name</label>
    <input type="text" id="nom" name="nom" value="<%= produit.getNom() %>" required />

    <label for="description">Description</label>
    <input type="text" id="description" name="description" value="<%= produit.getDescription() %>" required />

    <label for="prix">Price</label>
    <input type="text" id="prix" name="prix" value="<%= produit.getPrix() %>" required />

    <label for="image">Image URL</label>
    <input type="text" id="image" name="image" value="<%= produit.getImage() %>" placeholder="Image URL" />

    <button type="submit">Update Product</button> <!-- Update button -->

</form>

<% } else { %>
<p class="error">Product not found.</p>
<% } %>

<p><a href="produits">Back to Product List</a></p>

</body>
</html>
