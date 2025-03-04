<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Add Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        form {
            max-width: 400px;
            padding: 15px;
            border: 1px solid #ccc;
            background: #f9f9f9;
        }
        label {
            font-weight: bold;
        }
        input, textarea {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }
        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
        .error {
            color: red;
            font-weight: bold;
        }
        a {
            display: inline-block;
            margin-top: 15px;
        }
    </style>
</head>
<body>

<h1>Add Product</h1>

<form action="produits?action=add" method="post">
    <label for="nom">Name:</label>
    <input type="text" id="nom" name="nom" required>

    <label for="description">Description:</label>
    <textarea id="description" name="description"></textarea>

    <label for="prix">Price (€):</label>
    <input type="number" id="prix" name="prix" step="0.01" min="0" required>

    <label for="image">Image URL:</label>
    <input type="text" id="image" name="image">

    <button type="submit">Add Product</button>
</form>

<c:if test="${not empty error}">
    <p class="error">${error}</p>
</c:if>

<p><a href="produits">← Back to Product List</a></p>

</body>
</html>
