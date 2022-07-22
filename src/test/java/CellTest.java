import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {
	@Test
	void isCellAlive() {
		Cell cell = new Cell(0,1,1);
		boolean life = cell.life();
		assertTrue(life);
	}

	@Test
	void isCellDead() {
		Cell cell = new Cell(0,1,0);
		boolean life = cell.life();
		assertFalse(life);
	}
}
