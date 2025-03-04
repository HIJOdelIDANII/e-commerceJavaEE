<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<c:if test="${not empty sessionScope.user}">
    <a href="ajouterProduit.jsp">Add Product</a>
    <a href="auth">Logout</a>
</c:if>
<table>
    <c:forEach items="${produits}" var="produit">
        <tr>
            <td>${produit.nom}</td>
            <td>${produit.prix}</td>
            <td>
                <c:if test="${not empty sessionScope.user}">
                    <a href="modifierProduit.jsp?id=${produit.id}">Edit</a>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>