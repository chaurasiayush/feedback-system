/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aboutDeveloper;

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
public class aboutayush extends HttpServlet {

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
            out.println("<html lang=\"en\">\n" +
                        "<title>About Developer</title>\n" +
                        "<meta charset=\"UTF-8\">\n" +
                        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" +
                        "<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Montserrat\">\n" +
                        "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n"
                      + "<link rel=\"shortcut icon\" href=\"favicon.ico\" type=\"image/x-icon\"/>" +
                        "<style>\n" +
                        "body, h1,h2,h3,h4,h5,h6 {font-family: \"Montserrat\", sans-serif}\n" +
                        ".w3-row-padding img {margin-bottom: 12px}\n" +
                        "/* Set the width of the sidebar to 120px */\n" +
                        ".w3-sidebar {width: 120px;background: #222;}\n" +
                        "/* Add a left margin to the \"page content\" that matches the width of the sidebar (120px) */\n" +
                        "\n" +
                        "/* Remove margins from \"page content\" on small screens */\n" +
                        "@media only screen and (max-width: 600px) {#main {margin-left: 0}}\n" +
                        "</style>");

            out.println("<body class=\"w3-black\">");
            out.println("<!-- Page Content -->\n" +
                        "<div class=\"w3-padding-large\" id=\"main\">\n" +
                        "  <!-- Header/Home -->\n" +
                        "  <header class=\"w3-container w3-padding-32 w3-center w3-black\" id=\"home\">\n" +
                        "    <h1 class=\"w3-jumbo\"><span class=\"w3-hide-small\">I'm</span> Ayush Chaurasia.</h1>\n" +
                        "    <p>Programmer and Web Designer.</p>\n" +
                        "    <img src=\"images/me.jpg\" alt=\"boy\" class=\"w3-image\" width=\"992\" height=\"1108\">\n" +
                        "  </header>");
            out.println("<!-- About Section -->\n" +
                        "  <div class=\"w3-content w3-justify w3-text-grey w3-padding-64\" id=\"about\">\n" +
                        "    <h2 class=\"w3-text-light-grey\">My Name</h2>\n" +
                        "    <hr style=\"width:200px\" class=\"w3-opacity\">\n" +
                        "    <p>My name is Ayush Chaurasiya. I'm an engineering student at UIET kanpur. I am lorem ipsum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip\n" +
                        "      ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur\n" +
                        "      adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\n" +
                        "    </p>\n" +
                        "    <h3 class=\"w3-padding-16 w3-text-light-grey\">My Skills</h3>\n" +
                        "    <p class=\"w3-wide\">Photography</p>\n" +
                        "    <div class=\"w3-white\">\n" +
                        "      <div class=\"w3-dark-grey\" style=\"height:28px;width:95%\"></div>\n" +
                        "    </div>\n" +
                        "    <p class=\"w3-wide\">Web Design</p>\n" +
                        "    <div class=\"w3-white\">\n" +
                        "      <div class=\"w3-dark-grey\" style=\"height:28px;width:75%\"></div>\n" +
                        "    </div>\n" +
                        "    <p class=\"w3-wide\">Programming</p>\n" +
                        "    <div class=\"w3-white\">\n" +
                        "      <div class=\"w3-dark-grey\" style=\"height:28px;width:80%\"></div>\n" +
                        "    </div><br>"
                      + "</div>");
            out.println(" <!-- Contact Section -->\n" +
                        "  <div class=\"w3-padding-64 w3-content w3-text-grey\" id=\"contact\">\n" +
                        "    <h2 class=\"w3-text-light-grey\">Contact Me</h2>\n" +
                        "    <hr style=\"width:200px\" class=\"w3-opacity\">\n" +
                        "\n" +
                        "    <div class=\"w3-section\">\n" +
                        "      <p><i class=\"fa fa-map-marker fa-fw w3-text-white w3-xxlarge w3-margin-right\"></i> Kanpur, INDIA</p>\n" +
                        "      <p><i class=\"fa fa-phone fa-fw w3-text-white w3-xxlarge w3-margin-right\"></i> Phone: +91 6386435738</p>\n" +
                        "      <p><i class=\"fa fa-envelope fa-fw w3-text-white w3-xxlarge w3-margin-right\"> </i> Email: uiet.ayush@gmail.com</p>\n" +
                        "    </div><br>\n" +
                        "    <p>Lets get in touch. Send me a message:</p>\n" +
                        "\n" +
                        "    <form action=\"/action_page.php\" target=\"_blank\">\n" +
                        "      <p><input class=\"w3-input w3-padding-16\" type=\"text\" placeholder=\"Name\" required name=\"Name\"></p>\n" +
                        "      <p><input class=\"w3-input w3-padding-16\" type=\"text\" placeholder=\"Email\" required name=\"Email\"></p>\n" +
                        "      <p><input class=\"w3-input w3-padding-16\" type=\"text\" placeholder=\"Subject\" required name=\"Subject\"></p>\n" +
                        "      <p><input class=\"w3-input w3-padding-16\" type=\"text\" placeholder=\"Message\" required name=\"Message\"></p>\n" +
                        "      <p>\n" +
                        "        <button class=\"w3-button w3-light-grey w3-padding-large\" type=\"submit\">\n" +
                        "          <i class=\"fa fa-paper-plane\"></i> SEND MESSAGE\n" +
                        "        </button>\n" +
                        "      </p>\n" +
                        "    </form>\n" +
                        "  <!-- End Contact Section -->\n" +
                        "  </div>\n" +
                        "  ");
            out.println("  </footer>");
            out.println("<!-- END PAGE CONTENT -->\n" +
                        "</div>");
           // out.println("");
           //out.println("");
            
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
