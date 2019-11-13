package battleship;

public class Destroyer extends Ship{
	
	int length = 2;
	
	@Override
	String getShipType() {
		return "destroyer";
	}
	
	@Override
	int getLength() {
		return length;
	}

}
