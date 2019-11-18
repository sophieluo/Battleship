package battleship;

import java.util.Scanner;


public class BattleshipGame {
	
	/**
	 * The 
	 * @param args
	 */
	public static void main(String[] args) {
		BattleshipGame game  = new BattleshipGame();
		while(game.playGame()) {
			continue;
		}
	}
	
	public boolean playGame() {
		Ocean ocean = new Ocean();
		ocean.placeAllShipsRandomly();
		Scanner sc = new Scanner(System.in);
		ocean.print();
		
		while(ocean.isGameOver() == false) {
			System.out.println("Enter row, column:");
			int row = sc.nextInt();
			int column = sc.nextInt();
			
			if(ocean.shootAt(row, column)) {
				System.out.println("hit! checking if it's sunk...");
				Ship[][] ships = ocean.getShipArray();
				if (ships[row][column].isSunk()) {
					System.out.println(ships[row][column].getShipType() + " is sunk.");
				}
			} else {
				System.out.println("Missed this shot");
			}
			ocean.print();
		}
		System.out.println("Final score is " + ocean.getShotsFired());
		System.out.println("Play again?");
		String playAgain = sc.nextLine();
		return playAgain.toLowerCase().startsWith("y");
	}
	

}
