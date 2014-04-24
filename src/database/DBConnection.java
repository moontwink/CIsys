package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static String dbUrl; 
    private static String dbName; 
    private static String dbDriver; 
    private static String username; 
    private static String password; 
    private static Connection conn; 
      
    public static void connect(){ 
        dbUrl = "jdbc:mysql://localhost:3306/"; 
        dbName = "accounts"; 
        dbDriver = "com.mysql.jdbc.Driver"; 
        username = "root"; 
        password = ""; 
          
        try { 
	        Class.forName(dbDriver).newInstance(); 
	        conn = DriverManager.getConnection(dbUrl+dbName,username,password); 
        }catch(Exception e){ 
            e.printStackTrace();
        } 
    } 
      
    public static Connection getConnection(){ 
        return conn; 
    } 
      
    public void disconnect(){ 
        try { 
            conn.close(); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        } 
    } 
}
