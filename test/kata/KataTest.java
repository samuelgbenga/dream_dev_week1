package kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KataTest {

    @Test
    void testIsEven() {
        assertTrue(Kata.isEven(4));
        assertFalse(Kata.isEven(5));
    }

    @Test
    void testIsPrimeNumber() {
        assertTrue(Kata.isPrimeNumber(7));
        assertFalse(Kata.isPrimeNumber(4));
        assertFalse(Kata.isPrimeNumber(1));
        assertTrue(Kata.isPrimeNumber(-7)); // abs handled
    }

    @Test
    void testSubtract() {
        assertEquals(260, Kata.subtract(40, 300));
        assertEquals(10, Kata.subtract(20, 10));
    }

    @Test
    void testDivide() {
        assertEquals(2.0f, Kata.divide(10, 5));
        assertEquals(0.0f, Kata.divide(10, 0)); // edge case
    }

    @Test
    void testFactorOf() {
        assertEquals(6, Kata.factorOf(12)); // 1,2,3,4,6,12
        assertEquals(0, Kata.factorOf(0));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(Kata.isPalindrome(12321));
        assertFalse(Kata.isPalindrome(12345));
        assertFalse(Kata.isPalindrome(1234)); // not 5-digit
    }

    @Test
    void testFactorialOf() {
        assertEquals(120, Kata.factorialOf(5));
        assertEquals(1, Kata.factorialOf(0));
        assertEquals(0, Kata.factorialOf(-5));
    }

    @Test
    void testSquareOf() {
        assertEquals(25, Kata.squareOf(5));
        assertEquals(0, Kata.squareOf(0));
    }
}