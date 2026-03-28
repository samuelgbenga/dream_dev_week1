package mondayTwentyThreeAssessment.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {

    private Account account;
    private String pin;
    private String desPin;
    private int desNumber;
    private int srcNumber;
    private BigDecimal bigDecimal;
    private String name;
    private String desName;
    Bank bank;

    @BeforeEach
    public void setUp() {
        name = "Samuel";
        desName = "Joseph";
        desNumber = 1234;
        desPin = "pin";
        srcNumber = 12345;
        pin = "1234";
        bigDecimal= new BigDecimal(100);

         bank = new Bank("Samuel Bank");
    }

    @Test
    public void create_a_new_account() {

        bank.createAccount(name, pin, srcNumber);

        assertEquals(1, bank.getAccountList());

    }

    @Test
    public void deposit_money_in_account(){
        bank.createAccount(name, pin, srcNumber);
        bank.deposit(srcNumber, new BigDecimal(100));
        assertEquals(new BigDecimal(100), bank.checkBalance(srcNumber, pin));
    }

    @Test
    public void withdraw_from_account(){
        bank.createAccount(name, pin, srcNumber);
        bank.deposit(srcNumber, new BigDecimal(100));
        bank.withdraw(srcNumber, new BigDecimal(50), name, pin);
        assertEquals(new BigDecimal(50), bank.checkBalance(srcNumber, pin));
    }


    @Test
    public void transfer_to_another_account(){
        bank.createAccount(name, pin, srcNumber);
        bank.createAccount(desName, desPin, desNumber);

        bank.deposit(srcNumber, new BigDecimal(100));
        bank.transfer(srcNumber, desNumber, new BigDecimal(50), pin);
        assertEquals(new BigDecimal(50), bank.checkBalance(desNumber, desPin));

    }


}
