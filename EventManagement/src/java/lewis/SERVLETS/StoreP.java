/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package lewis.SERVLETS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lewis.DBSUPPORT.DBSupport;

/**
 *
 * @author amaru
 */
public class StoreP extends HttpServlet {

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
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StoreP</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StoreP at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html");
        
        //fetch data
        PrintWriter out = response.getWriter();
        String up = request.getParameter("Pusername");
        String pp = request.getParameter("Ppassword");
        String cp = request.getParameter("Cpassword");
        String name = request.getParameter("Pname");
        
        String a1 = up;
        String a2 = pp;
        String a3 = cp;
        String a4 = name;
        
        if(a2.equals(a3)){
            try{
                Connection conn = DBSupport.establishConnection();
                Statement use = conn.createStatement();
                use.execute("USE EventDatabase");

                String statement = "insert into plogindetails values('"+a1+"','"+a2+"','"+a4+"');";
                Statement insert = conn.createStatement();
                insert.execute(statement);
                
                RequestDispatcher rd=request.getRequestDispatcher("Plogin.html");
                rd.forward(request, response);
                conn.close();
        } catch (Exception e){
            System.out.println(e);
        }
        
    } else
        {
            out.println("<center><h1>!! Please Enter Password And Confirm Password Same !!</h1><center>");
            RequestDispatcher rd=request.getRequestDispatcher("Psignup.html");
            rd.include(request, response);
        }
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
