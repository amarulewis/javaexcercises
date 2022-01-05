/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package lewis.SERVLETS;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author amaru
 */
@WebServlet(name = "ValidateAd", urlPatterns = {"/ValidateAd"})
public class ValidateAd extends HttpServlet {
        
        public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
                PrintWriter out = response.getWriter();
                
                //auth info
                String un = request.getParameter("Ausername");
                String pw = request.getParameter("Apassword");
                response.setContentType("text/html");

                //Sets of Admin usernames & passwords
                String u1 = "A101";
                String p1 = "1234";

                String u2 = "A102";
                String p2 = "5678";

                String u3 = "A103";
                String p3 = "ABCD";

                String u4 = "A104";
                String p4 = "abcd";
                
                if(pw.equals(p1) && un.equals(u1)){
                    RequestDispatcher rd = request.getRequestDispatcher("AdminEvent.html");
                    rd.forward(request, response);
                }
                else if(pw.equals(p2)&&un.equals(u2)){
                    RequestDispatcher rd = request.getRequestDispatcher("AdminEvent.html");
                    rd.forward(request, response);
                }
                else if(pw.equals(p3)&&un.equals(u3)){
                    RequestDispatcher rd = request.getRequestDispatcher("AdminEvent.html");
                    rd.forward(request, response);
                }
                else if(pw.equals(p4)&&un.equals(u4)){
                    RequestDispatcher rd = request.getRequestDispatcher("AdminEvent.html");
                    rd.forward(request, response);
                }
                else
                {
                    out.println("<center><h1>Please Enter a Valid Username or Password</h1></center>");
                    RequestDispatcher rd = request.getRequestDispatcher("Alogin.html");
                    rd.forward(request, response);
                }
            
        }
    }
