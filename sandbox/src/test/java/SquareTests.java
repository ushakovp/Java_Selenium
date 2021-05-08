import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTests {
    @Test
    public void testArea() {
        Square square = new Square(5);
        Assertions.assertEquals(square.area(), 25);
    }
}
