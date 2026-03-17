package web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ContadorVisitasServlet", urlPatterns = {"/ContadorVisitasServlet"})
public class ContadorVisitasServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtener todas las cookies
        Cookie[] cookies = request.getCookies();
        int contador = 0;
        
        // Buscar la cookie contador
        if (cookies!=null) {
            for(Cookie c: cookies) {
                if ("contadorVisitas".equals(c.getName())) {
                    contador = Integer.parseInt(c.getValue());
                }
            }
        }
        
        // Incrementamos el contador de visitas
        contador++;
        
        // Crear una nueva cookie con el valor del contador actualizado
        Cookie cookie = new Cookie("contadorVisitas", Integer.toString(contador));
        cookie.setMaxAge(3600); // La cookie durará 1 hora
        response.addCookie(cookie);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Contador de Visitas con Cookies</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Número de visitas: " + contador + "</h1>");
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
