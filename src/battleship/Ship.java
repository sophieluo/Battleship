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
	 * initializes the hit array
	 * @param length
	 */
	public Ship(int length) {
		hit = new boolean[] {false, false, false, false};
	}
	
	//methods
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
	/**
	 * 
	 * @return type of this ship.
	 */
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
		
		//checks if it's horizontally placed
		if (horizontal) {
			//if horizontally placed and column(location of bow) plus the length of the ship is over 10, sticks out beyond. so return false
			if (column + getLength() > 10) {
				return false;
			} else if (some condition to check overlap or touch) {
				return false;
			} else {
				return true;
			}		
		} else {
			//similarly, if vertically placed and sticks out, returns false
			if (row + getLength() > 10) {
				return false;
			} else if (some condition) {
				return false;
			} else {
				return true;
			}
			
		}
	}
	
	/**
	 * puts the ship in the ocean
	 * @param row
	 * @param column
	 * @param horizontal
	 * @param ocean
	 * also involves putting a reference to the ship in each of 1 or more locations (up to 4) in the ships array in the Ocean object.
	 * horizontal: east; vertical: south
	 */
	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		setBowRow(row);
		setBowColumn(column);
		setHorizontal(horizontal);
		
		//create ships array
		//should be the same if do Ship[][] ships = new Ship[10][10];
		Ship[][] ships = ocean.getShipArray();
		
		//if horizontal, place ship at (starting at [row][column], for length)
		if (horizontal) {
			for (int i = column; i < column + getLength(); i++) {
				ships[row][i] = this;
			}
		}
		//else if vertical
		else {
			for (int j = row; j < row + getLength(); j++) {
				ships[j][column] = this;
			}
			
		}
	}
	
	/**
	 * mark the part of the ship being shot at as "hit" and return true, otherwise return false
	 * @param row
	 * @param column
	 * @return
	 */
	boolean shootAt(int row, int column) {
		//first check if ship is sunk
		if(this.isSunk() == false) {
			if(this.horizontal) {
				//where is the part of the ship being shot at
			}
		}
		//if it's already sunk, return false?
		return false;
	}
	
	/**
	 * 
	 * @return true if every part of the ship has been hit, false otherwise
	 */
	boolean isSunk() {
		for (int i = 0; i < getLength(); i++) {
			if(this.hit[i] == false) {
				return false;
			}
		}
		//default is sunk
		return true;
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
