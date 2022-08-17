import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
	private int rows;
	private int columns;
	private List<List<Cell>> cells = new ArrayList<>();
	public Game(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
	}

	public List<List<Cell>>generateCells() {
		for (int row = 0; row < rows; row++) {
			List<Cell> rowCells=new ArrayList<>();
			for (int column = 0; column < columns; column++) {
				boolean value = randomNumber();
				rowCells.add(new Cell(row, column, value));
			}
			cells.add(rowCells);
		}
		return this.cells;
	}

	public boolean randomNumber() {
		int[] cellValues = {0, 1};
		int position = new Random().nextInt(cellValues.length);
		return cellValues[position] != 0;

	}


}
