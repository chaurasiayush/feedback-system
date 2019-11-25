/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feedback;

import database.ShowFaculty;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class GiveFeedback extends HttpServlet {

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
            out.println("<title>GiveFeedback</title>");  
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
                "\n" +
                "<link rel=\"stylesheet\" href=\"css/w3.css\">\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"starability/starability-minified/starability-all.min.css\"/>"+
                    "   <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css'>\n"
                    + "<link rel=\"shortcut icon\" href=\"favicon.ico\" type=\"image/x-icon\"/>" );
            out.println("</head>");
            out.println("<body>");
            
            String department = request.getParameter("department");
            String semester = request.getParameter("semester");
            HttpSession s = request.getSession();
            s.setAttribute("dep_id", department);
            
             try{
                Connection con = getConnection();
                Statement st = con.createStatement();
                Statement st2 = con.createStatement();
                ResultSet rs = st.executeQuery("select * from fb_view where branch='"+department+"' and semester='"+semester+"';");
                
  /*ch*/       ResultSet rs2 = st2.executeQuery("select dep_name from department where dep_id='"+department+"';");
                rs2.next();
                out.println("<div class=\"w3-container w3-black\" style= 'margin-bottom: 30px;padding: 50px 25px'>\n" +
                "  <h1 style='text-align: center; font-size:50px'>"+rs2.getString("dep_name")+"</h1>\n" +
                "  <h1 style='text-align: center;'>Semester:- "+semester+"</h1>\n" +
                "</div>");
               //         "<div><br><h1 style='text-align:center;'>Share Your Experiences With Us</h1><br>");
  
                out.println("<form method='POST' action='SubmitFeedback'>\n"+
                    "   <div class=\"w3-container\">\n" +
                    "    <ul class=\"w3-ul w3-card-4\">\n" +
                    "	\n" +
                    "	\n" +
                    "		<div class=\"w3-row-padding\">\n");
               int i=0;
                while(rs.next()){
                    
                    String name = rs.getString("f_name");
                    String gen = rs.getString("gender");
               //     out.println("<tr><td>"+rs.getString("F_id")+"</td><td>"+rs.getString("Dep_id")+"</td><td>"+rs.getString("F_name")+"</td></tr>");
               out.println("<table style='width:99%;  margin-top:10px; margin-left: 20px'>\n" +
                    "				\n" +
                    "				<tr> \n" +
                    "					 <TD rowspan=\"2\" style='width:19%'><img src='"+getavtar(gen)+"' class=\"w3-bar-item w3-circle w3-hide-small\" style=\"width:85px; \"></TD>\n" +
                    "					<th  style='text-align:left; width:25%;'><h3>Name:</h3></th>\n" +
                    "					<th  colspan='2' style='text-align:left;'><h3>"+name+"</h3></th>\n" +
                    "				</tr>\n" +
                    "				\n" +
                    "				<tr> \n" +
                    "					<th style='text-align:left; width:8%;'><h3>Subject:</h3></th>\n" +
                    "					<th  colspan='2' style='text-align:left;'><h3>"+rs.getString("sub_name")+" ("+rs.getString("sub_code")+")</h3></th>\n" +
                    "				</tr>\n" +
                    "				\n" +
                    "				<tr> \n" +
                    "					<td style='width:19%'><h3>Teaching</h3></td>\n" +
                    "					\n" +
                    "						\n" +
                    "					<td >\n" +
                    "				\n" +
                            "                                   <input type='text' name='"+rs.getString("f_id")+":sub' value='"+rs.getString("sub_code")+"' style='display:none;'>"+
                    "						<fieldset class=\"starability-growRotate\">\n" +
                    "						  \n" +
                    "						  <input type=\"radio\" id='no-rate"+i+++"' class=\"input-no-rate\" name="+rs.getString("f_id")+":1"+ " value=\"0\" checked aria-label=\"No rating.\" />\n" +
                    "\n" +
                    "						  <input type=\"radio\" id='rate1"+i+"' name="+rs.getString("f_id")+":1"+" value=\"1\" />\n" +
                    "						  <label for='rate1"+(i++)+"'>1 star.</label>\n" +
                    "\n" +
                    "						  <input type=\"radio\" id='rate2"+i+"' name="+rs.getString("f_id")+":1"+" value=\"2\" />\n" +
                    "						  <label for='rate2"+(i++)+"'>2 stars.</label>\n" +
                    "\n" +
                    "						  <input type=\"radio\" id='rate3"+i+"' name="+rs.getString("f_id")+":1"+" value=\"3\" />\n" +
                    "						  <label for='rate3"+(i++)+"'>3 stars.</label>\n" +
                    "\n" +
                    "						  <input type=\"radio\" id='rate4"+i+"' name="+rs.getString("f_id")+":1"+" value=\"4\" />\n" +
                    "						  <label for='rate4"+(i++)+"'>4 stars.</label>\n" +
                    "\n" +
                    "						  <input type=\"radio\" id='rate5"+i+"' name="+rs.getString("f_id")+":1"+" value=\"5\" />\n" +
                    "						  <label for='rate5"+(i++)+"'>5 stars.</label>\n" +
                    "\n" +
                    "						  <span class=\"starability-focus-ring\"></span>\n" +
                    "						</fieldset>\n" +
                    "						\n" +
                    "					</td>\n" +
                    "						\n" +
                    "				\n" +
                    "				\n" +
                    "				\n" +
                    "					<td style='width:19%'><h3>Marking</h3>\n" +
                    "					\n" +
                    "					<td>\n" +
                    "						\n" +
                    "					<fieldset class=\"starability-growRotate\">\n" +
                    "						  \n" +
                    "						  <input type=\"radio\" id='no-rate1"+i+++"' class=\"input-no-rate\" name="+rs.getString("f_id")+":2"+ " value=\"0\" checked aria-label=\"No rating.\" />\n" +
                    "\n" +
                    "						  <input type=\"radio\" id='rate11"+i+"' name="+rs.getString("f_id")+":2"+" value=\"1\" />\n" +
                    "						  <label for='rate11"+(i++)+"'>1 star.</label>\n" +
                    "\n" +
                    "						  <input type=\"radio\" id='rate21"+i+"' name="+rs.getString("f_id")+":2"+" value=\"2\" />\n" +
                    "						  <label for='rate21"+(i++)+"'>2 stars.</label>\n" +
                    "\n" +
                    "						  <input type=\"radio\" id='rate31"+i+"' name="+rs.getString("f_id")+":2"+" value=\"3\" />\n" +
                    "						  <label for='rate31"+(i++)+"'>3 stars.</label>\n" +
                    "\n" +
                    "						  <input type=\"radio\" id='rate41"+i+"' name="+rs.getString("f_id")+":2"+" value=\"4\" />\n" +
                    "						  <label for='rate41"+(i++)+"'>4 stars.</label>\n" +
                    "\n" +
                    "						  <input type=\"radio\" id='rate51"+i+"' name="+rs.getString("f_id")+":2"+" value=\"5\" />\n" +
                    "						  <label for='rate51"+(i++)+"'>5 stars.</label>\n" +
                    "\n" +
                    "						  <span class=\"starability-focus-ring\"></span>\n" +
                    "						</fieldset>\n" +
                    "						\n" +
                    "					</td>	\n" +
                    "					\n" +
                    "						\n" +
                    "				</tr>\n" +
                    "				\n" +
                    "				\n" +
                    "				\n" +
                    "				\n" +
                    "				<tr> \n" +
                    "					<td style='width:19%'><h3>Assignment</h3>\n" +
                    "					\n" +
                    "						\n" +
                    "					<td >\n" +
                    "				\n" +
                    "					<fieldset class=\"starability-growRotate\">\n" +
                    "						  \n" +
                    "						  <input type=\"radio\" id='no-rate3"+i+++"' class=\"input-no-rate\" name="+rs.getString("f_id")+":3"+ " value=\"0\" checked aria-label=\"No rating.\" />\n" +
                    "\n" +
                    "						  <input type=\"radio\" id='rate13"+i+"' name="+rs.getString("f_id")+":3"+" value=\"1\" />\n" +
                    "						  <label for='rate13"+(i++)+"'>1 star.</label>\n" +
                    "\n" +
                    "						  <input type=\"radio\" id='rate23"+i+"' name="+rs.getString("f_id")+":3"+" value=\"2\" />\n" +
                    "						  <label for='rate23"+(i++)+"'>2 stars.</label>\n" +
                    "\n" +
                    "						  <input type=\"radio\" id='rate33"+i+"' name="+rs.getString("f_id")+":3"+" value=\"3\" />\n" +
                    "						  <label for='rate33"+(i++)+"'>3 stars.</label>\n" +
                    "\n" +
                    "						  <input type=\"radio\" id='rate43"+i+"' name="+rs.getString("f_id")+":3"+" value=\"4\" />\n" +
                    "						  <label for='rate43"+(i++)+"'>4 stars.</label>\n" +
                    "\n" +
                    "						  <input type=\"radio\" id='rate53"+i+"' name="+rs.getString("f_id")+":3"+" value=\"5\" />\n" +
                    "						  <label for='rate53"+(i++)+"'>5 stars.</label>\n" +
                    "\n" +
                    "						  <span class=\"starability-focus-ring\"></span>\n" +
                    "						</fieldset>\n" +
                    "						\n" +
                    "					</td>\n" +
                    "						\n" +
                    "				\n" +
                    "				\n" +
                    "				\n" +
                    "					<td style='width:19%'><h3>Punctuality</h3>\n" +
                    "					\n" +
                    "						\n" +
                    "					<td >\n" +
                    "				\n" +
                    "					<fieldset class=\"starability-growRotate\">\n" +
                    "						  \n" +
                    "						  <input type=\"radio\" id='no-rate4"+i+++"' class=\"input-no-rate\" name="+rs.getString("f_id")+":4"+ " value=\"0\" checked aria-label=\"No rating.\" />\n" +
                    "\n" +
                    "						  <input type=\"radio\" id='rate14"+i+"' name="+rs.getString("f_id")+":4"+" value=\"1\" />\n" +
                    "						  <label for='rate14"+(i++)+"'>1 star.</label>\n" +
                    "\n" +
                    "						  <input type=\"radio\" id='rate24"+i+"' name="+rs.getString("f_id")+":4"+" value=\"2\" />\n" +
                    "						  <label for='rate24"+(i++)+"'>2 stars.</label>\n" +
                    "\n" +
                    "						  <input type=\"radio\" id='rate34"+i+"' name="+rs.getString("f_id")+":4"+" value=\"3\" />\n" +
                    "						  <label for='rate34"+(i++)+"'>3 stars.</label>\n" +
                    "\n" +
                    "						  <input type=\"radio\" id='rate44"+i+"' name="+rs.getString("f_id")+":4"+" value=\"4\" />\n" +
                    "						  <label for='rate44"+(i++)+"'>4 stars.</label>\n" +
                    "\n" +
                    "						  <input type=\"radio\" id='rate54"+i+"' name="+rs.getString("f_id")+":4"+" value=\"5\" />\n" +
                    "						  <label for='rate54"+(i++)+"'>5 stars.</label>\n" +
                    "\n" +
                    "						  <span class=\"starability-focus-ring\"></span>\n" +
                    "						</fieldset>\n" +
                    "						\n" +
                    "					</td>\n" +
                    "						\n" +
                    "				</tr>\n" +
                    "				\n" +
                    "			</table>\n" +
                    "				\n" +
                    "			<table style='margin-top:10px; margin-left: 20px'>\n" +
                    "				<tr>\n" +
                    "				<br>\n" +
                    "				<input class=\"w3-input w3-border w3-animate-input\" placeholder='Give Your Remarks Here!' name="+rs.getString("f_id")+":s"+" type='text' autocomplete=\"off\" style=\"width:40%\">\n" +
                    "				<hr>\n" +
                    "				</tr>\n" +
                    "			</table>\n");
                }
               
            out.println( "			<table style='margin-top:10px; margin-left: 20px'>\n" +
                    "				<tr>\n" +
                    "				<center><input style='width:300px; height:50px ' class=\"w3-btn w3-black w3-round-large\" type='submit' value='Submit' ></center></form>" +
                    "				<br>\n" +
                    "				</tr>\n" +
                    "			</table>\n");
               
               
               
               
            
            out.println("</div>\n" +
                    "	</ul> \n" +
                    "</div><br><br></table>");
            con.close();
            }catch(SQLException e){
                System.out.println("msg1: "+e.getMessage());
                out.println("<h1>Server Error...</h1>");
            }catch(Exception e){System.err.println(e.getMessage());}
             
           //out.println("<center><input style='width:300px; height:50px ' class=\"w3-btn w3-black w3-round-large\" type='submit' value='Submit' ></center></form>");
            out.println("<footer class=\"w3-center w3-black w3-padding-64\">\n" +
               
                "  <div class=\"w3-xlarge w3-section\">\n" +
                "    <i class=\"fa fa-facebook-official w3-hover-opacity\"></i>\n" +
                "    <i class=\"fa fa-instagram w3-hover-opacity\"></i>\n" +
                "    <i class=\"fa fa-snapchat w3-hover-opacity\"></i>\n" +
                "    <i class=\"fa fa-pinterest-p w3-hover-opacity\"></i>\n" +
                "    <i class=\"fa fa-twitter w3-hover-opacity\"></i>\n" +
                "    <i class=\"fa fa-linkedin w3-hover-opacity\"></i>\n" +
                "  </div>\n" +
                "  <p>Powered by <a href='aboutayush' title='Ayush Chaurasia' target='#' class=\"w3-hover-text-green\">ayush chaurasia</a> </p>\n" +
                "</footer>"+
                "</body>\n" +
                "</html>");
     
            
            
        }
    }

    String getavtar(String g){
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
