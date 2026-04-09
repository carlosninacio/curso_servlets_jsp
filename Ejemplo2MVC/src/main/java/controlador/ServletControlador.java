package controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
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
        if("agregarVariables".equals(accion)) {
            // Alcance request
            request.setAttribute("rectanguloRequest", rectanguloRequest);
            // Alcance session
            HttpSession sesion = request.getSession();
            sesion.setAttribute("rectanguloSession", rectanguloSession); // Se comparte el modelo
            // Alcance application
            ServletContext application = this.getServletContext();
            application.setAttribute("rectanguloApplication", rectanguloApplication);
            
            // Agregar mensaje
            request.setAttribute("mensaje", "Las variables fueron agregadas");
            
            // 4. Redireccionar al JSP de Index
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if("listarVariables".equals(accion)) {
            // Redirigir al JSP que despliega las variables
            request.getRequestDispatcher("WEB/INF/alcanceVariables.jsp").forward(request, response);
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