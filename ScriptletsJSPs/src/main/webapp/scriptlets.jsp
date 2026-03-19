<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con Scriptlets</title>
    </head>
    <body>
        <h1>JSP con Scriptlets</h1>
        <br/>
        <!--Scriptlet para enviar información al navegador-->
        <% 
            out.println("Saludos desde un Scriptlet");
        %>
        <br/>
        <!--Scriptlet para acceder a los objetos implicitos-->
        <% 
            String nombreAplicacion = request.getContextPath();
            out.println("Nombre de la aplicación: " + nombreAplicacion);
        %>
    </body>
</html>
