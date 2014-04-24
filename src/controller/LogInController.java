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

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import database.DBConnection;
import database.UserHandler;
import model.BusinessAccount;
import model.CheckingsAccount;
import model.SavingsAccount;
import model.UserModel;
import view.ATMView;
import view.LogInView;

public class LogInController {
	private UserModel userModel;
	private LogInView logInView;
	
	public LogInController(UserModel userModel, final LogInView logInView){
		this.userModel = userModel;
		this.logInView = logInView;
		createListeners();
	}

	private void createListeners() {
		int condition = JComponent.WHEN_FOCUSED;
		InputMap iMap = logInView.getPasswordField().getInputMap(condition);
		ActionMap aMap = logInView.getPasswordField().getActionMap();
		String enter = "enter";
		iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), enter);
		aMap.put(enter, new AbstractAction() {
			
			public void actionPerformed(ActionEvent e) {
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
		
	}
	
	private boolean checkIfValidCredentials(){
		boolean valid = false;
		
		String username = logInView.getUserTxtField();
		String password = logInView.getPasswordTxtField();
		
		UserHandler userHandler = new UserHandler();
		for(UserModel u : userHandler.getAllUsers()){
			
			if(username.equals(u.getUsername())
					&& password.equals(u.getPassword())){
				valid = true;
				userModel = u;
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