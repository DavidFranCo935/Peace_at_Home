package com.peaceathome.controller;

import data.UsuarioDAO; // Ajusta esto si tu UsuarioDAO está en com.peaceathome.dao o en la carpeta data externa
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    
    // Instanciamos la capa de datos para validar las credenciales
    // NOTA: Si dejaste tu UsuarioDAO en la carpeta 'data' externa, cambia el import de arriba a: import data.UsuarioDAO;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Capturar los datos enviados desde el formulario HTML/JSP
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");

        // Validar usando el DAO que creamos antes
        boolean esValido = usuarioDAO.validarLogin(correo, contrasena);

        if (esValido) {
            // Login exitoso: Creamos la sesión del usuario en el servidor
            HttpSession session = request.getSession();
            session.setAttribute("usuario", correo);
            
            // Redireccionamos a la página de bienvenida (un dashboard o menú principal)
            response.sendRedirect("dashboard.jsp");
        } else {
            // Login fallido: Volvemos a la página de login enviando un mensaje de error
            request.setAttribute("error", "Correo o contraseña incorrectos.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}