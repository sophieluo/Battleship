package battleship;

public class Battleship extends Ship {
	
	//zero-argument public constructor
	public Battleship() {
		super(4);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getShipType() {
		return "battleship";
	}
	
}
