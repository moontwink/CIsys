package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UserController {
	private UserModel userModel;
	private UserView userView;
	
	public UserController(UserModel userModel, UserView userView){
		this.userModel = userModel;
		this.userView = userView;
		
		userView.getLoginBtn().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkIfValidCredentials()){
					JOptionPane.showMessageDialog(new JFrame(), "Log-in successful!");
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
		userModelList.add(new UserModel("Timothy", "Rodriguez", "timohtey","123456"));
		userModelList.add(new UserModel("Nancy", "Naval", "moontwink", "helloworld"));

		userModel.setUsername(userView.getUserTxtField());
		userModel.setPassword(userView.getPasswordTxtField());
		
		for(int index = 0; index < userModelList.size(); index++){
			System.out.println(userModel.getUsername() +" " +userModelList.get(index).getUsername());
			System.out.println(userModel.getPassword()+" " + userModelList.get(index).getPassword());
			
			if(userModel.getUsername().equals(userModelList.get(index).getUsername()) 
					&& userModel.getPassword().equals(userModelList.get(index).getPassword())){
				valid = true;
				break;
			}
		}
		
		return valid;
	}
}