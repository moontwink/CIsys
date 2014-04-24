package main;

import view.LogInView;
import model.UserModel;
import controller.LogInController;

public class Main {
	public static void main(String args[]){
		UserModel userModel = new UserModel();
		LogInView logInView = new LogInView();
		
		LogInController logInController = new LogInController(userModel, logInView);		
	}
}
