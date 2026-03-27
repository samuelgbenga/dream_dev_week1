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
    private int number;
    Bank bank;

    @BeforeEach
    public void setUp() {
        name = "Samuel";
        desNumber = 1234;
        srcNumber = 12345;
        pin = "1234";
        bigDecimal= new BigDecimal(100);
        //account = new Account(pin, name, number);
         bank = new Bank("Samuel Bank");
    }

    @Test
    public void create_a_new_account() {

        bank.createAccount(name, pin);

        assertEquals(1, bank.getAccountList());

    }
}
