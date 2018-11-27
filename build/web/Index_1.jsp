<%-- 
    Document   : Index_1
    Created on : Nov 12, 2018, 11:32:31 PM
    Author     : HP
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            try{
            String username = request.getParameter("email");
            String password = request.getParameter("password");
            
            String myurl="jdbc:mysql://localhost:3306/mydb";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn=DriverManager.getConnection(myurl,"root","");
                Statement st=conn.createStatement();
                String query1="select * from user where email="+username+" and password='"+password+"'";
                ResultSet rs=st.executeQuery(query1);
                
            if(rs.next())
                out.println("welcome"+ username+"to this website");
                else
                 out.println("not found");
                st.close();
            
            }
            catch(Exception e)
            {
                System.err.println("got an exception");
                System.err.println(e.getMessage());
            }
   
        %>
    </body>
</html>
