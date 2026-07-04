<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Invalidar y destruir la sesión actual del servidor
    session.invalidate();
    // Redirigir de nuevo al formulario de login
    response.sendRedirect("index.jsp");
%>