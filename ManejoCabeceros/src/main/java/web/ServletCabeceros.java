package web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@WebServlet(name = "ServletCabeceros", urlPatterns = {"/ServletCabeceros"})
public class ServletCabeceros extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String metodoHttp = request.getMethod();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cabeceros Http</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cabeceros Http</h1>");
            out.println("<br>");
            out.println("Método Http: " + metodoHttp);
            out.println("<br>");
            out.println("Uri solicitada: " + request.getRequestURI());
            out.println("<br>");
            out.println("<br>");
            Enumeration<String> cabeceros = request.getHeaderNames();
            while(cabeceros.hasMoreElements()) {
                String nombreCabecero = cabeceros.nextElement();
                out.println("<b>" + nombreCabecero + "</b>: ");
                out.println(request.getHeader(nombreCabecero));
                out.println("<br>");
            }
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
