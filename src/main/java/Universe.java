public class Universe {
	private Cell[][][] cells;

	public Universe(Cell[][][] cells) {
		this.cells = cells;
	}

	public Cell[][] playGame() {
		Cell[][] presentCells = cells[0];
		Cell[][] futureCells = cells[1];
		for (int row = 0; row < presentCells.length; row++) {
			for (int column = 0; column < presentCells[0].length; column++) {
				presentCells[row][column].neighbors(presentCells);
				boolean isCellAlive = presentCells[row][column].isCellAliveForNextGeneration();
				futureCells[row][column].setValue(isCellAlive ? 1 : 0);
			}
		}
		return futureCells;
	}

}
