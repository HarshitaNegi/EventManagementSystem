
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


public class Weddingdetails extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String a=request.getParameter("bride");  
String b=request.getParameter("groom");  
String c=request.getParameter("email");  
String d=request.getParameter("phone");  
String e=request.getParameter("address");
String f=request.getParameter("pincode");
String g=request.getParameter("city");
String h=request.getParameter("state");
String j=request.getParameter("sname"); 
String k=request.getParameter("ename");
String l=request.getParameter("vtype");
String n=request.getParameter("budget");
String o=request.getParameter("details");  

          
try{  
String myurl="jdbc:mysql://localhost:3306/mydb";
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(myurl,"root","");  
  
PreparedStatement ps=conn.prepareStatement(  
"insert into weddings values(?,?,?,?,?,?,?,?,?,?,?,?,?)");  
  
ps.setString(1,a);  
ps.setString(2,b);  
ps.setString(3,c);  
ps.setString(4,d);  
ps.setString(5,e);
ps.setString(6,f);
ps.setString(7,g);  
ps.setString(8,h);
ps.setString(9,j);
ps.setString(10,k);
ps.setString(11,l);
ps.setString(12,n);
ps.setString(13,o);  

          
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
                RequestDispatcher rd=request.getRequestDispatcher("wedding.html");
                rd.include(request,response);
            }
  }

          
}catch (Exception e2) {
    out.print("Error it is..."+e2);  
System.out.println(e2);}  
          
out.close();  
}  
  
}