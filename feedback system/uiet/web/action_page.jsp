<%-- 
    Document   : action_page
    Created on : 23 Sep, 2018, 1:15:26 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Value Submitted</title>
    </head>
    <body>
        
        <%
            Enumeration<String> en = request.getParameterNames();
            if(!en.hasMoreElements()){
        %>
        <p>No data is submitted...</p>
        <%
            }
            else{
        %>
        <h1>Your Submitted Data...</h1>
        <%
                while(en.hasMoreElements()){
                  String val=  en.nextElement();
                  System.out.println(val);
                
        %>
        <p><%= val%> : <%= request.getParameter(val)%></p>
        <% 
        }
        }   
        %>
    </body>
</html>
