/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ayush
 */
public class SubSub extends HttpServlet {

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
            out.println("<h2>Enter subject details</h2>\n" +
                "\n" +
                "<form action='FillSub' AUTOCOMPLETE='OFF'>\n");
            for(int i=0;i<5;i++){
            
            out.println("  sub_code:<input type=\"text\" name='sub_code"+i+" autocomplete = 'off'>\n" +
                "  dep_id:<input type=\"text\" name='dep_id"+i+"' value=\"MEE\">\n" +
                "  semester:<input type=\"number\" name='semester"+i+"' value=\"7\">\n" +
                "  sub_name:<input type=\"text\" name='sub_name"+i+"' value=\"\">\n" +
                "  sub_credit:<input type=\"number\" name='sub_credit"+i+"' value='4'>\n" +
                "  f_id:<input type=\"text\" name='f_id"+i+"'  AUTOCOMPLETE='off' value='MEE-EID0' >\n" +
                "  <br><br>\n" 
                );
            }
            
            out.println("<input type='submit' value='Submit'>\n"
                    + "</form> ");
            out.println("</body>");
            out.println("<h1>Servlet SubSub at " + request.getContextPath() + "</h1>");
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
