package exceptionalHandling;

public class InsuffBankBalanceException extends RuntimeException{
	
	String message;
	
	InsuffBankBalanceException(String message){
		this.message = message;
	}
	
	public String toString() {
		return message;		
	}

}
