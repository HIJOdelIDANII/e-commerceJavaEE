<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ajouter un Article</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css"/>
</head>
<body>
<div class="navbar">
    <a href="<%= request.getContextPath() %>/ArticleController">Liste des articles</a>
    <a href="<%= request.getContextPath() %>/Bienvenue">Accueil</a>
    <a href="<%= request.getContextPath() %>/DeconnexionController">Se déconnecter</a>
</div>

<div class="container">
    <h1>Ajouter un Article</h1>

    <form action="<%= request.getContextPath() %>/ArticleController" method="post">
        <input type="hidden" name="action" value="ajout" />

        <label for="titre">Titre :</label>
        <input type="text" name="titre" id="titre" required /><br/><br/>

        <label for="description">Description :</label>
        <input type="text" name="description" id="description" required /><br/><br/>

        <label for="prix">Prix :</label>
        <input type="number" step="0.01" name="prix" id="prix" required /><br/><br/>

        <input type="submit" value="Ajouter" />
    </form>
</div>
</body>
</html>
