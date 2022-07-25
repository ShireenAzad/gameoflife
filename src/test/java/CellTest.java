import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {
	private Cell[][] cells;
	private Cell[][] futureCells ;
	@BeforeEach
	void setUp() {
		cells= new Cell[][]{
				{new Cell(0, 0, 0), new Cell(0, 1, 1), new Cell(0, 2, 1), new Cell(0, 3, 0), new Cell(0, 4, 0)},
				{new Cell(1, 0, 1), new Cell(1, 1, 1), new Cell(1, 2, 1), new Cell(1, 3, 0), new Cell(1, 4, 0)},
				{new Cell(2, 0, 0), new Cell(2, 1, 1), new Cell(2, 2, 1), new Cell(2, 3, 0), new Cell(2, 4, 0)},
				{new Cell(3, 0, 0), new Cell(3, 1, 1), new Cell(3, 2, 1), new Cell(3, 3, 0), new Cell(3, 4, 0)},
				{new Cell(4, 0, 0), new Cell(4, 1, 1), new Cell(4, 2, 1), new Cell(4, 3, 1), new Cell(4, 4, 0)},
		};
		futureCells= new Cell[][]{
				{new Cell(0, 0, 0), new Cell(0, 1, 0), new Cell(0, 2, 0), new Cell(0, 3, 0), new Cell(0, 4, 0)},
				{new Cell(1, 0, 0), new Cell(1, 1, 0), new Cell(1, 2, 0), new Cell(1, 3, 0), new Cell(1, 4, 0)},
				{new Cell(2, 0, 0), new Cell(2, 1, 0), new Cell(2, 2, 0), new Cell(2, 3, 0), new Cell(2, 4, 0)},
				{new Cell(3, 0, 0), new Cell(3, 1, 0), new Cell(3, 2, 0), new Cell(3, 3, 0), new Cell(3, 4, 0)},
				{new Cell(4, 0, 0), new Cell(4, 1, 0), new Cell(4, 2, 0), new Cell(4, 3, 0), new Cell(4, 4, 0)}};
	}

	@Test
	void isCellAlive() {
		Cell cell = new Cell(0,1,1);
		assertTrue(cell.isAlive());
	}

	@Test
	void isCellDead() {
		Cell cell = new Cell(0,1,0);
		assertFalse( cell.isAlive());
	}
	@Test
	void checkingCellDiesDueToUnderPopulation() {
		cells[4][3].aliveNeighborsCount(cells);
		boolean cellDiedDueToUnderPopulation = cells[4][3].isCellDiedDueToUnderPopulation();
		assertFalse(cellDiedDueToUnderPopulation);
	}
	@Test
	void IsCellGeneratesForNextGeneration() {
		 cells[1][1].aliveNeighborsCount(cells);
		boolean cellAliveForNextGeneration = cells[1][1].isCellAliveForNextGeneration();
		assertFalse(cellAliveForNextGeneration);

	}

	@Test
	void checkingCellDiesDueToOverPopulation() {
		cells[0][1].aliveNeighborsCount(cells);
		boolean cellDiedToOverPopulation = cells[0][1].isCellDiedToOverPopulation();
		assertTrue(cellDiedToOverPopulation);
	}

}
