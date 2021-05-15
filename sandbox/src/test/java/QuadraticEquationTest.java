import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuadraticEquationTest {

    @Test
    public void test0(){
        QuadraticEquation e = new QuadraticEquation(1, 1, 1);
        Assertions.assertEquals(e.getN(), 0);
    }

    @Test
    public void test1(){
        QuadraticEquation e = new QuadraticEquation(1, 12, 36);
        Assertions.assertEquals(e.getN(), 1);
    }

    @Test
    public void test2(){
        QuadraticEquation e = new QuadraticEquation(1, -2, -3);
        Assertions.assertEquals(e.getN(),2);
    }
}
