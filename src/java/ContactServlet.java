
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ContactServlet extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("name");  
String p=request.getParameter("email");  
String e=request.getParameter("subject");  
String c=request.getParameter("message");  
          
try{  
String myurl="jdbc:mysql://localhost:3306/mydb";
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(myurl,"root","");  
  
PreparedStatement ps=conn.prepareStatement(  
"insert into contacts values(?,?,?,?)");  
  
ps.setString(1,n);  
ps.setString(2,p);  
ps.setString(3,e);  
ps.setString(4,c);  
          
int i=ps.executeUpdate();  
if(i>0)  
{
          
            if(i>0)
            {
                RequestDispatcher rd=request.getRequestDispatcher("successful.html");
                rd.forward(request, response);
            }
            else
            {
                RequestDispatcher rd=request.getRequestDispatcher("contact.html");
                rd.include(request,response);
            }
  }


          
}catch (Exception e2) {
    out.print("Error it is..."+e2);  
System.out.println(e2);}  
          
out.close();  
}  
  
}