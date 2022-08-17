import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CellTest {
	@Test
	void isCellAlive() {
		Cell cell = new Cell(0, 1, true);
		assertTrue(cell.isAlive());
	}

	@Test
	void isCellDead() {
		Cell cell = new Cell(0, 1, false);
		assertFalse(cell.isAlive());
	}

	@Test
	void isCellAliveForNextGeneration() {
		Cell cell = new Cell(0, 1, true);
		cell.neighbors(List.of(
				new Cell(0, 0, false), new Cell(0, 2, true),
				new Cell(1, 0, true), new Cell(1, 1, true), new Cell(1, 2, true)

		));
		boolean cellAliveForNextGeneration = cell.isSurvives();
		assertFalse(cellAliveForNextGeneration);

	}


	@Test
	void isCellAliveFor() {
		Cell cell=new Cell(0,0,true);
		cell.neighbors(List.of(
				 new Cell(0, 1, true),
				new Cell(1, 0, true), new Cell(1, 1, true)

		));
		assertTrue(cell.isSurvives());
	}

	@Test
	void isSurvive() {
		Cell cell=new Cell(0,0,true);
		cell.neighbors(List.of(
				 new Cell(0, 1, false),
				new Cell(1, 0, true), new Cell(1, 1, true)

		));
		assertTrue(cell.isSurvives());
	}

	@Test
	void diesWithStarvation() {
		Cell cell=new Cell(0,0,true);
		cell.neighbors(List.of(
				 new Cell(0, 1, false),
				new Cell(1, 0, false), new Cell(1, 1, true)

		));
		assertTrue(cell.diesWithStarvation());
	}
	@Test
	void surviveBecauseOfNotStarvation() {
		Cell cell=new Cell(0,0,true);
		cell.neighbors(List.of(
				 new Cell(0, 1, false),
				new Cell(1, 0, true), new Cell(1, 1, true)

		));
		assertFalse(cell.diesWithStarvation());
	}
	@Test
	void diesWithOverPopulation() {
		Cell cell=new Cell(0,1,true);
		cell.neighbors(List.of(
				new Cell(0, 0, false), new Cell(0, 2, true),
				new Cell(1, 0, true), new Cell(1, 1, true),new Cell(1, 2, true)

		));
		assertTrue(cell.diesWithOverPopulation());
	}
	@Test
	void surviveBecauseOfNotOverPopulation() {
		Cell cell=new Cell(0,1,true);
		cell.neighbors(List.of(
				new Cell(0, 0, false), new Cell(0, 2, true),
				new Cell(1, 0, false), new Cell(1, 1, true),new Cell(1, 2, true)

		));
		assertFalse(cell.diesWithOverPopulation());
	}

	@Test
	void isBorn() {
		Cell cell=new Cell(0,0,false);
		cell.neighbors(List.of(
				 new Cell(0, 1, true),
				new Cell(1, 0, true), new Cell(1, 1, true)

		));
		assertTrue(cell.isBorn());

	}
	@Test
	void isNotBorn() {
		Cell cell=new Cell(0,0,false);
		cell.neighbors(List.of(
				new Cell(0, 1, true),
				new Cell(1, 0, false), new Cell(1, 1, true)

		));
		assertFalse(cell.isBorn());

	}
}
