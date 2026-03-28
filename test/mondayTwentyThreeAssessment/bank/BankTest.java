package mondayTwentyThreeAssessment.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {

    private Account account;
    private String pin;
    private int desNumber;
    private int srcNumber;
    private BigDecimal bigDecimal;
    private String name;
    Bank bank;

    @BeforeEach
    public void setUp() {
        name = "Samuel";
        desNumber = 1234;
        srcNumber = 12345;
        pin = "1234";
        bigDecimal= new BigDecimal(100);

         bank = new Bank("Samuel Bank");
    }

    @Test
    public void create_a_new_account() {

        bank.createAccount(name, pin);

        assertEquals(1, bank.getAccountList());

    }

    @Test
    public void deposit_money_in_account(){
        bank.createAccount(name, pin);
        bank.deposit(1234, new BigDecimal(100));
        assertEquals(new BigDecimal(100), bank.checkBalance(1234, pin));
    }


}
