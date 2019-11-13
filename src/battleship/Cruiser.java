package battleship;

public class Cruiser extends Ship {
	
	//constructor
	public Cruiser() {
		super(3);		
	}

	/**
	 * returns string "cruiser"
	 */
	@Override
	public String getShipType() {
		return "cruiser";
	}
	

}
