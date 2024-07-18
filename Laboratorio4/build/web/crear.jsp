<%-- 
    Document   : crear
    Created on : 26 jun 2024, 1:04:41?a. m.
    Author     : galla

    este archivo es el que implementa el metodo save del 
    request !!!
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear productos</title>
    </head>
    <body style="background-color: red; color: white;     font-family: system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
     align-items: center;">
       
       <h1><b>ingrese los datos del producto</b></h1>
        <form action="crear.do" method="post">
            
            <table border="1" cellspacing="3" cellpadding="3">
                <tbody>
                    <tr>
                        <td><label>Clave: </label></td>
                        <td><input type="number" name="clave"></td>
                    </tr>
                    
                    <tr>
                        <td><label>Nombre: </label></td>
                        <td><input type="text" name="nombre"></td>
                    </tr>
                    
                    <tr>
                        <td><label>Precio: </label></td>
                        <td><input type="number" name="precio"></td>
                    </tr>
                        
                    <tr>
                        <td><label>Cantidad: </label></td>
                        <td><input type="number" name="cantidad"></td>
                    </tr>
                </tbody>
            </table>
            
             <br>
             <button type="reset" style="background-color: crimson; border-color: white; border-radius: 10%; color: white;">Borrar</button>
             <button type="sumbit" style="background-color: crimson; border-color: white; border-radius: 10%; color: white;">Crear</button>
             <br>
            
             <button style="background-color: crimson; border-color: white; border-radius: 10%;"><a href="listar.do" style="text-decoration: none; color: white">Listar Productos</a></button>
             <br>
             <button style="background-color: crimson; border-color: white; border-radius: 10%;"><a href="index.html" style="text-decoration: none; color: white"> <- Volver</a></button> 
        </form>
         
        
    </body>
</html>
