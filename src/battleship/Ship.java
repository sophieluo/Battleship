package battleship;

public abstract class Ship {
	
	//the row that contains the bow
	private int bowRow;
	
	//the column that contains the bow
	private int bowColumn;
	
	//length of the ship
	private int length;
	
	//a boolean that represents whether the ship is going to be placed horizontally or vertically;
	//true: hori; false: verti
	private boolean horizontal;
	
	//an array of 4 booleans that indicate whether that part of the ship has been hit or not
	private boolean[] hit;
	
	//constructors
	/**
	 * default constructor for the Ship class
	 * @param length
	 */
	public Ship(int length) {
		
	}
	
	//getters
	/**
	 * 
	 * @return ship length
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * 
	 * @return the row corresponding to the position of the bow
	 */
	public int getBowRow() {
		return bowRow; 
	}
	
	/**
	 * 
	 * @return the column corresponding to the position of the bow
	 */
	
	public int getBowColumn() {
		return bowColumn;
	}
	
	/**
	 * 
	 * @return hit array
	 */
	public boolean[] getHit() {
		return hit;
	}
	
	/**
	 * 
	 * @return whether the ship is horizontal or not
	 */
	public boolean isHorizontal() {
		return horizontal;
	}
	
	
	//setters
	/**
	 * set the value of bowRow
	 * @param row
	 */
	public void setBowRow(int row) {
		this.bowRow = row;
	}
	
	/**
	 * set the value of bowColumn
	 * @param column
	 */
	public void setBowColumn(int column) {
		this.bowColumn = column;
	}
	
	
	/**
	 * set the value of the instance variance horizontal
	 * @param horizontal
	 */
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	
	
	//abstract methods
	public abstract String getShipType();
	
	//other methods
	/**
	 * 
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 * @return true if it is okay to put a ship of this length with its bow in this position, false otherwise
	 */
	boolean oKToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		//code to implement
		
		return false;
	}
	
	/**
	 * 
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 */
	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		//code to implement
	}
	
	/**
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	boolean shootAt(int row, int column) {
		return false;
		//code to implement
	}
	
	/**
	 * 
	 * @return
	 */
	boolean isSunk() {
		return false;
		//code to implement
	}
	
	@Override
	public String toString() {
		if (this.isSunk()) {
			return "x";
		} else {
			return "s";
		}
	}
	
}
