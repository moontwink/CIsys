package model;

public class CheckingsAccount implements Account{
	private double balance;
	
	public CheckingsAccount(){
		
	}
	
	public CheckingsAccount(double balance){
		this.balance = balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}
	
}
