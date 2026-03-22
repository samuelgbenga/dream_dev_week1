package ajegunlepizza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AjegunlePizzaTest {

    @Test
    void testGetNumberOfBoxes_exactDivision() {

        int result = AjegunlePizza.getNumberOfBoxes(4, 8);
        assertEquals(2, result);
    }

    @Test
    void testGetNumberOfBoxes_withRemainder() {

        int result = AjegunlePizza.getNumberOfBoxes(4, 10);
        assertEquals(3, result);
    }

    @Test
    void testGetNumberOfBoxes_lessThanOneBox() {

        int result = AjegunlePizza.getNumberOfBoxes(4, 3);
        assertEquals(1, result);
    }

    @Test
    void testGetPrice() {

        int result = AjegunlePizza.getPrice(2500, 3);
        assertEquals(7500, result);
    }

    @Test
    void testGetLeftOver() {
        // 3 boxes * 4 slices = 12 slices, 10 people → 2 leftover
        int result = AjegunlePizza.getLeftOver(3, 4, 10);
        assertEquals(2, result);
    }
}