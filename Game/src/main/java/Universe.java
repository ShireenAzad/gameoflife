import java.util.ArrayList;
import java.util.List;

public class Universe {
	private List<Cell> neighbors;
	private final List<List<Cell>> cells;
	private final List<List<Cell>> futureCells=new ArrayList<>();

	public Universe(List<List<Cell>> cells) {
		this.cells = cells;
	}

	public List<Cell> findNeighbors(Cell cell) {
		neighbors=new ArrayList<>();
		int xPosition = cell.getCellPosition().xPosition();
		int yPosition = cell.getCellPosition().yPosition();
		for (int xIndex = xPosition-1; xIndex <= xPosition+1; xIndex++) {
			for (int yIndex = yPosition - 1; yIndex <= yPosition + 1; yIndex++)
				if ((xIndex != xPosition || yIndex != yPosition) && (xIndex != -1 && yIndex != -1) && (yIndex < cells.get(0).size()) && (xIndex < cells.size())) {
					neighbors.add(new Cell(cells.get(xIndex).get(yIndex).getCellPosition().xPosition(), cells.get(xIndex).get(yIndex).getCellPosition().yPosition(), cells.get(xIndex).get(yIndex).getAlive()));
				}
		}
		return neighbors;

	}


	public List<List<Cell>> nextGeneration() {
		for (List<Cell> rowListCells : cells) {
			List<Cell> rowCells=new ArrayList<>();
			for (Cell cell : rowListCells) {
				neighbors = findNeighbors(cell);
				cell.neighbors(neighbors);
				rowCells.add(cell.isCellAliveFor() ? new Cell(cell.getCellPosition().xPosition(), cell.getCellPosition().yPosition(), true) : new Cell(cell.getCellPosition().xPosition(), cell.getCellPosition().yPosition(), false));
			}
			futureCells.add(rowCells);
		}
		return futureCells;
	}
}
