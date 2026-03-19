<!--Agregar declaración de un JSP-->

<!--Si no se usan declaraciones (!) y se usa un Scriptlet (sin !), no se podrán declarar ni metodos y atributos-->
<!--Las variables que se definan dentro de un scriptlet se definen dentro del metodo del Servlet-->
<!--Las declaraciones se agregan al inicio de la clase-->

<%!
    // Declarar una variable y su metodo get asociado
    private String usuario = "Carlos";

    public String getUsuario () {
        return this.usuario;
    }

    // Contador de Visitas
    private int contadorVisitas = 1;
%>

<%
    // Declaración de una variable con un scriptlet
    String nombre = "Carlos";
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Declaraciones en un JSP</title>
    </head>
    <body>
        <h1>Declaraciones en un JSP!</h1>
        <p>Valor usuario por medio del atributo: <%=this.usuario%></p>
        <br/>
        <p>Valor usuario por medio del método: <%=this.getUsuario()%></p>
        <br/>
        <p>Contador de Visitas: <%=this.contadorVisitas++%></p>
    </body>
</html>
