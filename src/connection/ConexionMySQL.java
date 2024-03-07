/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * 
 */
public class ConexionMySQL {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    private static final String DATABASE = "parcial_uno";

    private static final String HOSTNAME = "localhost";
    
    private static final String PORT = "3306";
    
    private static final String URL = "jdbc:mysql://" + HOSTNAME + ":" + PORT + "/" + DATABASE + "?useSSL=false&allowPublicKeyRetrieval=True";
   
    private static final String USERNAME = "root";
  
    private static final String PASSWORD = "clavecita1357";

    /**
     * 
     * @return Database connection.
     */
    public static Connection conectarMySQL() {
        Connection conn = null;
        try {            
            Class.forName(DRIVER);            
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {            
            e.printStackTrace();
        }        
        return conn;
    }
}
