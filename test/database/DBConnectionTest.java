package database;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.junit.Test;

import com.mysql.jdbc.CommunicationsException;

import database.DBConnection;

public class DBConnectionTest {

	@Test
	public void testGetConnection() throws ClassNotFoundException  {
		String driver = "com.mysql.jdbc.Driver";
	    Class.forName(driver);
	}

	@Test
	public void testGetConnectionWithSQLEx() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/";
	    String dbName = "accounts";
	    String username = "root";
	    String password = "";
	    
		Connection actual = null;
		try {
			actual = DBConnection.getConnection();
		} catch (ClassNotFoundException e) {
			Logger.getLogger(DBConnectionTest.class.getName()).log(Level.SEVERE, null, e);
		}
		assertNotNull(actual);
	}
	
	@Test
	public void testCloseConnection() throws ClassNotFoundException, SQLException {
		Connection c = DBConnection.getConnection();
		assertNotNull(c);
		DBConnection.closeConnection(c);
	}

}
