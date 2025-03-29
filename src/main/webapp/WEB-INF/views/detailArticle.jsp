<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page import="com.ecommerce.metier.Article" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

    <p><strong>ID:</strong> ${article.id}</p>
    <p><strong>Titre:</strong> ${article.titre}</
