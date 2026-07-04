<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // CONTROL DE ACCESO: Si no existe la sesión, rebota al usuario al login
    if (session.getAttribute("usuario") == null) {
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Panel Principal - PeaceAtHome</title>
    <style>
        body { font-family: Arial, sans-serif; padding: 40px; background-color: #fafafa; }
        .container { background: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.05); }
        .btn-logout { display: inline-block; margin-top: 20px; padding: 10px 15px; background: #dc3545; color: white; text-decoration: none; border-radius: 4px; }
        .btn-logout:hover { background: #bd2130; }
    </style>
</head>
<body>

<div class="container">
    <h1>¡Bienvenido a la plataforma PeaceAtHome!</h1>
    <p>Has iniciado sesión correctamente.</p>
    <p>Usuario activo: <strong><%= session.getAttribute("usuario") %></strong></p>
    
    <a href="logout.jsp" class="btn-logout">Cerrar Sesión</a>
</div>

</body>
</html>