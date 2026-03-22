package checkoutsystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutSystemTest {

    @Test
    void testCalculateTotalWithVAT() {
        double result = CheckoutSystem.calculateTotalWithVAT(1000);

        assertEquals(175.0, result);
    }

    @Test
    void testCalculateTotalWithDiscount() {
        double result = CheckoutSystem.calculateTotalWithDiscount(10, 1000);

        assertEquals(100.0, result);
    }

    @Test
    void testZeroDiscount() {
        double result = CheckoutSystem.calculateTotalWithDiscount(0, 1000);
        assertEquals(0.0, result);
    }

    @Test
    void testZeroVAT() {
        double result = CheckoutSystem.calculateTotalWithVAT(0);
        assertEquals(0.0, result);
    }
}