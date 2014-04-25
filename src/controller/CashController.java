package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import model.TransactionType;
import model.UserModel;
import view.CashView;

public class CashController {
	private CashView cashView;
	private UserModel userModel;
	
	public CashController(final CashView cashView, final UserModel userModel, final TransactionType type) {
		this.cashView = cashView;
		this.userModel = userModel;
		
		if(type == TransactionType.WITHDRAW)
			cashView.getBtnEnter().setText("WITHDRAW");
		else
			cashView.getBtnEnter().setText("DEPOSIT");
		
		int condition = JComponent.WHEN_FOCUSED;
		InputMap iMap = cashView.getCashField().getInputMap(condition);
		ActionMap aMap = cashView.getCashField().getActionMap();
		String enter = "enter";
		iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), enter);
		aMap.put(enter, new AbstractAction() {
			
			public void actionPerformed(ActionEvent e) {
				switch(type){
					case DEPOSIT: 
						
						break;
					case WITHDRAW: 
						break;
				
				}
				
				JOptionPane.showMessageDialog(new JFrame(),
					    "Transaction Successful!",
					    "Transaction",
					    JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
	}
	
	
}
