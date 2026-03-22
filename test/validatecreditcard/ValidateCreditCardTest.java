package validatecreditcard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateCreditCardTest {

    @BeforeEach
    void setUp() {

        ValidateCreditCard.cardNumber = "5399831619690403";
    }

    @Test
    void testStringToIntArray() {
        int[] result = ValidateCreditCard.stringToIntArray();

        assertArrayEquals(
                new int[]{5,3,9,9,8,3,1,6,1,9,6,9,0,4,0,3},
                result
        );
    }

    @Test
    void testCardType() {
        ValidateCreditCard.setCardType(5);
        assertEquals("MasterCard", ValidateCreditCard.cardType);

        ValidateCreditCard.setCardType(4);
        assertEquals("Visa", ValidateCreditCard.cardType);

        ValidateCreditCard.setCardType(37);
        assertEquals("American Express", ValidateCreditCard.cardType);
    }

    @Test
    void testLuhnSumParts() {
        int[] digits = ValidateCreditCard.stringToIntArray();

        int evenSum = ValidateCreditCard.sumDoubleEveryOtherFromRight(digits);
        int oddSum = ValidateCreditCard.sumOddIndexedDigitsFromRightToLeft(digits);

        assertTrue(evenSum > 0);
        assertTrue(oddSum > 0);
    }

    @Test
    void testValidCard() {
        int[] digits = ValidateCreditCard.stringToIntArray();

        int evenSum = ValidateCreditCard.sumDoubleEveryOtherFromRight(digits);
        int oddSum = ValidateCreditCard.sumOddIndexedDigitsFromRightToLeft(digits);

        String result = ValidateCreditCard.checkValidity(evenSum, oddSum);

        assertEquals("Valid", result);
    }

    @Test
    void testInvalidCardLength() {
        ValidateCreditCard.cardNumber = "12345";

        int[] digits = ValidateCreditCard.stringToIntArray();

        int evenSum = ValidateCreditCard.sumDoubleEveryOtherFromRight(digits);
        int oddSum = ValidateCreditCard.sumOddIndexedDigitsFromRightToLeft(digits);

        String result = ValidateCreditCard.checkValidity(evenSum, oddSum);

        assertEquals("Invalid", result);
    }
}