import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FractionTest {
    Fraction fraction;

    @Before
    public void setup() {
        fraction = new Fraction(6, 8);
    }

    @After
    public void tearDown() {
        fraction = null;
    }

    @Test
    public void testToString() {
        assertEquals(fraction.toString(), "6/8");
    }

    @Test
    public void testReduce() {
        fraction = fraction.reduce(fraction);
        assertEquals(fraction.toString(), "3/4");
    }
}
