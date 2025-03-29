<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
  <title>Inscription</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css"/>
</head>
<body>
<div class="navbar">
  <a href="<%= request.getContextPath() %>/Bienvenue">Accueil</a>
  <a href="<%= request.getContextPath() %>/login">Se connecter</a>
</div>

<div class="container">
  <h1>Créer un compte</h1>

  <form action="<%= request.getContextPath() %>/inscription" method="post">
    <label for="username">Nom d'utilisateur:</label>
    <input type="text" id="username" name="username" required /><br/><br/>

    <label for="password">Mot de passe:</label>
    <input type="password" id="password" name="password" required /><br/><br/>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required /><br/><br/>

    <input type="submit" value="S'inscrire"/>
