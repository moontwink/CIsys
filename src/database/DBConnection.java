
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        	Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
