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
import java.sql.SQLException;
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
public class Home extends HttpServlet {

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
            out.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<title>UIET KANPUR</title>\n" +
                "\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<link rel=\"stylesheet\" href=\"css/w3.css\">\n" +
                "\n" +
                "<link rel=\"stylesheet\" href=\"css/selection window.css\" type=\"text/css\">\n" +
                "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
                "\n" +
                "<link href=\"https://fonts.googleapis.com/css?family=Work+Sans:300,400,500,700,800\" rel=\"stylesheet\">\n" +
                "  \n" +
                "  <!-- Animate.css -->\n" +
                "  <link rel=\"stylesheet\" href=\"css/animate.css\">\n" +
                "  <!-- Bootstrap  -->\n" +
                "  <link rel=\"stylesheet\" href=\"css/bootstrap.css\">\n" +
                "  <!-- Flexslider  -->\n" +
                "  <link rel=\"stylesheet\" href=\"css/flexslider.css\">\n" +
                "\n" +
                "  <!-- Theme style  -->\n" +
                "  <link rel=\"stylesheet\" href=\"css/style.css\">\n" +
                "  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Lato|Quicksand'>\n" +
                "\n" +
                "   <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css'>\n" +
                "\n" +
                "  <!-- Modernizr JS -->\n" +
                "  <script src=\"js/modernizr-2.6.2.min.js\"></script>\n" +
                "  <!-- FOR IE9 below -->\n" +
                "\n" +
                "\n"
                    + "<link rel=\"shortcut icon\" href=\"favicon.ico\" type=\"image/x-icon\"/>" +
                "<body>\n" +
                "\n" +
                "<!--------------------------------------------------------------------selection window popup starts here-------------------------------------------------->\n" +
                "    \n" +
                "        <div class=\"modal2_container\" id=\"modal2\">\n" +
                "            <div class=\"modal2\">\n" +
                "                <a href=\"#\" class=\"close2\">X</a>\n" +
                "                <span class=\"modal2_heading\">\n" +
                "                    ENTER YOUR DETAILS\n" +
                "                </span>\n" +
                "                <form action='GiveFeedback'>\n" +
                "\n" +
                "                    <div class=\"sel sel--black-panther\">\n" +
                "                      <select name=\"department\" id=\"select-profession\">\n" +
                "                        <option value=\"\" disabled>Select Your Department</option>\n" +
                "                        <option value=\"CHE\">Chemical Engineering</option>\n" +
                "                        <option value=\"CSE\">Computer Science and Engineering</option>\n" +
                "                        <option value=\"ECE\">Electronics and Communications Engineering</option>\n" +
                "                        <option value=\"MEE\">Mechanical Engineering</option>\n" +
                "                        <option value=\"MSME\">Material Science and Metallurgical Engineering</option>\n" +
                "                        <option value=\"IT\">Information Technology</option>\n" +
                "                      </select>\n" +
                "                    </div>\n" +
                "\n" +
                "                    <div class=\"sel sel--superman\">\n" +
                "                      <select name=\"semester\" id=\"select-superpower\" style='overflow'>\n" +
                "                        <option value=\"\" disabled>Select Semester</option>\n" +
                "                        <option value=\"1\">Semester - I</option>\n" +
                "                        <option value=\"2\">Semester - II</option>\n" +
                "                        <option value=\"3\">Semester - III</option>\n" +
                "                        <option value=\"4\">Semester - IV</option>\n" +
                "                        <option value=\"5\">Semester - V</option>\n" +
                "                        <option value=\"6\">Semester - VI</option>\n" +
                "                        <option value=\"7\">Semester - VII</option>\n" +
                "                        <option value=\"8\">Semester - VIII</option>\n" +
                "                      </select>\n" +
                "                    </div>\n" +
                "                    <input  type=\"submit\" class=\"btnRegister\" value=\"GO\">\n" +
                "                   \n" +
                "                </form>\n" +
                "               \n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>\n" +
                "<script src=\"js/selection.js\"></script>\n" +
                "\n" +
                "<!--------------------------------------------------------------------selection window popup ends here-------------------------------------------------->\n" +
                "\n" +
                "<!-- Navbar -->\n" +
                "<div class=\"w3-top\">\n" +
                "  <div class=\"w3-bar w3-black w3-card\">\n" +
                "    <a class=\"w3-bar-item w3-button w3-padding-large w3-hide-medium w3-hide-large w3-right\" href=\"javascript:void(0)\" onclick=\"myFunction()\" title=\"Toggle Navigation Menu\"><i class=\"fa fa-bars\"></i></a>\n" +
                "    <a href=\"#\" class=\"w3-bar-item w3-button w3-padding-large\">HOME</a>\n" +
                "    <a href=\"#about\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">ABOUT</a>\n" +
                "    <a href=\"#courses\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">COURSES</a>\n" +
                "    <a href=\"#contact\" class=\"w3-bar-item w3-button w3-padding-large w3-hide-small\">CONTACT US</a>\n" +
                "    <div class=\"w3-dropdown-hover w3-hide-small\">\n" +
                "      <button class=\"w3-padding-large w3-button\" title=\"More\">MORE <i class=\"fa fa-caret-down\"></i></button>     \n" +
                "      <div class=\"w3-dropdown-content w3-bar-block w3-card-4\">\n" +
                "        \n" +
                "        <a href=\"http://uietkanpur.com/alumni.php\" class=\"w3-bar-item w3-button\">ALUMNI ASSOCIATION</a>\n" +
                "        <a href=\"http://uietkanpur.com/AlumniCommittee.php\" class=\"w3-bar-item w3-button\">ALUMINI COMMITTEE</a>\n" +
                "        <a href=\"http://uietkanpur.com/alumnigal.php\" class=\"w3-bar-item w3-button\">GALLERY</a>\n" +
                "\n" +
                "      </div>\n" +
                "    </div>\n" +
                "    <a href='showDep' class=\"w3-padding-large w3-hover-red w3-hide-small w3-right\">View Ratings</a>\n" +
                "  </div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "<div class=\"w3-content\" style=\"max-width:2000px;margin-top:46px\">\n" +
                "  <div class=\"fh5co-loader\"></div>\n" +
                "  \n" +
                "  <div id=\"page\">\n" +
                "  \n" +
                "  <aside id=\"fh5co-hero\" class=\"js-fullheight\">\n" +
                "    <div class=\"flexslider js-fullheight\">\n" +
                "      <ul class=\"slides\">\n" +
                "        <li style=\"background-image: url(images/img_bg_1.jpg);\">\n" +
                "          <div class=\"overlay-gradient\"></div>\n" +
                "          <div class=\"container\">\n" +
                "            <div class=\"row\">\n" +
                "              <div class=\"col-md-8 col-md-offset-2 text-center js-fullheight slider-text\">\n" +
                "                <div class=\"slider-text-inner\">\n" +
                "                  <h1>Your Feedback Makes us better</h1>\n" +
                "                  \n" +
                "                  <p><a class=\"btn btn-primary btn-lg\" href=\"#modal2\">GIVE YOUR FEEDBACK HERE</a></p>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "          </div>\n" +
                "        </li>\n" +
                "        <li style=\"background-image: url(images/img_bg_2.jpg);\">\n" +
                "          <div class=\"overlay-gradient\"></div>\n" +
                "          <div class=\"container\">\n" +
                "            <div class=\"row\">\n" +
                "              <div class=\"col-md-8 col-md-offset-2 text-center js-fullheight slider-text\">\n" +
                "                <div class=\"slider-text-inner\">\n" +
                "                  <h1>Your Feedback Makes us better</h1>\n" +
                "                  \n" +
                "                  <p><a class=\"btn btn-primary btn-lg btn-learn\" href=\"#modal2\">GIVE YOUR FEEDBACK HERE</a></p>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "          </div>\n" +
                "        </li>\n" +
                "        <li style=\"background-image: url(images/img_bg_3.jpg);\">\n" +
                "          <div class=\"overlay-gradient\"></div>\n" +
                "          <div class=\"container\">\n" +
                "            <div class=\"row\">\n" +
                "              <div class=\"col-md-8 col-md-offset-2 text-center js-fullheight slider-text\">\n" +
                "                <div class=\"slider-text-inner\">\n" +
                "                  <h1>Your Feedback Makes us better</h1>\n" +
                "                  \n" +
                "                  <p ><a class=\"btn btn-primary btn-lg btn-learn\" href=\"#modal2\">GIVE YOUR FEEDBACK HERE</a></p>\n" +
                "                </div>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "          </div>\n" +
                "        </li>       \n" +
                "        </ul>\n" +
                "      </div>\n" +
                "  </aside>\n" +
                "\n" +
                "  <!-- The about Section -->\n" +
                "  <div class=\"w3-container w3-content w3-center w3-padding-64\" style=\"max-width:800px\" id=\"about\">\n" +
                "    <h2 class=\"w3-wide\">University Institute of Engineering and Technology</h2>\n" +
                "    <p class=\"w3-opacity\"><i>\"A PLACE TO LEARN AND GROW\"</i></p>\n" +
                "    <p class=\"w3-justify\">The University Institute of Engineering & Technology (UIET) was founded with a vision to serve the country in the 21st century by offering its students advanced knowledge in Engineering and Technology, Science and other areas of scholarship. The intellectual stimulation that is provided to each member of University Institute of Engineering and Technology community generates a passion in him/her to work wisely, creatively and effectively for the national development.\n" +
                "    </p>\n" +
                "    <p class=\"w3-justify\">Spreading over a campus of 264 acres, the university is booming with academic activities.For catering to the needs of young engineering aspirants, the university has started an Institute of Engineering and Technology in the campus offering courses in six branches of engineering viz. Chemical, Computer Science and Information, Mechanical Engineering,Electronics & Communication and Material Science & Engineering in the first instance. The university seeks to contribute to student an education through curriculum design, the development of new courses and the application of a forward looking and innovative teaching methodology.\n" +
                "      \n" +
                "    </p>\n" +
                "    <p class=\"w3-justify\">Over the years, there has been a continuous progress in all-academic activities. Parallel improvements in facilities and infrastructure to keep this institute at par with others have been made. It is also evolving and changing with national aspirations, national perspectives and worldwide trends.\n" +
                "	</p>\n" +
                "  </div>\n" +
                "\n" +
                "  <!-- The courses Section -->\n" +
                "  <div class=\"w3-black\" id=\"courses\">\n" +
                "    <!--div class=\"w3-container w3-content w3-padding-64\" -->\n" +
                "    <br>\n" +
                "    <br>\n" +
                "      <h1 class=\"w3-wide w3-center\">ACADEMIC PROGRAMS </h1> \n" +
                "      <br>\n" +
                "      <br>\n" +
                "      <H2 class=\"w3-large\">Bachelor of Technology (B.Tech) Program:</H2>\n" +
                "\n" +
                "      <div class=\"w3-container w3-opacity\">\n" +
                "  \n" +
                "            \n" +
                "             <li><a href='http://uietkanpur.com/che.php'>Chemical Engineering</li>\n" +
                "             <li><a href='http://uietkanpur.com/cse.php'>Computer Science and Engineering.</a></li>\n" +
                "             <li><a href='http://uietkanpur.com/ec.php'>Electronics and Communications Engineering</li>\n" +
                "             <li><a href='http://uietkanpur.com/mee.php'>Mechanical Engineering</a></li>\n" +
                "             <li><a href='http://uietkanpur.com/msme.php'>Material Science and Metallurgical Engineering</li>\n" +
                "             <li><a href='http://uietkanpur.com/IT.php'>Information Technology</a></li>\n" +
                "           </ul>\n" +
                "      </div>\n" +
                "      <br>\n" +
                "      <br>\n" +
                "      <h2 class=\"w3-large\">Career-Oriented Courses:</h2>\n" +
                "\n" +
                "      <div class=\"w3-container w3-opacity\">\n" +
                "  \n" +
                "            \n" +
                "             <li><a href='http://uietkanpur.com/ca.php'>Master of Computer Application(MCA)</a></li>\n" +
                "             <li><a href='http://uietkanpur.com/ca.php'>Bachelor of Computer Application(BCA)</a></li>\n" +
                "             <li><a href='http://uietkanpur.com/AD.php'>One year Advanced PG Diploma in Bioinformatics</a></li>\n" +
                "           </ul>\n" +
                "      </div>\n" +
                "      <br>\n" +
                "      <br>\n" +
                "      <h2 class=\"w3-large\">Master of Science (M.Sc) program :</h2>\n" +
                "      \n" +
                "      <div class=\"w3-container w3-opacity\">\n" +
                "  \n" +
                "            \n" +
                "             <li><a href='http://uietkanpur.com/PG.php'>2-year M.Sc(Electronics) program</a></li>\n" +
                "             <li><a href='http://uietkanpur.com/PG.php'>2-year M.Sc(Bioinformatics) program</a></li>\n" +
                "           </ul>\n" +
                "      </div>\n" +
                "      <br>\n" +
                "      <br>\n" +
                "      <h2 class=\"w3-large\">Master of Philosophy (M.Phil) program :</h2>\n" +
                "      \n" +
                "      <div class=\"w3-container w3-opacity\">\n" +
                "  \n" +
                "            \n" +
                "             <li><a href='http://uietkanpur.com/M.Phil.php'>2-year M.Phil(Physics) program</a></li>\n" +
                "             <li><a href='http://uietkanpur.com/M.Phil.php'>2-year M.Phil(Chemistry) program</a></li>\n" +
                "             <li><a href='http://uietkanpur.com/M.Phil.php'>2-year M.Phil(Mathematics) program</a></li>\n" +
                "           </ul>\n" +
                "      </div>\n" +
                "      <br>\n" +
                "      <br>\n" +
                "      \n" +
                "    </div>\n" +
                "          \n" +
                "\n" +
                "\n" +
                "  <!-- The Contact Section -->\n" +
                "  <div class=\"w3-container w3-content w3-padding-64\" style=\"max-width:800px\" id=\"contact\">\n" +
                "    <h2 class=\"w3-wide w3-center\">CONTACT</h2>\n" +
                "    <p class=\"w3-opacity w3-center\"><i>wanna Drop a note?</i></p>\n" +
                "    <div class=\"w3-row w3-padding-32\">\n" +
                "      <div class=\"w3-col m6 w3-large w3-margin-bottom\">\n" +
                "        <i class=\"fa fa-map-marker\" style=\"width:30px\"></i> UIET, KANPUR<br>\n" +
                "        <i class=\"fa fa-phone\" style=\"width:30px\"></i> Phone: +91 (512) 258-0047 (office)<br>\n" +
                "        <i class=\"fa fa-envelope\" style=\"width:30px\"> </i> Email: mail@uietkanpur.com<br>\n" +
                "      </div>\n" +
                "      <div class=\"w3-col m6\">\n" +
                "        <form action=\"/action_page.php\" target=\"_blank\">\n" +
                "          <div class=\"w3-row-padding\" style=\"margin:0 -16px 8px -16px\">\n" +
                "            <div class=\"w3-half\">\n" +
                "              <input class=\"w3-input w3-border\" type=\"text\" placeholder=\"Name\" required name=\"Name\">\n" +
                "            </div>\n" +
                "            <div class=\"w3-half\">\n" +
                "              <input class=\"w3-input w3-border\" type=\"text\" placeholder=\"Email\" required name=\"Email\">\n" +
                "            </div>\n" +
                "          </div>\n" +
                "          <input class=\"w3-input w3-border\" type=\"text\" placeholder=\"Message\" required name=\"Message\">\n" +
                "          <button class=\"w3-button w3-black w3-section w3-right\" type=\"submit\">SEND</button>\n" +
                "        </form>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  </div>              \n" +
                "  \n" +
                "\n" +
                "  <!-- jQuery -->\n" +
                "  <script src=\"js/jquery.min.js\"></script>\n" +
                "  <!-- jQuery Easing -->\n" +
                "  <script src=\"js/jquery.easing.1.3.js\"></script>\n" +
                "  <!-- Bootstrap -->\n" +
                "  \n" +
                "  <!-- Waypoints -->\n" +
                "  <script src=\"js/jquery.waypoints.min.js\"></script>\n" +
                "  <!-- Stellar Parallax -->\n" +
                "  \n" +
                "  <script src=\"js/owl.carousel.min.js\"></script>\n" +
                "  <!-- Flexslider -->\n" +
                "  <script src=\"js/jquery.flexslider-min.js\"></script>\n" +
                "  <!-- countTo -->\n" +
                "  <script src=\"js/jquery.countTo.js\"></script>\n" +
                "  \n" +
                "  <!-- Main -->\n" +
                "  <script src=\"js/main.js\"></script>\n" +
                "\n" +
                "<!-- End Page Content -->\n" +
                "</div>\n" +
                "<!-- Footer -->\n" +
                "<footer class=\"w3-container w3-padding-64 w3-center w3-opacity w3-light-grey w3-xlarge\">\n" +
                "  <i class=\"fa fa-facebook-official w3-hover-opacity\"></i>\n" +
                "  <i class=\"fa fa-instagram w3-hover-opacity\"></i>\n" +
                "  <i class=\"fa fa-snapchat w3-hover-opacity\"></i>\n" +
                "  <i class=\"fa fa-pinterest-p w3-hover-opacity\"></i>\n" +
                "  <i class=\"fa fa-twitter w3-hover-opacity\"></i>\n" +
                "  <i class=\"fa fa-linkedin w3-hover-opacity\"></i>\n" +
                "  <p>Powered by <a href='aboutayush' title='Ayush Chaurasia' target='#' class=\"w3-hover-text-green w3-text-black\">ayush chaurasia</a></p>"+
                "</footer>\n" +
                "\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "</html>");
            this.createConnectionPool();
        }
    }
    
     private void createConnectionPool() {
        Connection con = null;
        Context ctx=null; 
      try {
            ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("mysqldb");
        } catch (NamingException ex) {
            System.out.println("sql : "+ex.getMessage());
            MysqlConnectionPoolDataSource mcpds = new MysqlConnectionPoolDataSource();;
            mcpds.setURL("jdbc:mysql://localhost:3306/uiet");
            try {
                con = mcpds.getConnection("root", "123456");
                ctx.bind("mysqldb", mcpds);
            } catch (SQLException ex1) {
                System.out.println("sqlex : "+ex1.getMessage());
            } catch (NamingException ex1) {
                System.out.println("ne : "+ex1.getMessage());
            }
            
            
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
