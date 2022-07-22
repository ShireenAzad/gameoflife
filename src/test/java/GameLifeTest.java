import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameLifeTest {
	Game game;
	private Cell[][] cells;
	private Cell[][] futureCells ;
	@BeforeEach
	void setUp() {
		game = new Game(5, 5);
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
	void checkingCellDiesDueToUnderPopulation() {
		boolean b = game.underPopulation(cells, futureCells, 4, 3, 1);
		assertTrue(b);
	}
	@Test
	void checkingIsAnyNeighborAlive() {
		int aliveNeighbors = game.aliveNeighbors(cells, 1, 1);
		assertEquals(aliveNeighbors,6);

	}

	@Test
	void checkingCellDiesDueToOverPopulation() {
		boolean b = game.overPopulation(cells, futureCells, 0, 1, 0);
		assertTrue(b );
	}
}
