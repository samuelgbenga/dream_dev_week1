package mondayTwentyThreeAssessment.bank.exceptions;

public class InsufficientBalanceException extends BankAppException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}