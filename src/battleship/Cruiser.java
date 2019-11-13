package battleship;

public class Cruiser extends Ship {
	
	int length = 3;
	
	@Override
	String getShipType() {
		return "cruiser";
	}
	
	@Override
	int getLength() {
		return length;
	}

}
