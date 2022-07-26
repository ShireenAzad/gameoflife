import java.util.ArrayList;
import java.util.List;

public class Cell {
	private final int xPosition;
	private final int yPosition;
	private List<Cell> neighbors = new ArrayList<>();
	private int value;

	public Cell(int xPosition, int yPosition, int value) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.value = value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public boolean isAlive() {
		return this.value == 1;
	}

	public boolean isCellAliveForNextGeneration() {
		long aliveNeighbors = neighbors.stream().filter(Cell::isAlive).count();
		if (value == 1) aliveNeighbors = aliveNeighbors - 1;
		return (!isAlive() || aliveNeighbors >= 2) &&
				(!isAlive() || aliveNeighbors <= 3) &&
				(!isAlive() && aliveNeighbors == 3 || value == 1);

	}

	public void neighbors(Cell[][] grid) {
		for (int i = xPosition - 1; i <= xPosition + 1; i++)
			for (int j = yPosition - 1; j <= yPosition + 1; j++)
				if ((i != -1) && (j != -1)) {
					neighbors.add(new Cell(i, j, grid[i][j].getValue()));
				}

	}
}
