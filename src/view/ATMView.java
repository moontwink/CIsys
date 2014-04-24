package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class ATMView {
	private static JTextField savingsField;
	private static JTextField checkingsField;
	private static JTextField businessField;
	private static JPanel balancePanel;
	
	public ATMView() {
		JFrame jframe = new JFrame();
		jframe.setSize(new Dimension(600, 360));
		jframe.setVisible(true);
		
		JPanel panel = new JPanel();
		jframe.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setSize(new Dimension(360, 360));
		
		JLabel welcomeLabel = new JLabel("Welcome!");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setBounds(0, 35, 340, 25);
		welcomeLabel.setFont(new Font("Cambria", Font.BOLD, 21));
		panel.add(welcomeLabel);
		
		balancePanel = new JPanel();
		balancePanel.setBorder(new TitledBorder(null, "Balance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		balancePanel.setBounds(349, 68, 206, 221);
		panel.add(balancePanel);
		balancePanel.setLayout(null);
		balancePanel.setVisible(false);
		
		JLabel lblSavings = new JLabel("SAVINGS");
		lblSavings.setBounds(22, 36, 60, 14);
		balancePanel.add(lblSavings);
		lblSavings.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		savingsField = new JTextField();
		savingsField.setBounds(46, 52, 132, 20);
		balancePanel.add(savingsField);
		savingsField.setEditable(false);
		savingsField.setBackground(Color.LIGHT_GRAY);
		savingsField.setColumns(10);
		
		JLabel lblCheckingsAccount = new JLabel("CHECKINGS ACCOUNT");
		lblCheckingsAccount.setBounds(22, 83, 156, 14);
		balancePanel.add(lblCheckingsAccount);
		lblCheckingsAccount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		checkingsField = new JTextField();
		checkingsField.setBounds(46, 100, 132, 20);
		balancePanel.add(checkingsField);
		checkingsField.setEditable(false);
		checkingsField.setColumns(10);
		checkingsField.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblBusinessAccount = new JLabel("BUSINESS ACCOUNT");
		lblBusinessAccount.setBounds(22, 131, 156, 14);
		balancePanel.add(lblBusinessAccount);
		lblBusinessAccount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		businessField = new JTextField();
		businessField.setBounds(46, 156, 132, 20);
		balancePanel.add(businessField);
		businessField.setEditable(false);
		businessField.setColumns(10);
		businessField.setBackground(Color.LIGHT_GRAY);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		buttonsPanel.setBounds(24, 95, 316, 165);
		panel.add(buttonsPanel);
		buttonsPanel.setLayout(null);
		
		JButton btnInquireBalance = new JButton("Inquire Balance");
		btnInquireBalance.setBounds(21, 24, 132, 50);
		buttonsPanel.add(btnInquireBalance);
		btnInquireBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				balancePanel.setVisible(true);
				
			}
		});
		btnInquireBalance.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setBounds(163, 24, 132, 50);
		buttonsPanel.add(btnWithdraw);
		btnWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setBounds(163, 92, 132, 50);
		buttonsPanel.add(btnDeposit);
		btnDeposit.setFont(new Font("Tahoma", Font.PLAIN, 12));
	}
}
