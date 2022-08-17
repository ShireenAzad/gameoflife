import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cell {
	private final Coordinates coordinates;
	private final boolean isAlive;
	private final List<Cell> neighbors;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Cell)) return false;
		Cell cell = (Cell) o;
		return isAlive == cell.isAlive && coordinates.equals(cell.coordinates);
	}

	@Override
	public int hashCode() {
		return Objects.hash(coordinates, isAlive);
	}

	public Cell(int xPosition, int yPosition, boolean isAlive) {
		this.coordinates=new Coordinates(xPosition,yPosition);
		this.isAlive = isAlive;
		neighbors = new ArrayList<>();
	}

	public boolean isAlive() {
		return isAlive;
	}

	public long aliveNeighborsCount() {
		long aliveNeighbors = this.neighbors.stream().filter(Cell::isAlive).count();
		return aliveNeighbors;
	}

	public boolean isCellAliveFor() {
		if(diesWithStarvation())
			return false;
		if(diesWithOverPopulation())
			return false;
		if (isBorn())
			return true;
		return isSurvives();
	}

	public boolean isSurvives() {
		return isAlive() && ((aliveNeighborsCount() == 2) || aliveNeighborsCount() == 3);

	}

	public boolean diesWithStarvation() {
		return isAlive() && aliveNeighborsCount() < 2;
	}

	public boolean diesWithOverPopulation() {
		return isAlive() && aliveNeighborsCount() > 3;
	}

	public boolean isBorn() {
		return !isAlive() && aliveNeighborsCount() == 3;
	}

	public void neighbors(List<Cell> neighboringCells) {
		neighbors.addAll(neighboringCells);
	}

	public Coordinates getCellPosition() {
		return coordinates;
	}

	public boolean getAlive() {
		return isAlive;
	}

	@Override
	public String toString() {
		return "Cell{" +
				"coordinates=" + coordinates +
				", isAlive=" + isAlive +
				'}';
	}
}
