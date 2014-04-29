package database;

import static org.junit.Assert.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.AccountType;
import model.BusinessAccount;
import model.CheckingsAccount;
import model.SavingsAccount;
import model.UserModel;

import org.junit.Test;

import exception.WithdrawalException;

public class AccountHandlerTest {

	@Test
	public void testDepositCash() {
		AccountHandler accountHandler = new AccountHandler();
		UserModel useraccount = new UserModel("Nancy", "Naval", "moontwink", "helloworld");
		useraccount.setSavingsAccount(new SavingsAccount(10000));
		useraccount.setBusinessAccount(new BusinessAccount(20000));
		useraccount.setCheckingsAccount(new CheckingsAccount(30000));
		useraccount.setId(1);
		int actual = accountHandler.depositCash(1000.0, useraccount, AccountType.SAVINGS);
		int expected = 1;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testWithdrawCash() {
		AccountHandler accountHandler = new AccountHandler();
		UserModel useraccount = new UserModel("Nancy", "Naval", "moontwink", "helloworld");
		useraccount.setSavingsAccount(new SavingsAccount(10000));
		useraccount.setBusinessAccount(new BusinessAccount(20000));
		useraccount.setCheckingsAccount(new CheckingsAccount(30000));
		useraccount.setId(1);
		int actual = 0;
		try {
			actual = accountHandler.withdrawCash(20000.0, useraccount, AccountType.SAVINGS);
		} catch (WithdrawalException e) {
			Logger.getLogger(AccountHandlerTest.class.getName()).log(Level.SEVERE, null, e);
		}
		int expected = 0;
		assertEquals("expected: "+expected+" actual: "+ actual,expected, actual);
	}

	@Test(expected = WithdrawalException.class)
	public void testWithdrawCashWithBiggerAmount() throws WithdrawalException {
		AccountHandler accountHandler = new AccountHandler();
		UserModel useraccount = new UserModel("Nancy", "Naval", "moontwink", "helloworld");
		useraccount.setSavingsAccount(new SavingsAccount(10000));
		useraccount.setBusinessAccount(new BusinessAccount(20000));
		useraccount.setCheckingsAccount(new CheckingsAccount(30000));
		useraccount.setId(1);
		int actual = accountHandler.withdrawCash(20000.0, useraccount, AccountType.SAVINGS);
		int expected = 0;
		assertEquals(expected, actual);
	}

}
