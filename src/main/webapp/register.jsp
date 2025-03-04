<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>Register</h1>
<form action="register" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email"><br><br>

    <button type="submit">Register</button>
</form>

<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>

<p>Already have an account? <a href="login.jsp">Login here</a>.</p>
</body>
</html>