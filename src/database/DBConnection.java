
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/";
    static String dbName = "accounts";
    static String username = "root";
    static String password = "";
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url+dbName, username, password);
			
        return connection;
    }
    
    public static void closeConnection(Connection c) {
        try {
            c.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
	
	/*
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
    } */
}
