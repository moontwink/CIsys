package main;

import view.UserView;
import model.UserModel;
import controller.UserController;

public class Main {
	public static void main(String args[]){
		UserModel userModel = new UserModel();
		UserView userView = new UserView();
		
		UserController userController = new UserController(userModel, userView);		
	}
	
	public static String helloWorld(){
		return "Hello World!";
	}
}
