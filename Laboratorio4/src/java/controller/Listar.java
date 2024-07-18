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
@WebServlet(name = "Listar", urlPatterns = {"/listar.do"})
public class Listar extends HttpServlet {

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
            out.println("<title>Servlet Listar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Listar at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        /* a diferencia de todos los demas que andan por post (porque chequean
        y suben elementos a la pagina), este metodo listar sera por doGet()
        ya que tenemos que tomar todos los productos y mostrarlos, es decir, 
        mostrar el array list (la lista)*/
    
        /* agarramos el dao*/
        ProductoDAO pdao = new ProductoDAOimpl();
        /* recibimos la lista*/
        List<Producto> lista = pdao.listar(); 
        /* desarrollo de preguntas para la lista*/
        String mensaje;
        if(lista != null){
            mensaje = "Lista de productos";
            
        }else{
            mensaje = "No se encontro en la base de datos";
        }
        
        /* mando todo a la vista*/
        request.setAttribute("mensaje", mensaje);
        request.setAttribute("lista", lista);
        request.getRequestDispatcher("/listar.jsp").forward(request, response);
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
        processRequest(request, response);
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
