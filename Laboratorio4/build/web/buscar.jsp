<%-- 
    Document   : buscar
    Created on : 26 jun 2024, 3:23:03?p. m.
    Author     : galla

    este archivo tiene un formulario para buscar    
    el producto segun su "clave"
--%>

<%@page import="model.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar productos</title>
    </head>
    <body style="background-color: red; color: white;     font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
     align-items: center;">
        <h1>Buscar por clave</h1>
        
        <form action="buscar.do" method="post">
            <input type="number" name="clave">
            <button type="sumbit">Buscar</button>
        </form>
        
        <% 
           Producto productoEncontrado = (Producto) request.getAttribute("producto");  
           String msj = (String) request.getAttribute("mensaje");
           
           if(msj != null){
           /*muestro el mensaje, si el mensaje es distinto de null, lo muestro*/
                 out.println(msj);
            }

            if(productoEncontrado != null){
            /* lo mismo que el anterior pero con producto*/
                 out.println(productoEncontrado);
            }



        %>
        
        <br>
        <button style="background-color: crimson; border-color: white; border-radius: 10%;"><a href="index.html" style="text-decoration: none; color: white"> Volver al menu</a></button>
        
    </body>
</html>
