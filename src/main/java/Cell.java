public class Cell {
	private final int xPosition;
	private final int yPosition;
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
	public boolean underPopulation(Cell[][] cells, Cell[][] futureCells, int row, int column, int aliveNeighbors) {
		if ((cells[row][column].isAlive()) && (aliveNeighbors < 2)) {
			futureCells[row][column].setValue(0);
			return true;
		}
		return false;

	}

	public boolean reproduction(Cell[][] cells, Cell[][] futureCells,int row, int column, int aliveNeighbors) {
		if ((!cells[row][column].isAlive()) && (aliveNeighbors == 3)) {
			futureCells[row][column].setValue(1);
			return true;
		}
		futureCells[row][column].setValue(cells[row][column].getValue());
		return false;

	}

	public boolean overPopulation(Cell[][] cells, Cell[][] futureCells, int row, int column, int aliveNeighbors) {
		if ((cells[row][column].isAlive()) && (aliveNeighbors > 3)) {
			futureCells[row][column].setValue(0);
			return true;
		}
		return false;

	}
	public int aliveNeighbors(Cell[][] grid, int row, int column) {
		int aliveNeighbours = 0;
		for (int i = -1; i <= 1; i++)
			for (int j = -1; j <= 1; j++)
				if ((row + i >= 0 && row + i < grid.length) && (column + j >= 0 && column + j < grid[0].length))
					aliveNeighbours += grid[row + i][column + j].getValue();
		aliveNeighbours -= grid[row][column].getValue();
		return aliveNeighbours;
	}
}
