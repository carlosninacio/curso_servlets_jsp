package web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Datos correctos simulados
        var usuarioOk = "admin";
        var passwordOk = "12345";
        
        // Recuperar valores del formulario
        var usuario = request.getParameter("usuario");
        var password = request.getParameter("password");
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            if(usuarioOk.equals(usuario) && passwordOk.equals(password)) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Autenticación Exitosa</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Autenticación Exitosa</h1>");
                out.println("<p>Bienvenido: " + usuario + "</p>");
                out.println("</body>");
                out.println("</html>");                
            } else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Credenciales Incorrectas");
            }
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
