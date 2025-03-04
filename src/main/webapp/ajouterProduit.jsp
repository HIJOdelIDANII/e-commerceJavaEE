<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<h1>Add Product</h1>
<form action="produits?action=add" method="post">
    <label for="nom">Name:</label>
    <input type="text" id="nom" name="nom" required><br><br>

    <label for="description">Description:</label>
    <textarea id="description" name="description"></textarea><br><br>

    <label for="prix">Price:</label>
    <input type="number" id="prix" name="prix" step="0.01" required><br><br>

    <label for="image">Image URL:</label>
    <input type="text" id="image" name="image"><br><br>

    <button type="submit">Add Product</button>
</form>

<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>

<p><a href="produits">Back to Product List</a></p>
</body>
</html>