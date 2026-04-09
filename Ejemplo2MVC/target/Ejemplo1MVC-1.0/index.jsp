<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo 2 MVC</title>
    </head>
    <body>
        <h1>Ejemplo 2 MVC</h1>
        <br/>
        <div style="color:red">${mensaje}</div>
        <br/>
        <a href="${pageContext.request.contextPath}/ServletControlador">
        Link al servlet controlador sin parametros</a>
        <br/><br/>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=agregarVariables">
        Link al servlet controlador para agregar las variables</a>
        <br/><br/>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=listarVariables">
        Link al servlet controlador para listar variables</a>
    </body>
</html>
