package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private final Double currentLevel;
    private final Double consumption;
    
	public NotEnoughBatteryException(final Double currentLevel, final Double consumption) {
		super();
		this.currentLevel = currentLevel;
		this.consumption = consumption;
	}
	
	public String toString() {
        return "Current battery level: " + this.currentLevel + ", Battery level required: " + this.consumption + ". Not enough battery.";
	}
	
	public String getMessage() {
		return this.toString();
	}
}
