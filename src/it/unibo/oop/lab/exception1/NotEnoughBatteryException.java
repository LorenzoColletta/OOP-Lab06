package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private final int x;
    private final int y;
    
	public NotEnoughBatteryException(final int initX, final int initY) {
		super();
		this.x = initX;
		this.y = initY;
	}
	
	public String toString() {
        return "Can not move to position(" + this.x + "," + this.y + "). Not enough battery.";
	}
	
	public String getMessage() {
		return "Not Enough Battery left.";
	}
}
