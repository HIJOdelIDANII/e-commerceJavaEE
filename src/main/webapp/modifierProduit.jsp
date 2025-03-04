<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<h1>Edit Product</h1>
<c:if test="${not empty produit}">
    <form action="produits?action=update" method="post">
        <input type="hidden" name="id" value="${produit.id}">

        <label for="nom">Name:</label>
        <input type="text" id="nom" name="nom" value="${produit.nom}" required><br><br>

        <label for="description">Description:</label>
        <textarea id="description" name="description">${produit.description}</textarea><br><br>

        <label for="prix">Price:</label>
        <input type="number" id="prix" name="prix" value="${produit.prix}" step="0.01" required><br><br>

        <label for="image">Image URL:</label>
        <input type="text" id="image" name="image" value="${produit.image}"><br><br>

        <button type="submit">Update Product</button>
    </form>
</c:if>

<c:if test="${empty produit}">
    <p style="color: red;">Product not found.</p>
</c:if>

<p><a href="produits">Back to Product List</a></p>
</body>
</html>