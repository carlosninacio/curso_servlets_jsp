package web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "CookiesServlet", urlPatterns = {"/CookiesServlet"})
public class CookiesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Suponemos que el usuario visita por primera vez nuestro sitio
        boolean nuevoUsuario = true;
        // Obtenemos el arreglo de cookies
        Cookie[] cookies = request.getCookies();
        
        // Buscamos si ya existe una cookie creada con anterioridad
        // llamada visitanteRecurrente
        if(cookies != null) {
            for(Cookie c: cookies) {
                if(c.getName().equals("visitanteRecurrente") && c.getValue().equals("si")) {
                    nuevoUsuario = false;
                    break;
                }
            }
        }
        
        String mensaje;
        if(nuevoUsuario) {
            // Creamos una nueva cookie para identificar al usuario recurrente
            Cookie visitanteCookie = new Cookie("visitanteRecurrente", "si");
            response.addCookie(visitanteCookie);
            mensaje = "Gracias por visitar nuestro sitio por primera vez";
        } else {
            mensaje = "Gracias por visitar nuevamente nuestro sitio";
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Cookies</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Manejo de Cookies</h1>");
            out.println("<p>Mensaje: " + mensaje + "</p>");
            out.println("</body>");
            out.println("</html>");
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
