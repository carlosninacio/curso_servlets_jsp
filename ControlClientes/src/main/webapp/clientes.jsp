<!DOCTYPE html>
<html data-bs-theme="dark">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de Clientes</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
    </head>
    <body>
        <!--Cabecero-->
        <jsp:include page = "/WEB-INF/paginas/comunes/cabecero.jsp"/>
        
        <!--Botones de Navegación-->
        <jsp:include page = "/WEB-INF/paginas/comunes/botonesNavegacion.jsp"/>
        
        <!--Listado de Clientes-->
        <jsp:include page = "/WEB-INF/paginas/cliente/listadoClientes.jsp"/>
        
        <!--Modal agregar un cliente-->
        
        
        <!--Pie de Página-->
        <jsp:include page = "/WEB-INF/paginas/comunes/piePagina.jsp"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
    </body>
</html>
