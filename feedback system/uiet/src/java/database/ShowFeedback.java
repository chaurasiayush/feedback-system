/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.Collections.enumeration;
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
import javax.sql.DataSource;

/**
 *
 * @author ayush
 */
public class ShowFeedback extends HttpServlet {

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
            out.println("<html id='d' >");
            //out.println("<head>");
            out.println("<title>ShowFeedback</title>"); 
            out.println("<meta charset=\"UTF-8\">\n" +
                        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" +
                        "<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Raleway\">\n" +
                        "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
                        "<!-- Font Awesome Icon Library -->\n" +
                        "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
                        "<link rel=\"stylesheet\" href=\"css/scorecard.css\">\n"
                      + "<link rel=\"shortcut icon\" href=\"favicon.ico\" type=\"image/x-icon\"/>" +
                        "<link rel=\"stylesheet\" href=\"css/w3.css\">");
            out.println("<style>\n" +
                        "body,h1,h2,h3,h4,h5,h6 {font-family: \"Raleway\", Arial, Helvetica, sans-serif}\n" +
                        ".mySlides {display:none}\n" +
                        "</style>");
            out.println("<body class=\"w3-auto\" style='padding-left: 0px; max-width: 100%; border-right: none !important; padding-right:0px; padding-bottom:0px; padding-top:0px'>");
        
    
    
