package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
	
	public boolean checkIfValidCredentials(){
		boolean valid = false;
		List<UserModel> userModelList = new ArrayList<UserModel>();
		
		UserModel timothyRodriguez = new UserModel("Timothy", "Rodriguez", "timohtey","123456");
		timothyRodriguez.setBusinessAccount(new BusinessAccount(5000.0));
		timothyRodriguez.setCheckingsAccount(new CheckingsAccount(10000.0));
		timothyRodriguez.setSavingsAccount(new SavingsAccount(10000.0));
		userModelList.add(timothyRodriguez);
		
		UserModel nancyNaval = new UserModel("Nancy", "Naval", "moontwink", "helloworld");
		nancyNaval.setBusinessAccount(new BusinessAccount(10000.0));
		nancyNaval.setCheckingsAccount(new CheckingsAccount(20000.0));
		nancyNaval.setSavingsAccount(new SavingsAccount(10000.0));
		userModelList.add(nancyNaval);

		userModel.setUsername(logInView.getUserTxtField());
		userModel.setPassword(logInView.getPasswordTxtField());
		
		for(int index = 0; index < userModelList.size(); index++){
			if(userModel.getUsername().equals(userModelList.get(index).getUsername()) 
					&& userModel.getPassword().equals(userModelList.get(index).getPassword())){
				valid = true;
				break;
			}
		}
		
		return valid;
	}
	
	private void createATMController(){
		
		ATMView atmView = new ATMView();
		UserModel userModel = new UserModel("Nancy", "Naval", "moontwink", "helloworld");
		userModel.setBusinessAccount(new BusinessAccount(10000.0));
		userModel.setCheckingsAccount(new CheckingsAccount(20000.0));
		userModel.setSavingsAccount(new SavingsAccount(10000.0));
		
		ATMController atmController = new ATMController(atmView, userModel);
	}
}