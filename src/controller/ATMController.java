package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.TransactionType;
import model.UserModel;
import view.ATMView;
import view.CashView;

public class ATMController {
	private ATMView atmView;
	private UserModel userModel;
	
	public ATMController(final ATMView atmView, final UserModel userModel){
		this.atmView = atmView;
		this.userModel = userModel;
		
		atmView.getWelcomeLabel().setText("Welcome, " + userModel.getFirstName() +" "+ userModel.getLastName() +"!");
		
		atmView.getBtnInquireBalance().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atmView.getBalancePanel().setVisible(true);
				atmView.getSavingsField().setText("PHP " + userModel.getSavingsAccount().getBalance());
				atmView.getBusinessField().setText("PHP " + userModel.getBusinessAccount().getBalance());
				atmView.getCheckingsField().setText("PHP " + userModel.getCheckingsAccount().getBalance());
			}
		});
		
		atmView.getBtnWithdraw().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atmView.getButtonsPanel().setEnabled(false);
				@SuppressWarnings("unused")
				CashController cashController = new CashController(new CashView(), userModel, TransactionType.WITHDRAW);
			}
		});
		
		atmView.getBtnDeposit().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atmView.getButtonsPanel().setEnabled(false);
				@SuppressWarnings("unused")
				CashController cashController = new CashController(new CashView(), userModel, TransactionType.DEPOSIT);
			}
		});
	}
}
