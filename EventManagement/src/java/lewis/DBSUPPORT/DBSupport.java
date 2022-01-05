/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lewis.DBSUPPORT;

/**
 *
 * @author amaru
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBSupport {
    //SQL CONNECTION
    public static Connection establishConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connect = null;
        Properties connectProp = new Properties();
        connectProp.put("dbms", "mysql");
        connectProp.put("user", "root");
        connectProp.put("password", "0cXEl4SHnn*&Sto@");
        connectProp.put("useSSL", "false");
        String P1 = "jdbc:";
        String P2 = "mysql";
        String P3 = "://";
        String P4 = "localhost:";
        int Port = 3306;
        String P5 = "/";
        String connectString = P1 + P2 + P3 + P4 + Port + P5; //jdbc:mysql://localhost:3306/?user=root
        connect = DriverManager.getConnection(connectString, connectProp);
        System.out.println("Connected To Database");
        return connect;
    }
}

