<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page import="com.ecommerce.metier.Article" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Liste des Articles</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css"/>
</head>
<body>
<div class="navbar">
  <a href="<%= request.getContextPath() %>/Bienvenue">Accueil</a>
  <a href="<%= request.getContextPath() %>/ArticleController?action=ajout">Ajouter un article</a>
  <a href="<%= request.getContextPath() %>/DeconnexionController">Se déconnecter</a>
</div>

<div class="container">
  <h1>Liste des Articles</h1>

  <table>
    <thead>
    <tr>
      <th>ID</th>
      <th>Titre</th>
      <th>Description</th>
      <th>Prix</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="art" items="${articles}">
      <tr>
        <td>${art.id}</td>
        <td>${art.titre}</td>
        <td>${art.description}</td>
        <td>${art.prix}</td>
        <td>
          <!-- Passing the ID via scriptlet or JSTL is fine -->
          <a href="<%= request.getContextPath() %>/ArticleController?action=detail&id=${art.id}">
            Voir détails
          </a>
          <!-- If you want a separate delete link, for example: -->
          <!-- <a href="<%= request.getContextPath() %>/ArticleController?action=delete&id=${art.id}"
                                 onclick="return confirm('Confirmer suppression?');">
                                 Supprimer
                             </a> -->
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>

  <p><a href="<%= request.getContextPath() %>/Bienvenue">Retour à l'accueil</a></p>
</div>
</body>
</html>
