<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
  <title>Bienvenue</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css"/>
</head>
<body>
<div class="navbar">
  <a href="<%= request.getContextPath() %>/Bienvenue">Accueil</a>
  <a href="<%= request.getContextPath() %>/login">Se connecter</a>
  <a href="<%= request.getContextPath() %>/inscription">S'inscrire</a>
  <a href="<%= request.getContextPath() %>/ArticleController">Articles</a>
  <a href="<%= request.getContextPath() %>/DeconnexionController">Se déconnecter</a>
</div>

<div class="container">
  <h1>Bienvenue sur notre e-commerce</h1>
  <p>Utilisez la barre de navigation ci-dessus pour vous connecter ou explorer les articles.</p>
</div>
</body>
</html>
