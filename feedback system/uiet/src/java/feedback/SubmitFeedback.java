/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedback;

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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author ayush
 */
public class SubmitFeedback extends HttpServlet {

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
            out.println("<title>Thank You!!</title>"
                    + "<meta charset=\"UTF-8\">\n" +
                    "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                    "<link rel=\"stylesheet\" href=\"css/w3.css\">\n" +
                    "<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Raleway\">\n"
                    + "<link rel=\"shortcut icon\" href=\"favicon.ico\" type=\"image/x-icon\"/></head>" +
                    "<style>\n" +
                    "body,h1 {font-family: \"Raleway\", sans-serif}\n" +
                    "body, html {height: 100%}\n" +
                    ".bgimg {\n" +
                    "    background-image: url('images/bkg2.png');\n" +
                    "    min-height: 100%;\n" +
                    "    background-position: center;\n" +
                    "    background-size: cover;\n" +
                    "}\n" +
                    "</style>");            
        out.println("<div class=\"bgimg w3-display-container w3-animate-opacity w3-text-white\">\n" +
                   
                    "  <div class=\"w3-display-middle\">\n" +
                    "    <h1 class=\"w3-jumbo w3-animate-top\" style='animation: animatetop .8s'>Thank You!!</h1>\n" +
                    "    <hr class=\"w3-border-grey\" style=\"margin:auto;width:40%\">\n" +
                    "    <p class=\"w3-large w3-center\">Your Feedback Has Been Submitted Successfully</p>\n" +
                    "    <a class=\"w3-button w3-white w3-ripple w3-round\" href='Home'>Go Back To Home</a>\n" +
                    "  \n" +
                    "</div>"+
                     "</body>");
            out.println("</html>");  
            
            
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            Enumeration<String> pn = request.getParameterNames();
            System.out.println(pn.toString());
            while(pn.hasMoreElements()){
                
                int i=0,r1=0,r2=0,r3=0,r4=0;
                String sugg="",sub_code="",fid="",dep="",s="";
                HttpSession sen = request.getSession();
                dep = (String)sen.getAttribute("dep_id");
                while(i<6){
                    s = pn.nextElement();
                    System.out.println(s);
                    String val[] = s.split(":");
                    fid=val[0];
                    switch(val[1]){
                        case "sub":
                            sub_code=request.getParameter(s);
                            break;
                        case "1":
                            r1=Integer.parseInt(request.getParameter(s));
                            break;
                        case "2":
                            r2=Integer.parseInt(request.getParameter(s));
                            break;
                        case "3":
                            r3=Integer.parseInt(request.getParameter(s));
                            break;
                        case "4":
                            r4=Integer.parseInt(request.getParameter(s));
                            break;
                        case "s":
                            sugg=request.getParameter(s);
                            break;
                            
                    }
                    i++;
                }
                System.out.println(""+fid+" "+sub_code+" "+dep+" "+r1+" "+r2+" "+r3+" "+r4+" "+sugg);
                try{
                     Connection con = getConnection();
                     PreparedStatement ps = con.prepareStatement("insert into feedbacks(f_id, sub_code, dep_id, r_asgn, r_marking, r_teaching, r_punctual, remarks) values(?,?,?,?,?,?,?,?);");
                     ps.setString(1, fid);
                     ps.setString(2, sub_code);
                     ps.setString(3, dep);
                     ps.setInt(4, r1);
                     ps.setInt(5, r2);
                     ps.setInt(6, r3);
                     ps.setInt(7, r4);
                     ps.setString(8, sugg);
                     int n = ps.executeUpdate();
                     System.out.println("rows "+n);
                } catch (SQLException ex) {
                    System.err.println("sql error:"+ex.getMessage());
                }
            }
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
     

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
