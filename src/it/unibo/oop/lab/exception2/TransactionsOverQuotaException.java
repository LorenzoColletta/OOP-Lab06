package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public TransactionsOverQuotaException() {
		super();
	}
	
	public String getMessage() {
		return "No free transactons left.";
	}

}
