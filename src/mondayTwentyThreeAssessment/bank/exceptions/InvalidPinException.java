package mondayTwentyThreeAssessment.bank.exceptions;

public class InvalidPinException extends BankAppException {
    public InvalidPinException(String message) {
        super(message);
    }
}