public record Coordinates(int xPosition, int yPosition) {


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Coordinates that = (Coordinates) o;
		return xPosition == that.xPosition && yPosition == that.yPosition;
	}

	@Override
	public String toString() {
		return "Coordinates{" +
				"xPosition=" + xPosition +
				", yPosition=" + yPosition +
				'}';
	}
}
