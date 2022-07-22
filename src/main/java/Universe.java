public class Universe {
	private Cell[][][] cells;
	public Universe(Cell[][][] cells) {
		this.cells = cells;
	}
	public  Cell[][]playGame() {
		Cell[][] presentCells = cells[0];
		Cell[][] futureCells = cells[1];
		for (int row = 0; row < presentCells.length; row++) {
			for (int column   = 0; column < presentCells[0].length; column++) {
				int aliveNeighbors = presentCells[row][column].aliveNeighbors(presentCells, row, column);
				boolean isUnderPopulation = presentCells[row][column].underPopulation(presentCells, futureCells, row, column, aliveNeighbors);
				if(!isUnderPopulation){
					boolean isOverPopulation =presentCells[row][column].overPopulation(presentCells, futureCells, row, column, aliveNeighbors);
					if(!isOverPopulation)
						presentCells[row][column].reproduction(presentCells,futureCells,row, column, aliveNeighbors);
				}


			}
		}
		return futureCells;
	}

}
