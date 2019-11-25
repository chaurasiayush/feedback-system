/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author ayush
 */
public class FillSub extends HttpServlet {

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
            out.println("<title>Servlet FillSub</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FillSub at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
            
            Enumeration<String> pn = request.getParameterNames();
            System.out.println(pn.toString());
            
            String subcode = "", depid="", subname="", fid="";
            int sem=0, cr = 0;
            
           
            while(pn.hasMoreElements()){
                
                for(int i=0;i<5;i++){
                
                        subcode = request.getParameter(pn.nextElement());
                        depid = request.getParameter(pn.nextElement());
                        sem = Integer.valueOf(request.getParameter(pn.nextElement()));
                        subname = request.getParameter(pn.nextElement());
                        cr = Integer.valueOf(request.getParameter(pn.nextElement()));
                        fid = request.getParameter(pn.nextElement());
                        System.out.println("subcode: "+subcode+" "+" subname: "+subname+" depid: "+depid+" "+" sem :"+sem+" credit: "+cr);
             
            
            try{Connection con = getConnection();
                     PreparedStatement ps = con.prepareStatement("insert into subjects(sub_code, dep_id, semester,sub_name, sub_credit, f_id) values(?,?,?,?,?,?);");
                     ps.setString(1, subcode);
                     ps.setString(2, depid);
                //     ps.setString(3, 1);
                     ps.setInt(3, sem);
                     ps.setString(4, subname);
                     ps.setInt(5, cr);
                     ps.setString(6, fid);
                          
               
                    // ps.setString(8, "F");
                     int n = ps.executeUpdate();
                     System.out.println("rows "+n);
                } catch (SQLException ex) {
                    System.err.println("sql error:"+ex.getMessage());
                }
        }}
            }
    }
            
            
        
    

        private Connection getConnection() {
        Connection con = null;
        Context ctx; 
      try {
            ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("mysqldb");
            con = ds.getConnection("root","123456");
        } catch (NamingException ex) {
            
        } catch (SQLException ex) {
            
        }
        return con;
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
