package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotEnoughBatteryException() {
		super();
	}
	
	
	public String getMessage() {
		return "Not Enough Battery left.";
	}
}
