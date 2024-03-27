<%-- 
    Document   : index
    Created on : 26 mar 2024, 20:52:12
    Author     : Mi-Pc
--%>
<%@page import="java.util.ArrayList"%>
<%
    if (session.getAttribute("lista") == null) {
        ArrayList<String> lisAux = new ArrayList<String>();
        session.setAttribute("lista", lisAux);
    }
    ArrayList<String> lista = (ArrayList<String>) session.getAttribute("lista"); // recuperamos la lista
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Carrito de Compras</h1>
        <p>Inserte los productos que dessea</p>
        <form action="MainServlet" method ="post">
            Producto: <input type="text" name="producto">
            <input type="submit">
        </form>
        <a href="MainServlet">Vaciar carrito</a>
        <ul>
            <%
                //verificamos si lista esta vacia
                if (lista != null) {
                    for (String item : lista) {
            %>
            <li><%=item%></li>
                <%                    
                    }
                }
                %>

        </ul>

    </body>
</html>
