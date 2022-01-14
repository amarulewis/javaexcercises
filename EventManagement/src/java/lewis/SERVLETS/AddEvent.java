/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package lewis.SERVLETS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
public class AddEvent extends HttpServlet {

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
            out.println("<title>Servlet AddEvent</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddEvent at " + request.getContextPath() + "</h1>");
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        //fetch data
        PrintWriter out = response.getWriter();
        String EventNo = request.getParameter("EventNo");
        String EventName = request.getParameter("EventName");
        String coordinatorName = request.getParameter("coordinatorName");
        String coordinatorNo = request.getParameter("coordinatorNo");
        String fee = request.getParameter("fee");
        String venue = request.getParameter("venue");
        
        try{
                Connection conn = DBSupport.establishConnection();
                Statement use = conn.createStatement();
                use.execute("USE EventDatabase");

                String statement = "insert into Event values('"+EventNo+"','"+EventName+"','"+coordinatorName+"','"+coordinatorNo+"','"+fee+"','"+venue+"');";
                Statement insert = conn.createStatement();
                insert.execute(statement);
                
                RequestDispatcher rd=request.getRequestDispatcher("CreateE.html");
                rd.include(request, response);
                
                out.println("<center><h1>Event Added</h1><center>");
                System.out.println("Added to Database!");
                conn.commit();
                conn.close();
                
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
