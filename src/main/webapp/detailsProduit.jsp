<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Product Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h1 {
            color: #333;
        }
        .product-details img {
            border: 1px solid #ccc;
            padding: 5px;
            max-width: 300px;
        }
        .product-details p {
            margin: 10px 0;
        }
        .error {
            color: red;
        }
        a {
            display: inline-block;
            margin-top: 20px;
        }
    </style>
</head>
<body>

<h1>Product Details</h1>

<c:if test="${not empty produit}">
    <div class="product-details">
        <p><strong>ID:</strong> ${produit.id}</p>
        <p><strong>Name:</strong> ${produit.nom}</p>
        <p><strong>Description:</strong> ${produit.description}</p>
        <p><strong>Price:</strong> ${produit.prix} €</p>
        <p><strong>Image:</strong><br>
            <img src="${produit.image}" alt="${produit.nom}" onerror="this.src='default.png';">
        </p>
    </div>
</c:if>

<c:if test="${empty produit}">
    <p class="error">Product not found.</p>
</c:if>

<p><a href="produits">← Back to Product List</a></p>

</body>
</html>
