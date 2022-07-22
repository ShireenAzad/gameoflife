import org.junit.jupiter.api.BeforeEach;

public class GameLifeTest {
	Game game;

	@BeforeEach
	void setUp() {
		game = new Game(5, 5);
	}
}
