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



    }

    public void deposit(int number, BigDecimal amount){
        getAccount(number).deposit(amount);

    }

    public void withdraw(int number, BigDecimal amount, String pin){

    }

    public BigDecimal checkBalance(int number, String pin){
        Account account = getAccount(number);
        return account.checkBalance(pin);
    }

    public void createAccount(String name, String pin){
        Account account = new Account(pin, name, 1234);
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
