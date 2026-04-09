<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Despliegue de Variables</title>
    </head>
    <body>
        <h1>Despliegue de Variables</h1>
        Variable en alcance request: ${mensaje}
        <br/><br/>
        Variable en alcance sesión:
        <br/>
        <!--No se especifica alcance, se busca sola en todos los alcances-->
        Rectangulo:<br/>
        - Base: ${rectangulo.base}<br/>
        - Altura: ${rectangulo.altura}<br/>
        - Area: ${rectangulo.area}<br/><br/>
        <a href="${pageContext.request.contextPath}/index.jsp">Regresar al Inicio</a>
    </body>
</html>
