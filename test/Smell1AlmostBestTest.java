package solid3.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import solid3.Smell1AlmostBest;

class Smell1AlmostBestTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testPositivePowerCalculation() {
        assertEquals(8, Smell1AlmostBest.toPower(2, 3),
                "2 to the power of 3 should be 8");
        assertEquals(64, Smell1AlmostBest.toPower(4, 3),
                "4 to the power of 3 should be 64");
    }

    @Test
    void testZeroPower() {
        assertEquals(1, Smell1AlmostBest.toPower(5, 0),
                "Any number to the power of 0 should be 1");
        assertEquals(1, Smell1AlmostBest.toPower(0, 0),
                "0 to the power of 0 should be 1");
    }

    @Test
    void testPowerOfOne() {
        assertEquals(5, Smell1AlmostBest.toPower(5, 1),
                "Any number to the power of 1 should be itself");
    }

    @Test
    void testNegativeWithOddPower() {
        assertEquals(-27, Smell1AlmostBest.toPower(-3, 3),
                "Negative base with odd power should return negative result");
    }

    @Test
    void testNegativeBaseWithEvenPower() {
        assertEquals(9, Smell1AlmostBest.toPower(-3, 2),
                "Negative base with even power should return positive result");
    }

    @Test
    void testZeroBaseWithPositivePower() {
        assertEquals(0, Smell1AlmostBest.toPower(0, 5),
                "Zero to any positive power should be zero");
    }

    @Test
    void testNegativePowerShouldThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> Smell1AlmostBest.toPower(2, -1),
                "Negative power should throw an IllegalArgumentException");
    }

    @Test
    void testCachingBehavior() {
        int firstCall = Smell1AlmostBest.toPower(2, 3);

        int secondCall = Smell1AlmostBest.toPower(2, 3);

        assertEquals(8, firstCall, "First call should calculate 2^3 as 8");
        assertEquals(8, secondCall, "Second call should return cached value");
    }

    @Test
    void testLargeBaseSmallPower() {
        assertEquals(1000000, Smell1AlmostBest.toPower(10, 6),
                "10 to the power of 6 should be 1000000");
    }

    @Test
    void testVeryBigPower() {
        assertThrows(ArithmeticException.class,
                () -> Smell1AlmostBest.toPower(2, 31),
                "Very large power should throw an ArithmeticException due to integer overflow");
    }
}