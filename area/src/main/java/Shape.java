public class Shape {
	private double length = 0;
	private double breadth = 0;

	private Shape() {

	}

	private Shape(double length, double breadth) {
		this.length = length;
		this.breadth = breadth;
	}

	private Shape(double length) {
		this.length = length;
		this.breadth = length;

	}

	public static Shape createRectangle(double length, double breadth) {
		return new Shape(length, breadth);
	}

	public static Shape createSquare(double side) {
		return new Shape(side);
	}

	public double area() {
		return this.length * this.breadth;
	}
}
