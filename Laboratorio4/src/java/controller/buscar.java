/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Producto;
import model.ProductoDAO;
import model.ProductoDAOimpl;

/**
 *
 * @author galla
 */
@WebServlet(name = "buscar", urlPatterns = {"/buscar.do"})
public class buscar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet buscar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet buscar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
       
        /*recibimos la variable clave */
       String sclave = request.getParameter("clave");
       /*necesitamos ver todos los productos que hay para encotnrar la clave */
       ProductoDAO pdao = new ProductoDAOimpl();
       /*accedemos a la lista (llamamos al metodo que devuelve la lista) */
       List<Producto> lista = pdao.listar();
       /*tengo que chequear que la lista no esté vacia*/
       String mensaje; /*creo mensaje para uisarlo en el if */
       int clave = 0; /* creo la clave para que exista con algo y sea operable */
       Producto producto = null; /*hacemos que exista el producto y lo 
       ponemos en null para evitar errores */
       
       if(lista != null){/* si la lista no está vacia*/    
       
           if(! sclave.equals("")){ /* si existe una clave*/
               clave = Integer.parseInt(sclave); /*paso el valor de la convergencia hecha antes (parseo el id) */
               /*el pdao recibe a través del metodo */
               producto = pdao.buscar(clave);
               
               if(producto != null){ /*el producto tiene algo? */
                   mensaje = "Producto encontrado";
                          
               }else{
                   mensaje = "Producto no encontrado";
               }
               
               
               
                   
           }else{
               mensaje = "La clave no existe o ha sido mal tipeada";
           }
           
       }else{
           mensaje = "No existe ningun producto en el almacen"; /* si la lista está vacia, devuelve esto*/
       }
       
       /* despues de todo, queda mandarlo a la vista*/
       
       request.setAttribute("producto", producto);
       request.setAttribute("mensaje", mensaje);
       request.getRequestDispatcher("/buscar.jsp").forward(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
