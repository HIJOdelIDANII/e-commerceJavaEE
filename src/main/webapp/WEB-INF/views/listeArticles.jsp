<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ecommerce.metier.Article" %>
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
    <%
      List<Article> articles = (List<Article>) request.getAttribute("articles");
      if (articles != null) {
        for (Article art : articles) {
    %>
    <tr>
      <td><%= art.getId() %></td>
      <td><%= art.getTitre() %></td>
      <td><%= art.getDescription() %></td>
      <td><%= art.getPrix() %></td>
      <td>
        <!-- Details link -->
        <a href="<%= request.getContextPath() %>/ArticleController?action=detail&id=<%= art.getId() %>">
          Voir détails
        </a>



                <a href="<%= request.getContextPath() %>/ArticleController?action=delete&id=<%= art.getId() %>"
                   onclick="return confirm('Supprimer cet article ?');">
                   Supprimer
                </a>

      </td>
    </tr>
    <%
        } // end for
      } // end if
    %>
    </tbody>
  </table>

  <p><a href="<%= request.getContextPath() %>/Bienvenue">Retour à l'accueil</a></p>
</div>

</body>
</html>
