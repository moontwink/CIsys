package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import model.BusinessAccount;
import model.CheckingsAccount;
import model.SavingsAccount;
import model.UserModel;
import view.ATMView;
import view.UserView;

public class UserController {
	private UserModel userModel;
	private UserView userView;
	
	public UserController(UserModel userModel, final UserView userView){
		this.userModel = userModel;
		this.userView = userView;
		
		userView.getLoginBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkIfValidCredentials()){
					JOptionPane.showMessageDialog(new JFrame(), "Log-in successful!");
					userView.getLoginJFrame().dispose();
					
					ATMView atmView = new ATMView();
					UserModel userModel = new UserModel("Nancy", "Naval", "moontwink", "helloworld");
					userModel.setBusinessAccount(new BusinessAccount(10000.0));
					userModel.setCheckingsAccount(new CheckingsAccount(20000.0));
					userModel.setSavingsAccount(new SavingsAccount(10000.0));
					
					ATMController atmController = new ATMController(atmView, userModel);
				} else {
					JOptionPane.showMessageDialog(new JFrame(),
						    "Username and password do not much!",
						    "Log-in error",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		int condition = JComponent.WHEN_FOCUSED;
		InputMap iMap = userView.getPasswordField().getInputMap(condition);
		ActionMap aMap = userView.getPasswordField().getActionMap();
		String enter = "enter";
		iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), enter);
		aMap.put(enter, new AbstractAction() {
			
			public void actionPerformed(ActionEvent e) {
				if(checkIfValidCredentials()){
					JOptionPane.showMessageDialog(new JFrame(), "Log-in successful!");
					userView.getLoginJFrame().dispose();
					
					ATMView atmView = new ATMView();
					UserModel userModel = new UserModel("Nancy", "Naval", "moontwink", "helloworld");
					userModel.setBusinessAccount(new BusinessAccount(10000.0));
					userModel.setCheckingsAccount(new CheckingsAccount(20000.0));
					userModel.setSavingsAccount(new SavingsAccount(10000.0));
					
					@SuppressWarnings("unused")
					ATMController atmController = new ATMController(atmView, userModel);
				} else {
					JOptionPane.showMessageDialog(new JFrame(),
						    "Username and password do not much!",
						    "Log-in error",
						    JOptionPane.ERROR_MESSAGE);
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

		userModel.setUsername(userView.getUserTxtField());
		userModel.setPassword(userView.getPasswordTxtField());
		
		for(int index = 0; index < userModelList.size(); index++){
			if(userModel.getUsername().equals(userModelList.get(index).getUsername()) 
					&& userModel.getPassword().equals(userModelList.get(index).getPassword())){
				valid = true;
				break;
			}
		}
		
		return valid;
	}
}