/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Crear", urlPatterns = {"/crear.do"})
public class Crear extends HttpServlet {

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
            out.println("<title>Servlet Crear</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Crear at " + request.getContextPath() + "</h1>");
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
        
        int clave = 0;
        int precio = 0;
        int cantidad = 0;
        /* y como lo guardo en la db???:*/
        Producto producto;
        ProductoDAO pdao = new ProductoDAOimpl();
       
        
        String sclave = request.getParameter("clave");
        String nombre = request.getParameter("nombre");
        String sprecio = request.getParameter("precio");
        String scantidad = request.getParameter("cantidad");
        
        if(sclave.equals("")){
            response.sendRedirect("error.jsp");
        }else{ /*para chequear que no este vacio */
            /*paso todas las variables a su respectivo valor para que:
            este chequeado que pasen de string a su valor normal y para
            que no puedan ser null o esten vacios            */
            clave = Integer.parseInt(sclave);
            precio = Integer.parseInt(sprecio);
            cantidad = Integer.parseInt(scantidad);
            /* creo directamente el objeto*/
            producto = new Producto(clave, nombre, precio, cantidad);
            /* uso el metodo save para meterlo en la DB*/
            pdao.save(producto);
            /*ahora tengo que guardarlo en el request */
            request.setAttribute("producto",producto);
            /*hago el reenvio a la pagina de succes luego de ingresar */
            request.getRequestDispatcher("/succes.jsp").forward(request, response);
        }
        
        
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
