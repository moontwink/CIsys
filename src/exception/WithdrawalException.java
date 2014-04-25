package exception;

public class WithdrawalException extends Exception {
	private final String errorCode="Withdrawal Exception";
	
	public String getErrorCode(){
		return errorCode;
	}
}
