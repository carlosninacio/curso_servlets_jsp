<!DOCTYPE html>
<html data-bs-theme="dark">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Cliente</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
    </head>
    <body>
        <!--Cabecero-->
        <jsp:include page = "/WEB-INF/paginas/comunes/cabecero.jsp"/>
        
        <!--Formulario de edición de un cliente-->
        <form action='${pageContext.request.contextPath}/ServletControlador?accion=modificar&idCliente=${cliente.idCliente}'
              method='POST' class='was-validated'>
            
            <!--Botones de navegacion de edición-->
            <jsp:include page = "/WEB-INF/paginas/comunes/botonesNavegacionEdicion.jsp"/>
            
        </form>
        
        <!--Pie de Página-->
        <jsp:include page = "/WEB-INF/paginas/comunes/piePagina.jsp"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
    </body>
</html>
