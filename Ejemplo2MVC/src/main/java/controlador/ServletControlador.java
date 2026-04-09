package controlador;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Rectangulo;

@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        // 1. Procesamiento de parámetros
        String accion = request.getParameter("accion");
    
        // 2. Crrear los JavaBeans (clases de Modelo)
        Rectangulo rectanguloRequest = new Rectangulo(1,2);
        Rectangulo rectanguloSession = new Rectangulo(3,4);
        Rectangulo rectanguloApplication = new Rectangulo(5,6);
    
        // 3. Agregar el JavaBean a algún alcance (request, session, application)
        request.setAttribute("mensaje", "Saludos desde el Servlet");
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("rectangulo", rectangulo); // Se comparte el modelo
        
        // 4. Redireccionar a la vista seleccionada
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("vistas/desplegarVariables.jsp");
        requestDispatcher.forward(request, response);
        
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