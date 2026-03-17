package web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "HoraServlet", urlPatterns = {"/HoraServlet"})
public class HoraServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        // Agregamos un cabecero para refrescar la página cada segundo
        response.setHeader("refresh", "1");
        
        // Obtener la hora actual y aplicar formato
        LocalTime horaActual = LocalTime.now();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("'Hora Actualizada' HH:mm:ss");
        String horaConFormato = horaActual.format(formateador);
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Actualización de la hora</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + horaConFormato + "</h1>");
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
