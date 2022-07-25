import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class UniverseTest {
	@Test
	void checkingGames() {
		Game game = Mockito.mock(Game.class);
		when(game.generateCells()).thenReturn(
				new Cell[][][]{
				new Cell[][]{
						{new Cell(0, 0, 0), new Cell(0, 1, 1), new Cell(0, 2, 1), new Cell(0, 3, 0), new Cell(0, 4, 1)},
						{new Cell(1, 0, 1), new Cell(1, 1, 1), new Cell(1, 2, 1), new Cell(1, 3, 0), new Cell(1, 4, 1)},
						{new Cell(2, 0, 0), new Cell(2, 1, 1), new Cell(2, 2, 1), new Cell(2, 3, 0), new Cell(2, 4, 1)},
						{new Cell(3, 0, 0), new Cell(3, 1, 1), new Cell(3, 2, 1), new Cell(3, 3, 0), new Cell(3, 4, 1)},
						{new Cell(4, 0, 0), new Cell(4, 1, 1), new Cell(4, 2, 1), new Cell(4, 3, 1), new Cell(4, 4, 1)},
				},
				new Cell[][]{
						{new Cell(0, 0, 0), new Cell(0, 1, 0), new Cell(0, 2, 0), new Cell(0, 3, 0), new Cell(0, 4, 0)},
						{new Cell(1, 0, 0), new Cell(1, 1, 0), new Cell(1, 2, 0), new Cell(1, 3, 0), new Cell(1, 4, 0)},
						{new Cell(2, 0, 0), new Cell(2, 1, 0), new Cell(2, 2, 0), new Cell(2, 3, 0), new Cell(2, 4, 0)},
						{new Cell(3, 0, 0), new Cell(3, 1, 0), new Cell(3, 2, 0), new Cell(3, 3, 0), new Cell(3, 4, 0)},
						{new Cell(4, 0, 0), new Cell(4, 1, 0), new Cell(4, 2, 0), new Cell(4, 3, 0), new Cell(4, 4, 0)}
				}});
		Universe universe=new Universe(game.generateCells());
		Cell[][] cells = universe.playGame();
		int[][] futureCells = {{1,0,1,0,0},{1,0,0,0,1},{0,0,0,0,1},{1,0,0,0,1},{0,1,0,0,1}};
		int[][] resultCells=new int[5][5];
		for(int i=0;i<cells.length;i++)
			for (int j = 0; j < cells[0].length; j++)
				resultCells[i][j] = cells[i][j].getValue();
		assertTrue(Arrays.deepEquals(resultCells,futureCells));

	}
}
