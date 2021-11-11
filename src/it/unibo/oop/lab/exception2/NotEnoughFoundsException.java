package it.unibo.oop.lab.exception2;

public class NotEnoughFoundsException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double currentBalance;
	private double amount;
	
	public NotEnoughFoundsException(final double currentBalance, final double amount) {
		super();
		this.currentBalance = currentBalance;
		this.amount = amount;
	}
	
	public String toString() {
		return "Current balance (" + this.currentBalance + ") is not enough. Amount required: " + amount;
	}
	
	public String getMessage() {
		return this.toString();
	}
}
