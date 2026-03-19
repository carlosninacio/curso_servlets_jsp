<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hola Mundo JSPs</title>
    </head>
    <body>
        <h1>Hola Mundo JSPs</h1>
        <ul>
            // Lo que se coloque dentro de los scriptlets es para colocar codigo java
            <li> <% out.println("Hola Mundo con Scriptlets"); %> </li>
        </ul>
    </body>
</html>
