package exception;

public class WithdrawalException extends Exception {
	private String errorCode="Withdrawal Exception";
	
	public String getErrorCode(){
		return errorCode;
	}
}
