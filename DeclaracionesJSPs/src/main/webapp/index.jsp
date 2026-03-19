<!--Agregar declaración de un JSP-->

<%!
    // Declarar una variable y su metodo get asociado
    private String usuario = "Carlos";

    public String getUsuario () {
        return this.usuario;
    }
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
    </body>
</html>
