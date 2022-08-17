import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.mockito.Mockito.when;

public class UniverseTest {
	Game game;
	Universe universe;

	@BeforeEach
	void setUp() {
		game = Mockito.mock(Game.class);
		when(game.generateCells()).thenReturn(
				List.of(List.of(
								new Cell(0, 0, false), new Cell(0, 1, true), new Cell(0, 2, true), new Cell(0, 3, false), new Cell(0, 4, true)),
						List.of(new Cell(1, 0, true), new Cell(1, 1, true), new Cell(1, 2, true), new Cell(1, 3, false), new Cell(1, 4, true)),
						List.of(new Cell(2, 0, false), new Cell(2, 1, true), new Cell(2, 2, true), new Cell(2, 3, false), new Cell(2, 4, true)),
						List.of(new Cell(3, 0, false), new Cell(3, 1, true), new Cell(3, 2, true), new Cell(3, 3, false), new Cell(3, 4, true)),
						List.of(new Cell(4, 0, false), new Cell(4, 1, true), new Cell(4, 2, true), new Cell(4, 3, true), new Cell(4, 4, true)))
		);
		universe = new Universe(game.generateCells());
	}

	@Test
	void checkingAliveNeighbors() {

		Cell cell = new Cell(0, 1, true);
		List<Cell> neighbors = universe.findNeighbors(cell);
		System.out.println(neighbors);

		assertThat(neighbors, containsInAnyOrder(
				new Cell(0, 0, false), new Cell(0, 2, true),
				new Cell(1, 0, true), new Cell(1, 1, true), new Cell(1, 2, true)));
	}

	@Test
	void nextGeneration() {
		List<List<Cell>> futureCells = universe.nextGeneration();
		assertThat(futureCells, containsInAnyOrder(
				List.of(new Cell(0, 0, true), new Cell(0, 1, false), new Cell(0, 2, true), new Cell(0, 3, false), new Cell(0, 4, false)),
				List.of(new Cell(1, 0, true), new Cell(1, 1, false), new Cell(1, 2, false), new Cell(1, 3, false), new Cell(1, 4, true)),
				List.of(new Cell(2, 0, false), new Cell(2, 1, false), new Cell(2, 2, false), new Cell(2, 3, false), new Cell(2, 4, true)),
				List.of(new Cell(3, 0, true), new Cell(3, 1, false), new Cell(3, 2, false), new Cell(3, 3, false), new Cell(3, 4, true)),
				List.of(new Cell(4, 0, false), new Cell(4, 1, true), new Cell(4, 2, false), new Cell(4, 3, false), new Cell(4, 4, true))

		));

	}
}
