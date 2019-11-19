package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class OceanTest {
	
	Ship battleship;
	
	Ship cruiser;
	
	Ship destroyer;
	
	Ship submarine;
	
	Ocean O = new Ocean();

	@BeforeEach
	void setUp() throws Exception {
		this.battleship=new Battleship();
		this.cruiser=new Cruiser();
		this.destroyer=new Destroyer();
		this.submarine=new Submarine();
		
	}

	@Test
	void testOcean() {
		assertEquals(0, O.getShotsFired());
		assertEquals(0, O.getHitCount());
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				assertEquals("empty", O.ships[i][j].getShipType());
				assertFalse(O.fired[i][j]);
			}
		}
	}

	@Test
	void testPlaceAllShipsRandomly() {
		//code to implement
	}

	@Test
	void testIsOccupied() {
		cruiser.placeShipAt(0, 0, true, O);
		assertTrue(O.isOccupied(0, 1));
		assertFalse(O.isOccupied(1, 0));
		battleship.placeShipAt(1, 1, false, O);
		assertTrue(O.isOccupied(2, 1));
		assertFalse(O.isOccupied(1, 2));
	}

	@Test
	void testShootAt() {
		battleship.placeShipAt(0, 0, false, O);
		assertTrue(O.shootAt(0, 0));
		assertTrue(O.shootAt(1, 0));
		assertTrue(O.shootAt(2, 0));
		assertTrue(O.shootAt(3, 0));
		assertFalse(O.shootAt(4, 9));
		assertEquals(5, O.shotsFired);
		assertEquals(4, O.hitCount);
	}

	@Test
	void testGetShotsFired() {
		destroyer.placeShipAt(0, 0, false, O);
		O.shootAt(0, 0);
		O.shootAt(1, 1);
		assertEquals(2, O.getShotsFired());
		O.shootAt(2, 2);
		assertEquals(3, O.getShotsFired());
		O.shootAt(2, 3);
		assertEquals(4, O.getShotsFired());
	}

	@Test
	void testGetHitCount() {
		battleship.placeShipAt(0, 0, false, O);
		O.shootAt(0, 0);
		O.shootAt(1, 0);
		O.shootAt(0, 1);
		assertEquals(2, O.getHitCount());
		O.shootAt(0, 2);
		assertEquals(2, O.getHitCount());
		O.shootAt(2, 0);
		assertEquals(3, O.getHitCount());
	}

	@Test
	void testGetShipsSunk() {
		submarine.placeShipAt(0, 0, true, O);
		assertEquals(0, O.getShipsSunk());
		O.shootAt(0, 0);
		O.shootAt(0, 0);
		//this is not passing
		assertEquals(1, O.getShipsSunk());
	}

	@Test
	void testIsGameOver() {
		
		Battleship battleship = new Battleship();
		Cruiser cruiser = new Cruiser();
		Cruiser cruiser1 = new Cruiser();
		Destroyer destroyer = new Destroyer();
		Destroyer destroyer1 = new Destroyer();
		Destroyer destroyer2 = new Destroyer();
		Submarine submarine = new Submarine();
		Submarine submarine1 = new Submarine();
		Submarine submarine2 = new Submarine();
		Submarine submarine3 = new Submarine();
		EmptySea emptysea = new EmptySea();
		
		battleship.placeShipAt(6, 9, false, O);
		cruiser.placeShipAt(3, 2, false, O);
		cruiser1.placeShipAt(3, 2, true, O);
		destroyer.placeShipAt(5, 1, true, O);
		destroyer1.placeShipAt(1, 6, false, O);
		destroyer2.placeShipAt(2, 9, false, O);
		submarine.placeShipAt(0, 0, true, O);
		submarine1.placeShipAt(3, 0, true, O);
		submarine2.placeShipAt(5, 0, true, O);
		submarine3.placeShipAt(5, 7, false, O);
		O.shootAt(1, 1);
		O.shootAt(1, 2);
		O.shootAt(1, 3);
		O.shootAt(1, 4);
		O.shootAt(1, 5);
		O.shootAt(1, 6);
		O.shootAt(1, 7);
		O.shootAt(1, 8);
		O.shootAt(1, 9);
		O.shootAt(2, 1);
		O.shootAt(2, 2);
		O.shootAt(2, 3);
		O.shootAt(2, 4);
		O.shootAt(2, 5);
		O.shootAt(2, 6);
		O.shootAt(2, 7);
		assertFalse(O.isGameOver());
		O.shootAt(2, 8);
		O.shootAt(2, 9);
		O.shootAt(3, 1);
		O.shootAt(3, 2);
		O.shootAt(3, 3);
		O.shootAt(3, 4);
		O.shootAt(3, 5);
		O.shootAt(3, 1);
		O.shootAt(3, 2);
		O.shootAt(3, 3);
		O.shootAt(3, 4);
		O.shootAt(3, 5);
		O.shootAt(3, 3);
		O.shootAt(3, 4);
		O.shootAt(3, 5);
		O.shootAt(3, 1);
		O.shootAt(3, 2);
		O.shootAt(3, 3);
		O.shootAt(3, 4);
		assertTrue(O.isGameOver());
	}

	@Test
	void testGetShipArray() {
	
	}


}
