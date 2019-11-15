package battleship;

public class EmptySea extends Ship {
	
	//constructor
	public EmptySea() {
		super(1);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * return is always false because it's always the case that nothing was hit
	 */
	@Override
	boolean shootAt(int row, int column) {
		return false;
	}
	
	/**
	 * return is always false because it's always the case that nothing was sunk
	 */
	@Override
	boolean isSunk() {
		return false;
	}
	
	/**
	 * returns the single-character "-" String to use in the Ocean's print method
	 * indicates that a shot has been fired, but nothing has been hit.
	 */
	@Override
	public String toString() {
		return "-";	}
	
	/**
	 * returns the string "empty"
	 */
	@Override
	public String getShipType() {
		return "empty";
	}

}
