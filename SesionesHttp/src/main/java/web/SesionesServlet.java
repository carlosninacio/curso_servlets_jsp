package web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "SesionesServlet", urlPatterns = {"/SesionesServlet"})
public class SesionesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtener el objeto session
        HttpSession sesion = request.getSession(); // Es una Cookie que se genera de manera automatica
        
        // Atributos de la sesión
        String titulo;
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");
        
        // Validar si es la primera vez que se accede a la sesión
        if(contadorVisitas == null) {
            contadorVisitas = 1; // Primera vez
            titulo = "Bienvenido por primera vez";
        } else {
            contadorVisitas++; // Incrementar contador en visitas posteriores
            titulo = "Bienvenido nuevamente";
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Sesiones Http</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + titulo + "</h1>");
            out.println("<p>Número de accesos: " + contadorVisitas + "</p>");
            out.println("<p>ID de la sesión: " + sesion.getId() + "</p>");
            out.println("<a href='/SesionesHttp/index.html'>Volver al Inicio</a>");
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
