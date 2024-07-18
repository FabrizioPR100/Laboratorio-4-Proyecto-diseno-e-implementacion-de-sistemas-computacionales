<%-- 
    Document   : listar
    Created on : 26 jun 2024, 9:33:12?p. m.
    Author     : galla
--%>

<%@page import="java.util.List"%>
<%@page import="model.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista</title>
    </head>
    <body style="background-color: red; color: white;     font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
     align-items: center;">
        <% 
            List<Producto> producto = (List<Producto>) request.getAttribute("lista");
            String msj = (String) request.getAttribute("mensaje");
        
            if(msj != null){
                out.println(msj);
            }

        %>
        
        
        <h1>Lista de los productos</h1>
        
        <table border="1" cellspacing="3" cellpadding="3">
            <thead>
                <tr>
                    <th>Clave</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                </tr>
            </thead>
            <tbody>
                <% for (Producto p : producto){%>
                <tr>
                    <td> <%= p.getClave()%> </td>
                    <td><%= p.getNombre()%> </td>
                    <td><%= p.getPrecio()%> </td>
                    <td><%= p.getCantidad()%> </td>
                </tr>  
                <%}%>                  
            </tbody>
        </table>
            <br>
        <button style="background-color: crimson; border-color: white; border-radius: 10%;"><a href="index.html" style="text-decoration: none; color: white"> Volver al menu</a></button>
    </body>
</html>
