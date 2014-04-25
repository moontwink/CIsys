package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.AccountType;
import model.BusinessAccount;
import model.CheckingsAccount;
import model.SavingsAccount;
import model.UserModel;


public class AccountHandler {
	
	public UserModel initAccount(UserModel user){
		UserModel useraccount = user;
		
		try { 
			Connection c = DBConnection.getConnection();
			PreparedStatement ps = c.prepareStatement("SELECT * FROM user_accounts WHERE user_accounts_id = " + user.getId());
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			useraccount.setSavingsAccount(new SavingsAccount(rs.getDouble(2)));
			useraccount.setBusinessAccount(new BusinessAccount(rs.getDouble(3)));
			useraccount.setCheckingsAccount(new CheckingsAccount(rs.getDouble(4)));
			
			rs.close();
			ps.close();
			c.close();
			
	    } catch (SQLException e) { 
	    	Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, e);
	    } catch (ClassNotFoundException e) {
	    	Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, e);
		}
		return useraccount; 
	}
	
	public UserModel getAccount(UserModel user){
		UserModel useraccount = user;
		
		try { 
			Connection c = DBConnection.getConnection();
			PreparedStatement ps = c.prepareStatement("SELECT * FROM user_accounts WHERE user_accounts_id = " + user.getId());
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			useraccount = new UserModel();
			
			useraccount.setSavingsAccount(new SavingsAccount(rs.getDouble(2)));
			useraccount.setBusinessAccount(new BusinessAccount(rs.getDouble(3)));
			useraccount.setCheckingsAccount(new CheckingsAccount(rs.getDouble(4)));
			
			rs.close();
			ps.close();
			c.close();
			
	    } catch (SQLException e) { 
	    	Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, e);
	    } catch (ClassNotFoundException e) {
	    	Logger.getLogger(AccountHandler.class.getName()).log(Level.SEVERE, null, e);
		}
		
		return useraccount; 
	}
	
	
	public void withdrawCash(Double withdrawAmt, UserModel user, AccountType accountType){
		switch(accountType){
			case BUSINESS:
				Double businessAccBalance = user.getBusinessAccount().getBalance();
				user.setBusinessAccount(new BusinessAccount(addCash(businessAccBalance, withdrawAmt)));
				break;
			case CHECKINGS:
				break;
			case SAVINGS:
				break;
		}
		
	}
	
	private Double addCash(Double amount1, Double amount2){
		return amount1 + amount2;
	}
}
