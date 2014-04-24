package model;

public class BusinessAccount implements Account{
	private double balance;
	
	public BusinessAccount(){
		
	}
	
	public BusinessAccount(double balance){
		this.balance = balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;	
	}

	public double getBalance() {
		return balance;
	}

}
