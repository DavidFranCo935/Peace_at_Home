<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Iniciar Sesión - PeaceAtHome</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f9; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }
        .login-box { background: white; padding: 30px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); width: 300px; }
        h2 { text-align: center; margin-bottom: 20px; color: #333; }
        .input-group { margin-bottom: 15px; }
        .input-group label { display: block; margin-bottom: 5px; color: #666; }
        .input-group input { width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; }
        button { width: 100%; padding: 10px; background-color: #007bff; border: none; color: white; border-radius: 4px; cursor: pointer; font-size: 16px; }
        button:hover { background-color: #0056b3; }
        .error-msg { color: red; text-align: center; margin-top: 15px; font-size: 14px; }
    </style>
</head>
<body>

<div class="login-box">
    <h2>PeaceAtHome</h2>
    <form action="login" method="POST">
        <div class="input-group">
            <label for="correo">Correo Electrónico:</label>
            <input type="email" id="correo" name="correo" required placeholder="ejemplo@correo.com">
        </div>
        <div class="input-group">
            <label for="contrasena">Contraseña:</label>
            <input type="password" id="contrasena" name="contrasena" required placeholder="********">
        </div>
        <button type="submit">Ingresar</button>
    </form>

    <%-- Si el LoginServlet detecta un error, lo pintará aquí --%>
    <% if (request.getAttribute("error") != null) { %>
        <p class="error-msg"><%= request.getAttribute("error") %></p>
    <% } %>
</div>

</body>
</html>