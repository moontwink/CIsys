package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
		
		cashView.getCashField().addKeyListener(new KeyListener() {
			
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void keyPressed(KeyEvent arg0) {
				int key = arg0.getKeyCode();
				if(key == KeyEvent.VK_ENTER)
					JOptionPane.showMessageDialog(new JFrame(),
						    "Transaction Successful!",
						    "Transaction",
						    JOptionPane.INFORMATION_MESSAGE);;
				
			}
		});
	}
	
	
}
