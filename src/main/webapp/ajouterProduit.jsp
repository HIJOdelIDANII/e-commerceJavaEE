<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>
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

<h1>Add Product</h1>

    <%
    String error = (String) request.getAttribute("error");
    if (error != null) {
%>
<p class="error"><%= error %></p>
    <% } %>

<form action="produits" method="post">
    <input type="hidden" name="action" value="add" />
    <label for="nom">Product Name</label>
    <input type="text" id="nom" name="nom" required />

    <label for="description">Description</label>
    <input type="text" id="description" name="description" required />

    <label for="prix">Price</label>
    <input type="text" id="prix" name="prix" required />

    <label for="image">Image URL</label>
    <input type="text" id="image" name="image" />

    <button type="submit">Add Product</button>
</form>


<p><a href="produits">Back to Product List</a></p>

</body>
</html>

