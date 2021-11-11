package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user;
	
	public WrongAccountHolderException(final int user) {
		super();
		this.user = user;
	}
	
	public String toString() {
		return "User ID: " + this.user + " - Access Denied.";
	}
	
	public String getMessage() {
		return this.toString();
	}

}
