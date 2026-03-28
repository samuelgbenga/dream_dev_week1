package mondayTwentyThreeAssessment.bank;

import mondayTwentyThreeAssessment.bank.exceptions.InsufficientBalanceException;
import mondayTwentyThreeAssessment.bank.exceptions.InvalidNameException;

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
        Account srcAccount = getAccount(srcNumber);
        srcAccount.validatePin(pin);
        srcAccount.decreaseByAmount(amount);
        Account desAccount = getAccount(desNumber);
        desAccount.increaseByAmount(amount);
    }

    public void deposit(int number, BigDecimal amount){
        getAccount(number).deposit(amount);

    }

    public void withdraw(int number, BigDecimal amount, String pin){
        Account account = getAccount(number);
        account.validatePin(pin);
        account.decreaseByAmount(amount);

    }

    public BigDecimal checkBalance(int number, String pin){
        Account account = getAccount(number);
        return account.checkBalance(pin);
    }

    public void createAccount(String name, String pin, int number){
        Account account = new Account(pin, name, number);
        accounts.add(account);

    }

    public int getAccountList(){
        return accounts.size();
    }

    private Account getAccount(int number){
        for(Account a : accounts){
            if(a.getAccountNumber() == number){
                return a;
            }
        }
        throw new InvalidNameException("Invalid Account Number");
    }

}
