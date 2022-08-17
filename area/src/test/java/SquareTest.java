import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareTest {

	@Test
	void areaOfSquare() {
		Shape square = Shape.createSquare(5);
		double area =square.area();
		assertEquals(area, 25);
	}
}