     try{
                Connection con = getConnection();
                Statement st = con.createStatement();
                //Enumeration<String> pn = request.getParameterNames();
                String fid = (String)request.getParameter("eid");
                
                //------------------------------------------------------------------Teacher Details-------------------------------------------------------------------------------------------------------
                ResultSet fdtl = st.executeQuery("select f_name,dep_name,gender from facdep where f_id = '"+fid+"'"); 
                fdtl.next();
                String TeacherName = fdtl.getString(1),
                        Department = fdtl.getString(2),
                        gender = fdtl.getString(3);
                out.println("<!-- Sidebar/menu -->\n" +
                            "<nav class=\"w3-sidebar w3-light-grey w3-collapse w3-top\" style=\"z-index:3;width:39% ;border-right:1px dotted;\" id=\"mySidebar\">\n" +
                            "  <br>\n" +
                            "  <div class=\"w3-border w3-round w3-white \" style='margin-top: -8px; margin-left: 15px; margin-right: 15px;'>\n" +
                            "        <div class=\"w3-container\">\n" +
                            "         <h4 class=\"w3-center\"><strong>Teacher Profile</strong></h4>\n" +
                            "         <p class=\"w3-center\"><img src='"+getGen(gender)+"' class=\"w3-circle\" style=\"height:250px;width:250px\" alt=\"Avatar\"></p>\n" +
                            "         <hr>\n" +
                            "         <p><i class=\"fa fa-user-circle-o fa-fw w3-margin-right w3-text-theme\" aria-hidden=\"true\"></i>"+TeacherName+"</p>\n" +
                            "         <p><i class=\"fa fa-book fa-fw w3-margin-right w3-text-theme\"></i> Teacher, "+Department+" Department</p>\n" +
                            "         <p><i class=\"fa fa-home fa-fw w3-margin-right w3-text-theme\"></i> Kanpur, UP</p>\n" +
                            "         <p><i class=\"fa fa-mobile fa-fw w3-margin-right w3-text-theme\"></i> 987654321</p>\n" +
                            "        </div>\n" +
                            "      </div>\n" +
                            "  <div class=\"w3-container w3-display-container w3-padding-16\">\n" +
                            "    <h4><strong>Remarks</strong></h4>\n" +
                            "    <p>Click to view Remarks given to you by students.</p>\n" +
                            "    <p><button class=\"w3-button w3-black w3-third\" onclick=\"document.getElementById('d').style.overflow = 'hidden';document.getElementById('subscribe').style.display='block'\">Show</button></p>\n" +
                            "  \n" +
                            "  </div>\n" +
                            "</nav>\n" +
                            "\n" +
                            "<!-- Top menu on small screens -->\n" +
                            "<header class=\"w3-bar w3-top w3-hide-large w3-black w3-xlarge\">\n" +
                            "  <span class=\"w3-bar-item\">Teacher Rating</span>\n" +
                            "  <a href=\"javascript:void(0)\" class=\"w3-right w3-bar-item w3-button\" onclick=\"w3_open()\"><i class=\"fa fa-bars\"></i></a>\n" +
                            "</header>\n" +
                            "\n" +
                            "<!-- Overlay effect when opening sidebar on small screens -->\n" +
                            "<div class=\"w3-overlay w3-hide-large\" onclick=\"w3_close()\" style=\"cursor:pointer\" title=\"close side menu\" id=\"myOverlay\"></div>");
               //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
               
               //---------------------------------------------------------------------------------------scrolling page start-------------------------------------------------------------------------------------------------------
               
                out.println("<!-- !PAGE CONTENT! -->\n" +
                            "  <div class=\"w3-container w3-black w3-main\" style='margin-left: 39%;' >\n" +
                            "    <br><br>\n" +
                            "    <h1 style='text-align:center;'>View Ratings</h1>\n" +
                            "    <br><br>\n" +
                            "  </div>\n" +
                            "<br>\n" +
                            "<div class=\"w3-main\" style=\"margin-left:40%; padding-left:15px; padding-right:18px\">");
               
                out.println(" <!-- Push down content on small screens -->\n" +
                            "  <div class=\"w3-hide-large\"></div>");
                
                
                //---------------------------------------------------------score card starts------------------------------------------------------------------------------------------------------------
                
                ResultSet rs = st.executeQuery("select * from view_feedback2 where fid='"+fid+"' order by teaching_dep_id asc,semester asc");
         
                
                while(rs.next()){
                   // System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(5)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(9)+" "+rs.getString(10));
                    String eid = rs.getString("fid");
                    String subcode = rs.getString("sub_code");
                    String subname = rs.getString("sub_name");
                    int semester = Integer.parseInt(rs.getString("semester"));
                    String teachingDep = rs.getString("teaching_dep_id");
                    float teaching = 0,marking =0,assignment =0,punctuality =0;
                    if(rs.getFloat("teaching") != 0) teaching = Float.parseFloat(String.format("%1.1f",(rs.getFloat("teaching"))));
                    if(rs.getFloat("marking") != 0) marking = Float.parseFloat(String.format("%1.1f",(rs.getFloat("marking"))));
                    if(rs.getFloat("assignment") != 0) assignment = Float.parseFloat(String.format("%1.1f",(rs.getFloat("assignment"))));
                    if(rs.getFloat("punctuality") != 0) punctuality = Float.parseFloat(String.format("%1.1f",(rs.getFloat("punctuality"))));
                    int NoOfRating = Integer.parseInt(rs.getString("NoOfRating"));
                    float pteaching = teaching*100/5,pmarking = marking*100/5,passignment = assignment*100/5,ppunctuality = punctuality*100/5;
                    float avgRating = Float.parseFloat(String.format("%1.1f",(teaching+marking+ assignment+ punctuality)/4));
                    int wstar = (int)avgRating;
                    out.println("<div class='w3-container w3-padding w3-padding-16 w3-card'>\n" +
                                "      <table class='w3-table'>\n" +
                                "        <tr><td style='width:23%;'><h6><strong>Subject:</strong></h6></td>\n" +
                                "          <td><h6>"+subname+" ("+subcode+")</h6></td>\n" +
                                "        </tr>\n" +
                                "        <tr><td><h6><strong>Teaching in:</strong></h6></td>\n" +
                                "          <td><h6>"+teachingDep+" Department</h6></td>\n" +
                                "        </tr>\n" +
                                "        <tr><td><h6><strong>Semester:</strong></h6></td>\n" +
                                "          <td><h6>"+semester+"</h6></td>\n" +
                                "        </tr>\n" +
                                "        <tr>\n" +
                                "          <td colspan = '2' style='padding-left:8px'>\n" +
                                "            <div class='w3-panel w3-border' style='margin-bottom: 0px !important'><br>\n" +
                                "                  <span class=\"heading\">Student Rating</span>\n");
                    int starcount =5;
                    //------------------------------------------------------------------------------------------star---------------------------------------------------------------------------------------------------------
                    for(int i=0;i<wstar;i++){
                         out.println("             <span class=\"fa fa-star checked\"></span>\n");
                         starcount--;
                    }   System.out.println("Value aai:"+(avgRating-(float)wstar));   
                    if(1.0>(avgRating-(float)wstar) && (avgRating-(float)wstar)>=0.5 && (starcount>0)){  
                              out.println("        <span class=\"fa fa-star-half-o checked\"></span>");
                              starcount--;
                    }
                     for(int i=0;i<starcount;i++){
                    out.println("                  <span class=\"fa fa-star-o checked\"></span>\n" );
                     }
                    //------------------------------------------------------------------------------------------rating------------------------------------------------------------------------------------------------------            
                    if(NoOfRating>0)
                        out.println("              <p>"+avgRating+" average based on "+NoOfRating+" reviews.</p>\n");
                    else
                        out.println("              <p>No ratings yet.</p>\n");
                    out.println("                  <hr style=\"border:3px solid #f1f1f1\">\n" +
                                "\n" +
                                "                  <div class=\"row\">\n" +
                                "                    <div class=\"side\">\n" +
                                "                      <div>Teaching:</div>\n" +
                                "                    </div>\n" +
                                "                    <div class=\"middle\">\n" +
                                "                      <div class=\"bar-container\">\n" +
                                "                        <div class=\"w3-light-gray\">\n" +
                                "                          <div class='"+GetColor(pteaching)+"' style=\"height:18px;width:"+pteaching+"%\"></div>\n" +
                                "                        </div>\n" +
                                "                      </div>\n" +
                                "                    </div>\n" +
                                "                    <div class=\"side right\">\n" +
                                "                      <div>"+teaching+"/5</div>\n" +
                                "                    </div>\n" +
                                "\n" +
                                "                    <div class=\"side\">\n" +
                                "                      <div>Marking:</div>\n" +
                                "                    </div>\n" +
                                "                    <div class=\"middle\">\n" +
                                "                      <div class=\"bar-container\">\n" +
                                "                        <div class=\"w3-light-gray\">\n" +
                                "                          <div class='"+GetColor(pmarking)+"' style=\"height:18px;width:"+pmarking+"%\"></div>\n" +
                                "                        </div>\n" +
                                "                      </div>\n" +
                                "                    </div>\n" +
                                "                    <div class=\"side right\">\n" +
                                "                      <div>"+marking+"/5</div>\n" +
                                "                    </div>\n" +
                                "\n" +
                                "                    <div class=\"side\">\n" +
                                "                      <div>Assignment</div>\n" +
                                "                    </div>\n" +
                                "                    <div class=\"middle\">\n" +
                                "                      <div class=\"bar-container\">\n" +
                                "                        <div class=\"w3-light-gray\">\n" +
                                "                          <div class='"+GetColor(passignment)+"' style=\"height:18px;width:"+passignment+"%\"></div>\n" +
                                "                        </div>\n" +
                                "                      </div>\n" +
                                "                    </div>\n" +
                                "                    <div class=\"side right\">\n" +
                                "                      <div>"+assignment+"/5</div>\n" +
                                "                    </div>\n" +
                                "\n" +
                                "                    <div class=\"side\">\n" +
                                "                      <div>Punctuality</div>\n" +
                                "                    </div>\n" +
                                "                    <div class=\"middle\">\n" +
                                "                      <div class=\"bar-container\">\n" +
                                "                        <div class=\"w3-light-gray\">\n" +
                                "                          <div class='"+GetColor(ppunctuality)+"' style=\"height:18px;width:"+ppunctuality+"%\"></div>\n" +
                                "                        </div>\n" +
                                "                      </div>\n" +
                                "                    </div>\n" +
                                "                    <div class=\"side right\">\n" +
                                "                      <div>"+punctuality+"/5</div>\n" +
                                "                    </div>\n" +
                                "                  \n" +
                                "                    <div class=\"side\">\n" +
                                "                    \n" +
                                "                    </div><br>\n" +
                                "                  </div>\n" +
                                "            </div>\n" +
                                "          </td>\n" +
                                "        </tr>\n" +
                                "\n" +
                                "      </table>\n" +
                                "    </div><hr>");
                        
                }
                //-------------------------------------------------------------End page content/footer start-------------------------------------------------------------------------------------------------------------------------
                out.println("<!-- End page content -->\n" +
                            "</div>\n" +
                            "\n" +
                            "    <footer class=\"w3-centre w3-black w3-padding-64 w3-main\" style='margin-left: 39%; text-align: center;'>\n" +
                            "      <div class=\"w3-xlarge w3-section \">\n" +
                            "        <i class=\"fa fa-facebook-official w3-hover-opacity\"></i>\n" +
                            "        <i class=\"fa fa-instagram w3-hover-opacity\"></i>\n" +
                            "        <i class=\"fa fa-snapchat w3-hover-opacity\"></i>\n" +
                            "        <i class=\"fa fa-pinterest-p w3-hover-opacity\"></i>\n" +
                            "        <i class=\"fa fa-twitter w3-hover-opacity\"></i>\n" +
                            "        <i class=\"fa fa-linkedin w3-hover-opacity\"></i>\n" +
                            "      </div>\n" +
                            "      <p>Powered by <a href='aboutayush' title='Ayush Chaurasia' target='#' class=\"w3-hover-text-green\">ayush chaurasia</a></p>\n" +
                            "    </footer>");
                
                //-----------------------------------------------------------------------------------Remarks modle start-----------------------------------------------------------------------------------------------------------------------------------------
                
                out.println("<!-- Remarks Modal -->\n" +
                            "<div id=\"subscribe\" class=\"w3-modal w3-padding-48\" >\n" +
                            "  <div class=\"w3-modal-content w3-animate-zoom w3-padding-large\">\n" +
                            "    <div class=\"w3-container w3-white w3-center\">\n" +
                            "      <i onclick=\"document.getElementById('subscribe').style.display='none';document.getElementById('d').style.overflow = 'auto'\" class=\"fa fa-remove w3-button w3-xlarge w3-right w3-transparent\"></i>\n" +
                            "      <h2 class=\"w3-wide\">REMARKS</h2>\n" +
                            "      <p>These are The Remarks Provided to You By Students</p>\n" +
                            "      <table class='w3-table w3-border w3-bordered'>");
                
                ResultSet sg = st.executeQuery("select  remarks from feedbacks where f_id='"+fid+"'");
                int i=0;
                while(sg.next()){
                    String sugg = sg.getString(1);
                    if(sugg.length()>0){
                        i++;
                        out.println("<tr>\n" +
                                    " <td style='width:1%;'><strong>"+i+"</strong>.</td><td>"+sugg+"</td>\n" +
                                    "</tr>");
                    }
                
                }
                if(i==0) out.println("<tr>\n" +
                                    " <td style='width:1%;'></td><td>No Remarks Provided</td>\n" +
                                    "</tr>");
                
                //------------------------------------------------------------------------------------Suggestion Ends -------------------------------------------------------------------------------------------------------------------------------------------------------------
                
                out.println("     </table><br>\n" +
                            "    </div>\n" +
                            "  </div>\n" +
                            "</div>\n" +
                            "\n" +
                            "<script>\n" +
                            "// Script to open and close sidebar when on tablets and phones\n" +
                            "function w3_open() {\n" +
                            "    document.getElementById(\"mySidebar\").style.display = \"block\";\n" +
                            "    document.getElementById(\"myOverlay\").style.display = \"block\";\n" +
                            "}\n" +
                            " \n" +
                            "function w3_close() {\n" +
                            "    document.getElementById(\"mySidebar\").style.display = \"none\";\n" +
                            "    document.getElementById(\"myOverlay\").style.display = \"none\";\n" +
                            "}\n" +
                            "\n" +
                            "// Slideshow Apartment Images\n" +
                            "var slideIndex = 1;\n" +
                            "showDivs(slideIndex);\n" +
                            "\n" +
                            "function plusDivs(n) {\n" +
                            "  showDivs(slideIndex += n);\n" +
                            "}\n" +
                            "\n" +
                            "function currentDiv(n) {\n" +
                            "  showDivs(slideIndex = n);\n" +
                            "}\n" +
                            "\n" +
                            "function showDivs(n) {\n" +
                            "  var i;\n" +
                            "  var x = document.getElementsByClassName(\"mySlides\");\n" +
                            "  var dots = document.getElementsByClassName(\"demo\");\n" +
                            "  if (n > x.length) {slideIndex = 1}\n" +
                            "  if (n < 1) {slideIndex = x.length}\n" +
                            "  for (i = 0; i < x.length; i++) {\n" +
                            "     x[i].style.display = \"none\";\n" +
                            "  }\n" +
                            "  for (i = 0; i < dots.length; i++) {\n" +
                            "     dots[i].className = dots[i].className.replace(\" w3-opacity-off\", \"\");\n" +
                            "  }\n" +
                            "  x[slideIndex-1].style.display = \"block\";\n" +
                            "  dots[slideIndex-1].className += \" w3-opacity-off\";\n" +
                            "}\n" +
                            "</script>\n" +
                            "\n" +
                            "</body>\n" +
                            "</html>");
    
            con.close();
            }catch(SQLException e){
                System.out.println("msg1: "+e.getMessage());
                out.println("<h1>Server Error...</h1>");
            }
        }
        
    }
        String getGen(String g){
        if(g.equals("M")) return "images/avatar_mtchr.png";
        return "images/avatar_ftchr.png";
    
        }
        String GetColor(float f){
            if(f<25)
                return "w3-red";
            else if(f>=25&&f<50)
                return "w3-orange";
            else if(f>=50 && f<75)
                return "w3-blue";
            else
                return "w3-green";
        }
        
        float CalcPercent(int given,int total){
                return (given*100/total);
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
