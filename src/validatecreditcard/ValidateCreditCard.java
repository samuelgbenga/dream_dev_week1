package validatecreditcard;
import java.util.Scanner;
import java.util.Arrays;

public class ValidateCreditCard {

    static final int VISA_CARD = 4;
    static final int MASTER_CARD = 5;
    static final int AMERICAN_EXPRESS_CARDS = 37;
    static final int DISCOVER_CARDS = 6;
    static String cardType;
    static final int MAX_LEN = 16;
    static final int MIN_LEN = 13;
    static String cardNumber ="5399831619690403";



    public static void main(String[] args) {
        //String input1 = "12345254467864";
         Scanner input = new Scanner(System.in);

        System.out.println("Hello, Kindly enter card details to very ");
        cardNumber = input.nextLine();

        int[] arr = stringToIntArray();
        int cardPrefix = (arr[0] == 3) ? arr[0]*10 + arr[1] : arr[0];
        setCardType(cardPrefix);
        String isValid = checkValidity(sumDoubleEveryOtherFromRight(arr), sumOddIndexedDigitsFromRightToLeft(arr));
        System.out.print(cardReportTemplate(isValid));

    }


    public static int[] stringToIntArray() {

        int[] result = new int[cardNumber.length()];

        for (int i = 0; i < cardNumber.length(); i++) {

            result[i] = Character.getNumericValue(cardNumber.charAt(i));
        }

        return result;
    }

    public static void setCardType(int cardPrefix) {
        cardType = switch (cardPrefix) {
            case VISA_CARD -> "Visa";
            case MASTER_CARD -> "MasterCard";
            case DISCOVER_CARDS -> "Discover";
            case AMERICAN_EXPRESS_CARDS -> "American Express";
            default -> "Invalid Card";
        };
    }

    private static int addUntilSingleDigit(int a, int b) {
        int sum = a + b;
        if (sum > 9) return addUntilSingleDigit(sum / 10, sum % 10);
        return sum;
    }

    private static String cardReportTemplate(String isValid){
        return String.format("""
        ************************************************
        ** Credit Card Type : %s
        ** Credit Card Number : %s
        ** Credit Card Digit length : %d
        ** Credit Card Validity Status : %s
        ************************************************
        """,
        cardType,
        cardNumber,
        cardNumber.length(),
        isValid
        );
    }


    public static int sumDoubleEveryOtherFromRight(int[] digits) {
        int sum = 0;
        int n = digits.length;


        for (int i = n - 2; i >= 0; i -= 2) {
            int a = digits[i] * 2;

            if(a > 9){
                a = addUntilSingleDigit(digits[i], digits[i]);
            }

            sum += a;
        }

        return sum;
    }

    public static int sumOddIndexedDigitsFromRightToLeft(int[] digits) {
        int sum = 0;
        int n = digits.length;


        for (int i = n - 1; i >= 0; i -= 2) {
            sum += digits[i];
        }
        return sum;
    }

    public static String checkValidity(int a, int b) {
        int len = cardNumber.length();
        if(len > MAX_LEN || len < MIN_LEN) return "Invalid";
        int sum = a + b;
        return (sum % 10 == 0) ? "Valid" : "Invalid";
    }
}
