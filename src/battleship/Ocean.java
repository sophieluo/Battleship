package battleship;

import java.util.Random;

public class Ocean {
	
	//instance variables
	
	//used to quickly determine which ship is in any given location
	private Ship[][]ships = new Ship[10][10];
	
	//helper method
	//an array of booleans telling whether the user has fired on a certain location
	boolean[][] fired = new boolean[10][10];
	
	//the total number of shots fired by the user
	private int shotsFired;
	
	//the number of times a shot hit a ship
	private int hitCount;
	
	//the number of ships sunk(10 ships in all)
	private int shipsSunk;
	
	//static
	private static final int NUM_BATTLESHIPS = 1;
	private static final int NUM_CRUISERS = 2;
	private static final int NUM_DESTROYERS = 3;
	private static final int NUM_SUBMARINES = 4;
	
	
	//constructors
	/**
	 * creates an "empty" ocean (and fills the ships array with EmptySea objects). 
	 * could create a private helper method t do this
	 * also initialized any game variables, such as how many shots have been fired
	 */
	public Ocean() {
		shotsFired = 0;
		hitCount = 0;
		shipsSunk = 0;
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				ships[i][j] = new EmptySea();
			}
		}
	}
	
	//methods
	/**
	 * place all ten ships randomly on the (initially empty) ocean. Place larger ships before smaller ships.
	 */
	void placeAllShipsRandomly() {
		//code to implement
		Random rand = new Random();
		
		int row;
		int column;
		boolean horizontal;
		
		//place battleships
		for (int i = 0; i < Ocean.NUM_BATTLESHIPS; i++) {
			Ship battleship = new Battleship();
			row = rand.nextInt(10);
			column = rand.nextInt(10);
			horizontal = rand.nextInt(2) == 0 ? false : true;
			while(!battleship.oKToPlaceShipAt(row, column, horizontal, this)) {
				row = rand.nextInt(10);
				column = rand.nextInt(10);
				horizontal = rand.nextInt(2) == 0 ? false : true;
			}
			battleship.placeShipAt(row, column, horizontal, this);
		}
		
		//place cruisers
		for (int i = 0; i < Ocean.NUM_CRUISERS; i++) {
			Ship battleship = new Battleship();
			row = rand.nextInt(10);
			column = rand.nextInt(10);
			horizontal = rand.nextInt(2) == 0 ? false : true;
			while(!battleship.oKToPlaceShipAt(row, column, horizontal, this)) {
				row = rand.nextInt(10);
				column = rand.nextInt(10);
				horizontal = rand.nextInt(2) == 0 ? false : true;
			}
			battleship.placeShipAt(row, column, horizontal, this);
		}
		
		//place destroyers
		for (int i = 0; i < Ocean.NUM_DESTROYERS; i++) {
			Ship battleship = new Battleship();
			row = rand.nextInt(10);
			column = rand.nextInt(10);
			horizontal = rand.nextInt(2) == 0 ? false : true;
			while(!battleship.oKToPlaceShipAt(row, column, horizontal, this)) {
				row = rand.nextInt(10);
				column = rand.nextInt(10);
				horizontal = rand.nextInt(2) == 0 ? false : true;
			}
			battleship.placeShipAt(row, column, horizontal, this);
		}
		
		//place submarines
		for (int i = 0; i < Ocean.NUM_SUBMARINES; i++) {
			Ship battleship = new Battleship();
			row = rand.nextInt(10);
			column = rand.nextInt(10);
			horizontal = rand.nextInt(2) == 0 ? false : true;
			while(!battleship.oKToPlaceShipAt(row, column, horizontal, this)) {
				row = rand.nextInt(10);
				column = rand.nextInt(10);
				horizontal = rand.nextInt(2) == 0 ? false : true;
			}
			battleship.placeShipAt(row, column, horizontal, this);
		}
		
	}
	
	/**
	 * returns true if the given location contains a ship, false if it does not
	 * @param row
	 * @param column
	 * @return
	 */
	boolean isOccupied(int row, int column) {
		//code to implement
		return false;
	}
	
	/**
	 * returns true if the given location contains a "real" ship, still afloat, (not an EmptySea),
	 * false if it does not
	 * updates the number of shots that have been fires
	 * and the number of hits
	 * @param row
	 * @param column
	 * @return
	 */
	boolean shootAt(int row, int column) {
		//code to implement
		return false;
	}
	
	/**
	 * returns the number of shots fired in the game
	 * @return
	 */
	int getShotsFired() {
		return shotsFired;
	}
	
	/**
	 * returns the number of hits recorded in the game. all hits are counted, not just the first time a given square is hit.
	 * @return
	 */
	int getHitCount() {
		return hitCount;
	}
	
	/**
	 * 
	 * @return the number of ships sunk in the game
	 */
	int getShipsSunk() {
		return shipsSunk;
	}
	
	/**
	 * 
	 * @return true if all ships have been sunk, otherwise false
	 */
	boolean isGameOver() {
		int count = 0;
		
		//code to implements. counts the number of ships that's sunk
		return count == 20;
	}
	
	/**
	 * 
	 * @return the 10*10 array of Ships.
	 * see homework prompt for more instructions
	 */
	Ship[][] getShipArray(){
		return ships;
	}
	
	/**
	 * prints the Ocean.
	 * see homework prompt for more instructions
	 */
	
	void print() {
		
		System.out.println("    0 1 2 3 4 5 6 7 8 9");
		for (int i = 0; i < 10; i++) {
		    System.out.print(i + " |");
		    for (int j = 0; j < 10; j++) {
		        if (!fired[i][j]) {
		            System.out.print(" .");
		        } else {
		            System.out.print(" " + ships[i][j].toString());
		        }
		    }
		    System.out.println(" |");
		}
		
	}
	
}
