import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {
	@Test
	void areaOfRectangle() {
		Shape rectangle= Shape.createRectangle(5,6);
		double area =rectangle.area();
		assertEquals(area,30);
	}
}
