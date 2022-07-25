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
	public Cell[][][] generateCells() {
		cells = new Cell[this.rows][this.columns];
		futureCells = new Cell[this.rows][this.columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				int value = randomNumber();
				cells[i][j] = new Cell(i, j, value);
				futureCells[i][j] = new Cell(i, j, 0);
			}
		}
		return new Cell[][][]{cells, futureCells};
	}

	public int randomNumber() {
		int[] cellValues = {0, 1};
		int position = new Random().nextInt(cellValues.length);
		return cellValues[position];

	}

}
