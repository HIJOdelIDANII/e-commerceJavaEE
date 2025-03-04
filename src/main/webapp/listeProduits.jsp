<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 5px;
        }
    </style>
</head>
<body>

<c:if test="${not empty sessionScope.user}">
    <a href="ajouterProduit.jsp">Add Product</a>
    <a href="auth">Logout</a>
</c:if>

<h2>Product List</h2>

<table>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Actions</th>
    </tr>
    <table>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="produit" items="${produits}">
            <tr>
                <td>${produit.nom}</td>
                <td>${produit.prix}</td>
                <td>
                    <a href="produits?action=details&id=${produit.id}">Details</a>
                    <a href="produits?action=delete&id=${produit.id}" onclick="return confirm('Are you sure?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</table>

</body>
</html>
