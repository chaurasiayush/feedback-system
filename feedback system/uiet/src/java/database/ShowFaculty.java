/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ShowFaculty extends HttpServlet {

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
            
            String d = (String)request.getParameter("dep");
            out.println("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<title>Show Faculty</title>\n" +
                    "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                    "<link rel=\"stylesheet\" href=\"css/w3.css\">\n"
                    + "<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Raleway\">" +
                    "<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css'>\n"
                    + "<link rel=\"shortcut icon\" href=\"favicon.ico\" type=\"image/x-icon\"/>"
                    + "<style>\n" +
                    "body,h1,h2,h3,h4,h5,h6 {font-family: \"Raleway\", Arial, Helvetica, sans-serif}\n" +
                    "</style> " +
                    "<body>\n" +
                    "\n" +
                    "<div class=\"w3-container w3-black\">\n" +
                    "	<br><br><br>\n" 
                    );

             try{
                Connection con = getConnection();
                Statement st = con.createStatement();
               
                
                
                ResultSet rs = st.executeQuery("select * from facdep where dep_id='"+d+"'");
                
                //Enumeration<String> pn = request.getParameterNames();
                
                rs.next();
                out.println("  <h1 style='text-align:center;'>Faculty Of "+rs.getString("dep_name")+" Department</th>\n" +
                    "  <br><br><br>\n" +
                    "\n" +
                    "</div>\n" +
                    "<br>\n" +
                    "\n" +
                    "<div class=\"w3-container\">\n" +
                    "\n" +
                    "<form method='POST' action='ShowFeedback' id='myform'>  "
                    + "<table class=\"w3-table-all w3-hoverable\">");
                out.println("<h1></h1>");
                out.println("<tr class='w3-white'>\n" +
                        "      <td class='w3-center'>\n" +
                        "				<div class=\"w3-bar\">\n" +
                        				  
                        "				  <div class=\"w3-bar-item\">\n" +
                        "					<span class=\"w3-large\"><h4>Select a Faculty To View Rating</h4></span>\n" +
                        					
                        "				  </div>\n" +
                        "				</div>\n" +
                 
                        "	  </td>\n" +
                        "    </tr>");
                
                
                do{
                    out.println("<tr>\n" +
                        "      <td>\n" +
                        "			<a onclick='mySubmit(this)' id="+rs.getString("f_id")+">\n" +
                        "				<div class=\"w3-bar\">\n" +
                        "				  <img src='"+getGen(rs.getString("gender"))+"' class=\"w3-bar-item w3-circle w3-hide-small\" style=\"width:85px\">\n" +
                        "				  <div class=\"w3-bar-item\">\n" +
                        "					<span class=\"w3-large\">"+rs.getString("f_name")+"</span><br>\n" +
                        "					<span>"+rs.getString("dep_id")+" department</span>\n" +
                        "				  </div>\n" +
                        "				</div>\n" +
                        "			</a>\n" +
                        "	  </td>\n" +
                        "    </tr>");
            }while(rs.next());
            out.println("  </table>\n"
                    + "</form>" +
                "</div>\n" +
                "	\n" +
                "\n" +
                "    \n" +
                "  </ul>\n" +
                "</div><br>");
            con.close();
            }catch(SQLException e){
                System.out.println("msg1: "+e.getMessage());
                out.println("<h1>Server Error...</h1>");
            }           
             out.println("<footer class=\"w3-center w3-black w3-padding-64\">\n" +
               
                "  <div class=\"w3-xlarge w3-section\">\n" +
                "    <i class=\"fa fa-facebook-official w3-hover-opacity\"></i>\n" +
                "    <i class=\"fa fa-instagram w3-hover-opacity\"></i>\n" +
                "    <i class=\"fa fa-snapchat w3-hover-opacity\"></i>\n" +
                "    <i class=\"fa fa-pinterest-p w3-hover-opacity\"></i>\n" +
                "    <i class=\"fa fa-twitter w3-hover-opacity\"></i>\n" +
                "    <i class=\"fa fa-linkedin w3-hover-opacity\"></i>\n" +
                "  </div>\n" +
                "  <p>Powered by <a href='aboutayush' title='Ayush Chaurasia' target='#' class=\"w3-hover-text-green\">ayush chaurasia</a></p>\n" +
                "</footer>");

                out.println("</body>");
            
                 out.println("<script>\n" +
                "    function mySubmit(tag) {\n" +
                "      // body...\n" +
                "      console.log(tag.id);\n" +
                "      var f=document.getElementById('myform');\n" +
                "      \n" +
                "      var my_tb=document.createElement('INPUT');\n" +
                "      my_tb.type='TEXT';\n" +
                "      my_tb.name='eid';\n" +
                "      my_tb.value=tag.id;\n" +
                "      my_tb.style.display='none';\n" +
                "      f.appendChild(my_tb);\n" +
                "      f.submit();\n" +
                "      \n" +
                "    }\n" +
                "</script>");
            
            out.println("</html>");
        }
    }

    String getGen(String g){
        if(g.equals("M")) return "images/avatar_mtchr.png";
        return "images/avatar_ftchr.png";
    
    }
    private Connection getConnection() {
        Connection con = null;
        Context ctx; 
      try {
            ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("mysqldb");
            con = ds.getConnection("root","123456");
        } catch (NamingException ex) {
            Logger.getLogger(ShowFaculty.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ShowFaculty.class.getName()).log(Level.SEVERE, null, ex);
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
