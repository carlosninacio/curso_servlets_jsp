<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Core</title>
    </head>
    <body>
        <h1>JSTL Core</h1>
        <!--Manipulación de Variables-->
        <c:set var="nombre" value="Ernesto"/>
        Variable nombre: <c:out value="${nombre}" />
        <br/>
        
        <!--Variable con código HTML-->
        <c:out value="<h4>Hola</h4>" escapeXml="false"/>
        
        <!--Código condicional con if-->
        <c:set var="bandera" value="true"/>
        <c:if test="${bandera}">
            La bandera es verdadera
        </c:if>
        <br/>
        
        <!--Estructura switch con c:choose -->
        <c:if test="${param.opcion != null}">
            <c:choose>
                <c:when test="${param.opcion == 1}">
                    Opción 1 Seleccionada
                </c:when>
                <c:when test="${param.opcion == 2}">
                    Opción 2 Seleccionada
                </c:when>
                <c:otherwise>
                    Opción desconocida
                </c:otherwise>
            </c:choose>
        </c:if>
                    
         <!--Iteración de un arreglo-->
         <%
           String[] nombres = {"Claudia", "Pedro", "Juan"};
           request.setAttribute("nombres", nombres);
         %>
         
         <br/>
         <ul>
             <c:forEach var="persona" items="${nombres}">
                 <li>${persona}</li>
             </c:forEach>
         </ul>
         
         <br/>
         <a href="index.jsp">Regresar al Inicio</a>
    </body>
</html>
