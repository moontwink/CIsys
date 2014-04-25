package main;

import java.sql.SQLException;

import view.LogInView;
import model.UserModel;
import controller.LogInController;

public class Main {
	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		UserModel userModel = new UserModel();
		LogInView logInView = new LogInView();
		
		LogInController logInController = new LogInController(userModel, logInView);		
	}
}
