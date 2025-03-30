<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Connexion</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css"/>
</head>
<body>
<div class="navbar">
    <a href="<%= request.getContextPath() %>/Bienvenue">Accueil</a>
    <a href="<%= request.getContextPath() %>/inscription">S'inscrire</a>
</div>

<div class="container">
    <h1>Connexion</h1>

    <%
        String errorMsg = (String) request.getAttribute("errorMsg");
        if (errorMsg != null && !errorMsg.isEmpty()) {
    %>
    <div class="errorMsg"><%= errorMsg %></div>
    <%
        }
    %>

    <form action="<%= request.getContextPath() %>/login" method="post">
        <label for="username">Nom d'utilisateur:</label>
        <input type="text" id="username" name="username" required /><br/><br/>

        <label for="password">Mot de passe:</label>
        <input type="password" id="password" name="password" required /><br/><br/>

        <input type="submit" value="Se connecter"/>
    </form>
</div>
</body>
</html>
