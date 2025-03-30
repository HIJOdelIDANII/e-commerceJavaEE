<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page import="com.ecommerce.metier.Article" %>
<!DOCTYPE html>
<html>
<head>
    <title>Détails de l'Article</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css"/>
</head>
<body>
<div class="navbar">
    <a href="<%= request.getContextPath() %>/ArticleController">Liste des articles</a>
    <a href="<%= request.getContextPath() %>/Bienvenue">Accueil</a>
    <a href="<%= request.getContextPath() %>/DeconnexionController">Se déconnecter</a>
</div>

<div class="container">
    <h1>Détails de l'Article</h1>

    <%
        Article article = (Article) request.getAttribute("article");
        if (article != null) {
    %>
    <p><strong>ID:</strong> <%= article.getId() %></p>
    <p><strong>Titre:</strong> <%= article.getTitre() %></p>
    <p><strong>Description:</strong> <%= article.getDescription() %></p>
    <p><strong>Prix:</strong> <%= article.getPrix() %></p>
    <%
    } else {
    %>
    <p>Aucun article à afficher.</p>
    <%
        }
    %>

    <p><a href="<%= request.getContextPath() %>/ArticleController">Retour à la liste</a></p>
</div>
</body>
</html>
