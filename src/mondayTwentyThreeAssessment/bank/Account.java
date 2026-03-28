package mondayTwentyThreeAssessment.bank;



import mondayTwentyThreeAssessment.bank.exceptions.*;

import java.math.BigDecimal;

public class Account {
    private  String pin;
    private  String name;
    private  int number;

    private BigDecimal balance = new BigDecimal(0);


    public Account(String pin, String name, int number) {
        this.pin = pin;
        this.name = name;
        this.number = number;
    }

    public Account(){};

    public BigDecimal checkBalance(String pin) {
        validatePin(pin);
        return balance;
    }

    public void deposit(BigDecimal amount) {
        validateAmount(amount);
        this.balance = balance.add(amount);
    }

    private void validateAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidAmountException("Amount must be positive");
        }
    }


    public void withdraw(BigDecimal amount, String pin, String name, int number) {
        validate(pin, name, number);
        validateWithdraw(amount);
        this.balance = balance.subtract(amount);
    }

    public void validatePin(String pin){
        if(!this.pin.equals(pin) ){
            throw new InvalidPinException("Invalid Pin");
        }
    }

    public void validateNumber(int number){
        if(this.number != number ){
            throw new InvalidNumberException("Invalid Number");
        }
    }

    public void validateName(String name){
        if(!this.name.equals(name) ){
            throw new InvalidNameException("Invalid Name");
        }
    }

    public void validate(String pin, String name, int number){
        validatePin(pin);
        validateName(name);
        validateNumber(number);
    }

    public int getAccountNumber(){
        return number;
    }

    public void decreaseByAmount(BigDecimal amount){
        balance = balance.subtract(amount);
    }

    public void increaseByAmount(BigDecimal amount){
        balance = balance.add(amount);
    }

    private void validateWithdraw(BigDecimal amount) {
        validateAmount(amount);
        if (amount.compareTo(balance) > 0) {
            throw new InsufficientBalanceException("Insufficient funds");
        }
    }

}