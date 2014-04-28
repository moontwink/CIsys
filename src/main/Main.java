package main;

import java.sql.SQLException;

import view.LogInView;
import controller.LogInController;
import model.UserModel;

public class Main {
	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		UserModel userModel = new UserModel();
		LogInView logInView = new LogInView();
		
		new LogInController(userModel, logInView);		
	}
}
