package backtosenderlogistics;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BackToSenderLogisticsTest {

    
    @Test
    public void test_with_pay_range_less_than_50() {
        int result = BackToSenderLogistics.amountToPay(25);

        assertEquals(9000, result);
    }

    @Test
    public void test_with_pay_range_50_60() {
        int result = BackToSenderLogistics.amountToPay(55);

        assertEquals(45000, result);
    }

    @Test
    public void test_with_pay_range_60_70() {
        int result = BackToSenderLogistics.amountToPay(66);

        assertEquals(45000, result);
    }

    @Test
    public void test_with_pay_range_70_above() {
        int result = BackToSenderLogistics.amountToPay(80);

        assertEquals(45000, result);
    }

    @Test
    public void test_with_pay_range_negative() {
        int result = BackToSenderLogistics.amountToPay(-1);

        assertEquals(0, result);
    }

    @Test
    public void test_with_pay_range_above_quota() {
        int result = BackToSenderLogistics.amountToPay(800);

        assertEquals(0, result);
    }

    @Test
    public void test_with_pay_0_delivery() {
        int result = BackToSenderLogistics.amountToPay(0);

        assertEquals(5000, result);
    }

}
