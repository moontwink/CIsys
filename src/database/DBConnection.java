package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private String dbUrl; 
    private String dbName; 
    private String dbDriver; 
    private String username; 
    private String password; 
    private Connection conn; 
      
    public void connect(){ 
        dbUrl = "jdbc:mysql://localhost:3306/"; 
        dbName = "mydb"; 
        dbDriver = "com.mysql.jdbc.Driver"; 
        username = "root"; 
        password = "1234"; 
          
        try { 
        Class.forName(dbDriver).newInstance(); 
        conn = DriverManager.getConnection(dbUrl+dbName,username,password); 
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
    } 
      
    public Connection getConnection(){ 
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
