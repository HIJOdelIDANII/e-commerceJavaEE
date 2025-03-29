<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Bienvenue</title>
  <!-- Link to CSS -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<!-- Optional Navbar -->
<div class="navbar">
  <a href="${pageContext.request.contextPath}/Bienvenue">Accueil</a>
  <a href="${pageContext.request.contextPath}/login">Se connecter</a>
  <a href="${pageContext.request.contextPath}/inscription">S'inscrire</a>
  <a href="${pageContext.request.contextPath}/ArticleController">Articles</a>
  <a href="${pageContext.request.contextPath}/DeconnexionController">Se déconnecter</a>
</div>

<div class="container">
  <h1>Bienvenue sur notre e-commerce</h1>
  <p>Utilisez la barre de navigation ci-dessus pour vous connecter ou explorer les articles.</p>
</div>
</body>
</html>
