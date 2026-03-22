package ArrayKata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayKataTest {

    int[] arr = {1, 2, 3, 4, 5};
    int[] empty = {};
    int[] nullArray = null;

    @Test
    void testMaximumIn() {
        assertEquals(5, ArrayKata.maximumIn(arr));
        assertEquals(-1, ArrayKata.maximumIn(empty));
        assertEquals(-1, ArrayKata.maximumIn(nullArray));
    }

    @Test
    void testMinimumIn() {
        assertEquals(1, ArrayKata.minimumIn(arr));
        assertEquals(0, ArrayKata.minimumIn(empty));
        assertEquals(0, ArrayKata.minimumIn(nullArray));
    }

    @Test
    void testSumOf() {
        assertEquals(15, ArrayKata.sumOf(arr));
        assertEquals(0, ArrayKata.sumOf(nullArray));
    }

    @Test
    void testSumOfEvenNumbersIn() {
        assertEquals(6, ArrayKata.sumOfEvenNumbersIn(arr)); // 2 + 4
        assertEquals(0, ArrayKata.sumOfEvenNumbersIn(nullArray));
    }

    @Test
    void testSumOfOddNumbersIn() {
        assertEquals(9, ArrayKata.sumOfOddNumbersIn(arr)); // 1 + 3 + 5
        assertEquals(0, ArrayKata.sumOfOddNumbersIn(nullArray));
    }

    @Test
    void testMaximumAndMinimumOf() {
        int[] result = ArrayKata.maximumAndMinimumOf(arr);
        assertArrayEquals(new int[]{1, 5}, result);

        assertArrayEquals(new int[]{0, 0}, ArrayKata.maximumAndMinimumOf(empty));
        assertArrayEquals(new int[]{0, 0}, ArrayKata.maximumAndMinimumOf(nullArray));
    }

    @Test
    void testNoOfOddNumbersIn() {
        assertArrayEquals(new int[]{3}, ArrayKata.noOfOddNumbersIn(arr));
        assertArrayEquals(new int[]{0}, ArrayKata.noOfOddNumbersIn(nullArray));
    }

    @Test
    void testNoOfEvenNumbersIn() {
        assertArrayEquals(new int[]{2}, ArrayKata.noOfEvenNumbersIn(arr));
        assertArrayEquals(new int[]{0}, ArrayKata.noOfEvenNumbersIn(nullArray));
    }

    @Test
    void testEvenNumbersIn() {
        int[] result = ArrayKata.evenNumbersIn(arr);
        assertArrayEquals(new int[]{2, 4}, result);
    }

    @Test
    void testOddNumbersIn() {
        int[] result = ArrayKata.oddNumbersIn(arr);
        assertArrayEquals(new int[]{1, 3, 5}, result);
    }

    @Test
    void testSquareNumbersIn() {
        int[] input = {1, 2, 3, 4, 5, 9, 10};
        int[] result = ArrayKata.squareNumbersIn(input);
        assertArrayEquals(new int[]{1, 4, 9}, result);
    }
}