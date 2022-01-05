/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lewis.DBSUPPORT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author amaru
 */
public class LoginDao {
    public static boolean validate(String Username, String Password){
        boolean status = false;
        
        try{
                Connection conn = DBSupport.establishConnection();
                Statement use = conn.createStatement();
                use.execute("USE EventDatabase");

                PreparedStatement st = conn.prepareStatement("Select * FROM plogindetails WHERE username=? AND password=?");
                st.setString(1,Username);
                st.setString(2,Password);
                ResultSet rs = st.executeQuery();
                status = rs.next();
                
                
                conn.close();
        } catch (Exception e){
            System.out.println(e);
        }
        
       return status;
    }
}
