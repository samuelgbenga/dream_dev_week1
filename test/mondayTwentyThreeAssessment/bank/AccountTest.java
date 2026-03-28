package mondayTwentyThreeAssessment.bank;


import mondayTwentyThreeAssessment.bank.exceptions.InsufficientBalanceException;
import mondayTwentyThreeAssessment.bank.exceptions.InvalidAmountException;
import mondayTwentyThreeAssessment.bank.exceptions.InvalidPinException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    private Account account;
    private String pin;
    private String name;
    private int number;

    @BeforeEach
    public void setUp() {
        name = "Samuel";
        number = 1234;
        pin = "1234";
        account = new Account(pin, name, number);
    }
    @Test
    public void newAccount_balanceIsEmptyTest() {
        assertEquals(BigDecimal.ZERO, account.checkBalance(pin));
    }

    @Test
    public void deposit5kIntoNewAccount_balanceIs5kTest() {
        assertEquals(BigDecimal.ZERO, account.checkBalance(pin));
        account.deposit(BigDecimal.valueOf(5_000));
        assertEquals(BigDecimal.valueOf(5_000), account.checkBalance(pin));
    }

    @Test
    public void deposit5kTwiceIntoNewAccount_balanceIs10kTest() {
        assertEquals(BigDecimal.ZERO, account.checkBalance(pin));
        account.deposit(BigDecimal.valueOf(5_000));
        account.deposit(BigDecimal.valueOf(5_000));
        assertEquals(BigDecimal.valueOf(10_000), account.checkBalance(pin));
    }

    @Test
    public void depositNegativeAmount_throwsExceptionTest(){
        assertEquals(BigDecimal.ZERO, account.checkBalance(pin));
        assertThrows(InvalidAmountException.class, ()-> account.deposit(BigDecimal.valueOf(-1000)));
        assertEquals(BigDecimal.ZERO, account.checkBalance(pin));
    }

    @Test
    public void deposit5k_withdraw2k_balanceIs3k_balanceIs10kTest() {
        account.deposit(BigDecimal.valueOf(5_000));
        assertEquals(BigDecimal.valueOf(5_000), account.checkBalance(pin));
        account.withdraw(BigDecimal.valueOf(2_000), pin, name, number);
        assertEquals(BigDecimal.valueOf(3_000), account.checkBalance(pin));
    }

    @Test
    public void deposit5k_withdraw10k_throwsExceptionTest() {
        account.deposit(BigDecimal.valueOf(5_000));
        assertEquals(BigDecimal.valueOf(5_000), account.checkBalance(pin));
        assertThrows(InsufficientBalanceException.class, ()-> account.withdraw(BigDecimal.valueOf(10_000), pin, name, number));
        assertEquals(BigDecimal.valueOf(5_000), account.checkBalance(pin));
    }

    @Test
    public void deposit5k_withdrawNegativeAmount_throwsExceptionTest() {
        account.deposit(BigDecimal.valueOf(5_000));
        assertEquals(BigDecimal.valueOf(5_000), account.checkBalance(pin));
        assertThrows(InvalidAmountException.class, ()-> account.withdraw(BigDecimal.valueOf(-1_000), pin, name, number));
        assertEquals(BigDecimal.valueOf(5_000), account.checkBalance(pin));
    }

    @Test
    public void withdrawWithWrongPin_throwsExceptionTest(){
        account.deposit(BigDecimal.valueOf(5_000));
        assertEquals(BigDecimal.valueOf(5_000), account.checkBalance(pin));
        assertThrows(InvalidPinException.class, ()-> account.withdraw(BigDecimal.valueOf(2_000), "Incorrect Pin", name, number));
        assertEquals(BigDecimal.valueOf(5_000), account.checkBalance(pin));
    }
}