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
		this.hit = new boolean[length];
		this.length = length;
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
		
		//checks if it's horizontally placed
		if (horizontal) {
			//if horizontally placed and column(location of bow) plus the length of the ship is over 10, sticks out beyond. so return false
			if (column + getLength() > 10) {
				return false;
			} 
			//if overlap or touch, return false
			//start counting from column - 1, b/c can't diagonally touch
			for (int c = column - 1; c <= column + getLength(); c++) {
				if (ocean.isOccupied(row - 1, c) || ocean.isOccupied(row, c) || ocean.isOccupied(row + 1, c)) {
					return false;
				}
			}
			//default is return true
				return true;
			}
		
		 else {
			//similarly, if vertically placed and sticks out, returns false
			if (row + getLength() > 10) {
				return false;
			}
			//if overlap or touch, return false
			for (int r = row - 1; r <= row + getLength(); r++) {
				if (ocean.isOccupied(r, column - 1) || ocean.isOccupied(r, column) || ocean.isOccupied(r, column + 1)) {
					return false;
				}
			}
			return true;
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
		this.setBowRow(row);
		this.setBowColumn(column);
		this.setHorizontal(horizontal);
		
		//create ships array
		//should be the same if do Ship[][] ships = new Ship[10][10];
		Ship[][] ships = ocean.getShipArray();
		
		//if horizontal, place ship at (starting at [row][column], for length)
		if (horizontal) {
			for (int i = column; i < column + this.getLength(); i++) {
				ships[row][i] = this;
			}
		}
		//else if vertical
		else {
			for (int j = row; j < row + this.getLength(); j++) {
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
				//shot at (row, column)
				//hit[i] is hit. i = column - bowColumn
				hit[column - this.bowColumn] = true;
				return true;
			}
			// if it's vertical. same logic
			else {
				hit[row - this.bowRow] = true;
				return true;
			}
		}
		else {
		//if it's already sunk, return false
		return false;
		}
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
	
	/**
	 * returns "s" if ship has been sunk and "x" if it has not
	 * not used to print locations that have not been shot at
	 */
	@Override
	public String toString() {
		// s for sunk
		if (this.isSunk() == true) {
			return "s";
		}
		// x for not sunk
		else {
			return "x";
		}
	}
	
}
