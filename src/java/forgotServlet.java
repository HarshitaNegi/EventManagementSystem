/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author HP
 */
public class forgotServlet extends HttpServlet {

    private Object rs;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String username = request.getParameter("username");
        String book = request.getParameter("book");
         String movie = request.getParameter("movie");
          String festival = request.getParameter("festival");
        PrintWriter out = response.getWriter();
        
            
       // out.println(email+""+password);
        
        try {
            forgetDAO l = new forgetDAO();
            String result = l.checkInfo( username,book,movie,festival);
            if(result.equals("Login successful"))
            {
                RequestDispatcher rd=request.getRequestDispatcher("reset.html");
                rd.forward(request, response);
            }
            else
            {
                RequestDispatcher rd=request.getRequestDispatcher("forgot.html");
                rd.include(request,response);
            }
           // out.println(result);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }




}
