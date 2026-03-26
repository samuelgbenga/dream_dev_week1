package mondayTwentyThreeAssessment.bank.exceptions;

public class InvalidAmountException extends BankAppException {
    public InvalidAmountException(String message) {
        super(message);
    }
}