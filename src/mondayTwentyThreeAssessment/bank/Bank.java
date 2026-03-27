package mondayTwentyThreeAssessment.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {


    private final String name;



    private final List<Account> accounts = new ArrayList<>();

    public Bank(String name){
        this.name = name;
    }

    public void transfer(int srcNumber, int desNumber, BigDecimal amount, String pin){



    }

    public void deposit(int number, BigDecimal amount){

    }

    public void withdraw(int number, BigDecimal amount, String pin){

    }

    public BigDecimal checkBalance(int number, String pin){
        return null;
    }

    public void createAccount(String name, String pin){
        Account account = new Account(pin, name, 1234);
        accounts.add(account);

    }

    public int getAccountList(){
        int num = accounts.size();
        System.out.println(num);
        return num ;
    }

}
