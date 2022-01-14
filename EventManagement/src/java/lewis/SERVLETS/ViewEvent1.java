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
public class ViewEvent1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewEvent1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewEvent1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Event Page</title>");
        out.println("<link rel=\"stylesheet\" href=\"total.css\">");
        out.println("<link href=\"https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap\" rel=\"stylesheet\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet ViewEvent1 at " + request.getContextPath() + "</h1>");
        out.println("</body>");
        out.println("</html>");
        try{
                Connection conn = DBSupport.establishConnection();
                Statement use = conn.createStatement();
                use.execute("USE EventDatabase");
                
                response.setContentType("text/html;charset=UTF-8");
                String query = "Select * FROM Event";
                Statement queryStatement = conn.createStatement();
                ResultSet rs = queryStatement.executeQuery(query);
                
                out.println("<center><h1>Event Details</h1></center>");
                out.println("<br>");
                out.println("<div>");
                out.println("<center>");
                out.println("<table border=1 width=50% height=50%>");  
                out.println("<tr><th>EventNumber</th><th>EventName</th><th>Coordinator</th><th>Coordinator Contact</th><th>Fees</th><th>Venue</th><th>Date</th>"); 
                out.println("<center><h1>Event Added</h1><center>");
                
                while (rs.next()){
                    String en = rs.getString("enum");
                    String ename = rs.getString("ename");
                    String coord = rs.getString("coord");
                    String coordnum = rs.getString("coordnum");
                    String fee = rs.getString("fee");
                    String venue = rs.getString("venue");
                    String edate = rs.getString("edate");
                    out.println("<tr><td>" + en + "</td><td>" + ename +"</td><td>"+coord+"</td><td>"+coordnum+"</td><td>"+fee+"</td><td>"+venue+"</td><td>"+edate+"</td></tr>");   
                    
                }
                conn.commit();
                conn.close();
                out.println("</table>"); 
                out.println("</center>");
                out.print("</body>");
                out.print("</html>"); 
                
        }catch (Exception e){
            System.out.println(e);
        }
            
        };
    }
