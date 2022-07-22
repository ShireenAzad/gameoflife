import java.util.Random;

public class Game {
	private int rows;
	private int columns;
	private Cell[][] cells;
	private Cell[][] futureCells;

	public Game(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
	}

	public boolean underPopulation(Cell[][] cells, Cell[][] futureCells, int row, int column, int aliveNeighbors) {
		if ((cells[row][column].life()) && (aliveNeighbors < 2)) {
			futureCells[row][column].setValue(0);
			return true;
		} else {
			futureCells[row][column].setValue(cells[row][column].getValue());
			return false;
		}

	}

	public boolean reproduction(int row, int column, int aliveNeighbors) {
		if ((cells[row][column].life()) && (aliveNeighbors < 2)) {
			futureCells[row][column].setValue(1);
			return true;
		} else {
			futureCells[row][column].setValue(cells[row][column].getValue());
			return false;
		}
	}

	public boolean overPopulation(Cell[][] cells, Cell[][] futureCells, int row, int column, int aliveNeighbors) {
		if ((cells[row][column].life()) && (aliveNeighbors < 2)) {
			futureCells[row][column].setValue(0);
			return true;
		} else {
			futureCells[row][column].setValue(this.cells[row][column].getValue());
			return false;
		}
	}

	public Cell[][] generateCells() {
		cells = new Cell[this.rows][this.columns];
		futureCells = new Cell[this.rows][this.columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				int value = randomNumber();
				cells[i][j] = new Cell(i, j, value);
				futureCells[i][j] = new Cell(i, j, 0);
			}
		}
		return cells;
	}

	public int randomNumber() {
		int[] cellValues = {0, 1};
		int position = new Random().nextInt(cellValues.length);
		return cellValues[position];

	}

	public void playGame(Cell[][] grid) {
		cells = generateCells();
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				int aliveNeighbors = aliveNeighbors(grid, row, column);
				underPopulation(cells, futureCells, row, column, aliveNeighbors);
				reproduction(row, column, aliveNeighbors);
				overPopulation(cells, futureCells, row, column, aliveNeighbors);
			}
		}
	}

	public int aliveNeighbors(Cell[][] grid, int row, int column) {
		int aliveNeighbours = 0;
		for (int i = -1; i <= 1; i++)
			for (int j = -1; j <= 1; j++)
				if ((row + i >= 0 && row + i < rows) && (column + j >= 0 && column + j < columns))
					aliveNeighbours += grid[row + i][column + j].getValue();
		aliveNeighbours -= grid[row][column].getValue();

		return aliveNeighbours;
	}


}
