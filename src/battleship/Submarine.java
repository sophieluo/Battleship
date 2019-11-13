package battleship;

public class Submarine extends Ship {
	
	int length = 1;
	
	@Override
	String getShipType() {
		return "destroyer";
	}
	
	@Override
	int getLength() {
		return length;
	}

}
