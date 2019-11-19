package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShipTest {
	
	Ship battleship;
	
	Ship cruiser;
	
	Ship destroyer;
	
	Ship submarine;
	 
	
	@BeforeEach
	void setUp() throws Exception {
		this.battleship=new Battleship();
		this.cruiser=new Cruiser();
		this.destroyer=new Destroyer();
		this.submarine=new Submarine();
	}

	//??
	@Test
	void testShip() {
		//Ship s1=new Battleship();
		//Ship s2=new Cruiser();
		//Ship s3=new Destroyer();
		//Ship s4=new Submarine();
		boolean[] int1=  new boolean[4] ;
		boolean[] int2=  new boolean[3] ;
		//boolean[] int3=  new boolean[2] ;
		boolean[] int4=  new boolean[1] ;
		
		assertArrayEquals(this.battleship.getHit(), int1);
		assertNotEquals(this.destroyer.getHit(), int4);
		assertArrayEquals(this.cruiser.getHit(), int2);
		
		
	}
	//??
	@Test
	void testGetLength() {
		//Ship s1=new Battleship();
		//Ship s2=new Cruiser();
		//Ship s3=new Destroyer();
		//Ship s4=new Submarine();
		assertEquals(this.battleship.getLength(), 4);
		assertEquals(this.cruiser.getLength(), 3);
		assertEquals(this.destroyer.getLength(), 2);
		assertEquals(this.submarine.getLength(), 1);
	}

	@Test
	void testGetBowRow() {
		this.battleship.setBowRow(1);
		this.cruiser.setBowRow(3);
		this.destroyer.setBowRow(5);
		assertEquals(this.battleship.getBowRow(), 1);
		assertEquals(this.cruiser.getBowRow(), 3);
		assertEquals(this.destroyer.getBowRow(), 5);
		
	}

	@Test
	void testGetBowColumn() {
		this.battleship.setBowColumn(1);
		this.cruiser.setBowColumn(5);
		this.destroyer.setBowColumn(8);
		assertEquals(this.battleship.getBowColumn(), 1);
		assertEquals(this.cruiser.getBowColumn(), 5);
		assertEquals(this.destroyer.getBowColumn(), 8);
	}

	//hit one and see
	//tostring
	
	@Test
	void testGetHit() {
		
		Ocean O= new Ocean();
		//Place battleship at (1,1) horizontally
		this.battleship.placeShipAt(1, 1, true, O);
		//shoot the battleship 
		this.battleship.shootAt(1,3);
		boolean[] testhit1= {false,false,true,false};
		boolean[] testhit2=  new boolean[3] ;
		boolean[] testhit4=  new boolean[1] ;
		assertArrayEquals(this.battleship.getHit(), testhit1);
		assertArrayEquals(this.cruiser.getHit(),  testhit2);
		assertArrayEquals(this.submarine.getHit(),  testhit4);		
	}

	@Test
	void testIsHorizontal() {
		this.battleship.setHorizontal(true);
		this.cruiser.setHorizontal(true);
		this.submarine.setHorizontal(false);
		assertEquals(this.battleship.isHorizontal(), true);
		assertEquals(this.cruiser.isHorizontal(), true);
		assertEquals(this.submarine.isHorizontal(), false);	
	}

	@Test
	void testSetBowRow() {
		assertNotEquals(this.battleship.getBowRow(), 4);
		assertNotEquals(this.cruiser.getBowRow(), 1);
		assertNotEquals(this.destroyer.getBowRow(), 2);
	}

	@Test
	void testSetBowColumn() {
		assertNotEquals(this.battleship.getBowColumn(), 2);
		assertNotEquals(this.cruiser.getBowColumn(), 3);
		assertNotEquals(this.destroyer.getBowColumn(), 4);
	}

	@Test
	void testSetHorizontal() {
		assertNotEquals(this.battleship.isHorizontal(), true);
		assertNotEquals(this.cruiser.isHorizontal(), true);
		assertNotEquals(this.submarine.isHorizontal(), true);	
	}

	@Test
	void testGetShipType() {
		
		assertEquals(this.battleship.getShipType(), "battleship");
		assertEquals(this.cruiser.getShipType(), "cruiser");
		assertNotEquals(this.submarine.getShipType(), "cruiser");
	}

	@Test
	void testOKToPlaceShipAt() {
		Ocean O= new Ocean();
		this.battleship.placeShipAt(1, 1, true, O);
		assertEquals(this.battleship.oKToPlaceShipAt(6,1,true,O), true);
		assertEquals(this.battleship.oKToPlaceShipAt(1,1,true,O), false);
		assertEquals(this.cruiser.oKToPlaceShipAt(1,6,true,O), true);
		
	}

	@Test
	void testPlaceShipAt() {
		Ocean O= new Ocean();
		
		this.battleship.placeShipAt(1, 1, true, O);
		this.cruiser.placeShipAt(3, 1, true, O);
		this.destroyer.placeShipAt(5, 1, true, O);
		this.submarine.placeShipAt(7, 1, true, O);
		assertNotEquals(this.battleship.oKToPlaceShipAt(5,2,true,O), true);
		assertEquals(this.battleship.oKToPlaceShipAt(2,1,true,O), false);
		assertEquals(this.battleship.oKToPlaceShipAt(7,3,true,O), true);
	
	}

	@Test
	void testShootAt() {
		
		Ocean O= new Ocean();
		
		this.battleship.placeShipAt(1, 1, true, O);
		this.cruiser.placeShipAt(3, 5, true, O);
		this.destroyer.placeShipAt(5, 8, true, O);
		this.submarine.placeShipAt(7, 1, true, O);
		
		O.shootAt(5, 8);
		O.shootAt(5, 9);
		O.shootAt(3, 7);
		boolean[] int5=  {true,true} ;
		boolean[] int6=  {false,false,true} ;
		boolean[] int7=  {false,false,true,false} ;
		assertArrayEquals(this.destroyer.getHit(), int5);
		assertArrayEquals(this.cruiser.getHit(), int6);
		assertNotEquals(this.battleship.getHit(), int7);
	}

	@Test
	void testIsSunk() {
		assertEquals(this.destroyer.isSunk(), true);
		assertEquals(this.cruiser.isSunk(), false);
		assertNotEquals(this.battleship.isSunk(), true);
		
	}

	@Test
	void testToString() {
		assertEquals(this.destroyer.toString(), "s");
		assertEquals(this.cruiser.toString(), "x");
		assertNotEquals(this.battleship.isSunk(), "s");
		
	}

}
