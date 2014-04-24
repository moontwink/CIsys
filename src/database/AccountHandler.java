package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.BusinessAccount;
import model.CheckingsAccount;
import model.SavingsAccount;
import model.UserModel;

public class AccountHandler {
	
	
	public static void getAccount(UserModel user){
		ArrayList<UserModel> userModelList = new ArrayList<UserModel>();
		DBConnection.connect();
		
		try { 
			Connection conn = DBConnection.getConnection();
			
			for(int i = 0; i<userModelList.size(); i++){
				String selectAccountsQuery = "SELECT * FROM user_accounts WHERE user_accounts_id = " + user.getId();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(selectAccountsQuery);
				rs.next();
				userModelList.get(i).setSavingsAccount(new SavingsAccount(rs.getDouble(2)));
				userModelList.get(i).setBusinessAccount(new BusinessAccount(rs.getDouble(3)));
				userModelList.get(i).setCheckingsAccount(new CheckingsAccount(rs.getDouble(4)));
			}
	    } catch (SQLException e) { 
	    	e.printStackTrace(); 
	    } 
		
	}
}
