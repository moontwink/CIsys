package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import database.DBConnection;
import model.BusinessAccount;
import model.CheckingsAccount;
import model.SavingsAccount;
import model.UserModel;
import view.ATMView;
import view.LogInView;

public class LogInController {
	private UserModel userModel;
	private LogInView logInView;
	private DBConnection dbConnection;
	List<UserModel> userModelList;
	
	public LogInController(UserModel userModel, final LogInView logInView){
		this.userModel = userModel;
		this.logInView = logInView;
		dbConnection = new DBConnection();
		userModelList = new ArrayList<UserModel>();
		getAllUsers();
		createListeners();
	}

	private void getAllUsers() {
		String selectQuery = "SELECT * FROM user";
		
		dbConnection.connect();
		
		try { 
			Connection conn = dbConnection.getConnection();
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(selectQuery);
			
			while(rs.next()){
				UserModel userModel = new UserModel();
				userModel.setId(rs.getInt(1));
				userModel.setFirstName(rs.getString(2));
				userModel.setLastName(rs.getString(3));
				userModel.setUsername(rs.getString(4));
				userModel.setPassword(rs.getString(5));
				
				userModelList.add(userModel);
			}
	    } catch (SQLException e) { 
	    	e.printStackTrace(); 
	    } 
		
		try { 
			Connection conn = dbConnection.getConnection();
			
			for(int i = 0; i<userModelList.size(); i++){
				String selectAccountsQuery = "SELECT * FROM user_accounts WHERE user_accounts_id = " + userModelList.get(i).getId();
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
	
		dbConnection.disconnect();
	}

	private void createListeners() {
		logInView.getLoginBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkIfValidCredentials()){
					JOptionPane.showMessageDialog(new JFrame(), "Log-in successful!");
					logInView.getLoginJFrame().dispose();
					
					createATMController();
				} else {
					JOptionPane.showMessageDialog(new JFrame(),
						    "Username and password do not much!",
						    "Log-in error",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		logInView.getPasswordField().addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if(key == KeyEvent.VK_ENTER){
				
					if(checkIfValidCredentials()){
						JOptionPane.showMessageDialog(new JFrame(), "Log-in successful!");
						logInView.getLoginJFrame().dispose();
						
						createATMController();
					} else {
						JOptionPane.showMessageDialog(new JFrame(),
							    "Username and password do not much!",
							    "Log-in error",
							    JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
		});
		
	}
	
	private boolean checkIfValidCredentials(){
		boolean valid = false;
		
		String username = logInView.getUserTxtField();
		String password = logInView.getPasswordTxtField();
		
		for(int index = 0; index < userModelList.size(); index++){
			System.out.println(userModelList.get(index).getUsername());
			System.out.println(userModelList.get(index).getPassword());
			if(username.equals(userModelList.get(index).getUsername()) 
					&& password.equals(userModelList.get(index).getPassword())){
				valid = true;
				userModel = userModelList.get(index);
				break;
			}
		}
		
		return valid;
	}
	
	private void createATMController(){
		ATMView atmView = new ATMView();
		ATMController atmController = new ATMController(atmView, userModel);
	}
}