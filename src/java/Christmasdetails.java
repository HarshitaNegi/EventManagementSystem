
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


public class Christmasdetails extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("fname");  
String p=request.getParameter("lname");  
String e=request.getParameter("email");  
String c=request.getParameter("phone");  
String d=request.getParameter("address");  
String a=request.getParameter("pincode");  
String f=request.getParameter("city");  
String g=request.getParameter("state");   
String r=request.getParameter("hname");
String h=request.getParameter("ename");
String o=request.getParameter("vtype");
String m=request.getParameter("budget");
String k=request.getParameter("details");  

try{  
String myurl="jdbc:mysql://localhost:3306/mydb";
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn=DriverManager.getConnection(myurl,"root","");  
  
PreparedStatement ps=conn.prepareStatement(  
"insert into christmast values(?,?,?,?,?,?,?,?,?,?,?,?,?)");  
  
ps.setString(1,n);  
ps.setString(2,p);  
ps.setString(3,e);  
ps.setString(4,c);  
ps.setString(5,d); 
ps.setString(6,a); 
ps.setString(7,f); 
ps.setString(8,g); 
ps.setString(9,r); 
ps.setString(10,h); 
ps.setString(11,o); 
ps.setString(12,m); 
ps.setString(13,k); 
 int i=ps.executeUpdate(); 
  {
          
            if(i>0)
            {
                RequestDispatcher rd=request.getRequestDispatcher("successful.html");
                rd.forward(request, response);
            }
            else
            {
                RequestDispatcher rd=request.getRequestDispatcher("christmas.html");
                rd.include(request,response);
            }
  }

}catch (Exception e2) {
    out.print("Error it is ..."+e2);  
System.out.println(e2);}  
          
out.close();  
}  

}