<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Details</title>
</head>
<body>
<h1>Product Details</h1>
<c:if test="${not empty produit}">
    <p><strong>ID:</strong> ${produit.id}</p>
    <p><strong>Name:</strong> ${produit.nom}</p>
    <p><strong>Description:</strong> ${produit.description}</p>
    <p><strong>Price:</strong> ${produit.prix} €</p>
    <p><strong>Image:</strong> <img src="${produit.image}" alt="${produit.nom}" width="200"></p>
</c:if>

<c:if test="${empty produit}">
    <p style="color: red;">Product not found.</p>
</c:if>

<p><a href="produits">Back to Product List</a></p>
</body>
</html>