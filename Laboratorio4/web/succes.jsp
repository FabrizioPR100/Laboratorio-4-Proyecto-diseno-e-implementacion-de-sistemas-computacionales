<%-- 
    Document   : succes
    Created on : 26 jun 2024, 1:34:32?a. m.
    Author     : galla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color: red; color: white;     font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
     align-items: center;">
       
       
        
        <%
        String clave = request.getParameter("clave");
        String nombre = request.getParameter("nombre");
        String precio = request.getParameter("precio");
        String cantidad = request.getParameter("cantidad");
        
      
        %>
        
        <h1><b>Estos son los datos del producto ingresado:</b></h1> 
        
      Se guardaron los siguentes datos: 
      <%= request.getAttribute("producto") %>
      <br>  
      <br>
      <table border="1" cellspacing="3" cellpadding="3">
                <tbody>
                    <tr>
                        <td><label>Clave: </label></td>
                        <td><%= clave %></td>
                    </tr>
                    
                    <tr>
                        <td><label>Nombre: </label></td>
                        <td><%= nombre %></td>
                    </tr>
                    
                    <tr>
                        <td><label>Precio: </label></td>
                        <td><%= precio %></td>
                    </tr>
                        
                    <tr>
                        <td><label>Cantidad: </label></td>
                        <td><%= cantidad %></td>
                    </tr>
                </tbody>
            </table>
                  
            <br>        
            <button style="background-color: crimson; border-color: white; border-radius: 10%;"><a href="crear.jsp" style="text-decoration: none; color: white">Seguir creando productos</a></button>
            <br>
            <button style="background-color: crimson; border-color: white; border-radius: 10%;"><a href="index.html" style="text-decoration: none; color: white"> Volver al menu</a></button>
             
    </body>
</html>
