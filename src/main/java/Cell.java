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

	public boolean life() {
		return this.value == 1;
	}
}
