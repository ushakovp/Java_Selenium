import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimesTests {

    @Test
    public void test0(){
        Assertions.assertTrue(Primes.isPrime(0));
    }

    @Test
    public void test1(){
        Assertions.assertTrue(Primes.isPrime(0));
    }

    @Test
    public void test2(){
        Assertions.assertTrue(Primes.isPrime(2));
    }

    @Test
    public void test4(){
        Assertions.assertFalse(Primes.isPrime(4));
    }

    @Test
    public void test7(){
        Assertions.assertTrue(Primes.isPrime(7));
    }

    @Test
    public void testMax(){
        Assertions.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
    }
}
