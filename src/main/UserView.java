package main;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class UserView {
	private JTextField userNameTxtField;
	private JPasswordField passwordTxtField;
	private JButton btnLogin;
	
	public UserView(){
		initComponents();
	}

	private void initComponents() {
		JFrame logInFrame = new JFrame("Log-in");
		logInFrame.setSize(new Dimension(345, 298));
		logInFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(32, 89, 79, 14);
		logInFrame.getContentPane().add(lblNewLabel);
		
		userNameTxtField = new JTextField();
		userNameTxtField.setBounds(101, 87, 165, 20);
		logInFrame.getContentPane().add(userNameTxtField);
		userNameTxtField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(32, 121, 65, 14);
		logInFrame.getContentPane().add(lblPassword);
		
		passwordTxtField = new JPasswordField();
		passwordTxtField.setBounds(101, 118, 165, 20);
		logInFrame.getContentPane().add(passwordTxtField);
		
		JLabel lblLogin = new JLabel("Log-in");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLogin.setBounds(32, 33, 95, 33);
		logInFrame.getContentPane().add(lblLogin);
		
		btnLogin = new JButton("Log-in");
		btnLogin.setBounds(121, 167, 97, 30);
		logInFrame.getContentPane().add(btnLogin);
		logInFrame.setVisible(true);
	}
	
	public String getUserTxtField(){
		System.out.println("Username: " +userNameTxtField.getText());
		return userNameTxtField.getText();
	}
	
	public String getPasswordTxtField(){
		return new String(passwordTxtField.getPassword());
	}
	
	public JButton getLoginBtn(){
		return btnLogin;
	}
}
