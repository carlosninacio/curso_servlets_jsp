package cr.com.co;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/HolaMundo") //http:8080/HolaMundoJavaWeb/HolaMundo
public class HolaMundo extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charSet=UTF-8");
        var salida = response.getWriter();
        salida.print("Hola mundo desde Servlets");
    }
    
}