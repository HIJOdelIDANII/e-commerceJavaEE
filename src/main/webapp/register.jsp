<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 20px; }
        form { max-width: 500px; margin: auto; padding: 15px; border: 1px solid #ccc; background-color: #f9f9f9; }
        input, button { width: 100%; padding: 10px; margin: 10px 0; }
        button { background-color: #4CAF50; color: white; border: none; cursor: pointer; }
        button:hover { background-color: #45a049; }
        .error { color: red; text-align: center; }
        a { display: block; text-align: center; margin-top: 10px; }
    </style>
</head>
<body>

<h1>Register</h1>

<%
    String error = (String) request.getAttribute("error");
    if (error != null) {
%>
<p class="error"><%= error %></p>
<% } %>

<form action="register" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email">

    <button type="submit">Register</button>
</form>

<p>Already have an account? <a href="login.jsp">Login here</a>.</p>

</body>
</html>
