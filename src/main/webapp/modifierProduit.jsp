<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Produit" %>
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

<%
    Object user = session.getAttribute("user");
    if (user != null) {
%>
<a href="ajouterProduit.jsp">Add Product</a>
<a href="auth">Logout</a>
<%
    }
%>

<h2>Product List</h2>

<%-- Boucle pour afficher les produits --%>
<%
    List<Produit> produits = (List<Produit>) request.getAttribute("produits");
    if (produits != null) {
%>
<table>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Actions</th>
    </tr>
    <%
        for (Produit produit : produits) {
    %>
    <tr>
        <td><%= produit.getNom() %></td>
        <td><%= produit.getPrix() %></td>
        <td>
            <a href="produits?action=details&id=<%= produit.getId() %>">Details</a>
            <a href="produits?action=delete&id=<%= produit.getId() %>" onclick="return confirm('Are you sure?');">Delete</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
<%
    }
%>

</body>
</html>
