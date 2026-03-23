package monday_23;

public class FigureToWord {

    static final String TEN = "Ten";
    static final String HUNDRED = "Hundred";
    static final String THOUSAND = "Thousand";
    static final String MILLION = "Million";

    static final String ONE = "One";
    static final String TWO = "Two";
    static final String THREE = "Three";
    static final String FOUR = "Four";
    static final String FIVE = "Five";
    static final String SIX = "Six";
    static final String SEVEN = "Seven";
    static final String EIGHT = "Eight";
    static final String NINE = "Nine";

    static final String ELEVEN = "Eleven";
    static final String TWELVE = "Twelve";
    static final String THIRTEEN = "Thirteen";
    static final String FOURTEEN = "Fourteen";
    static final String FIFTEEN = "Fifteen";
    static final String SIXTEEN = "Sixteen";
    static final String SEVENTEEN = "Seventeen";
    static final String EIGHTEEN = "Eighteen";
    static final String NINETEEN = "Nineteen";


    static final String TWENTY = "Twenty";
    static final String THIRTY = "Thirty";
    static final String FORTY = "Forty";
    static final String FIFTY = "Fifty";
    static final String SIXTY = "Sixty";
    static final String SEVENTY = "Seventy";
    static final String EIGHTY = "Eighty";
    static final String NINETY = "Ninety";





    public static void main(String[] args) {




        System.out.println(getNumber(70));

    }






    public static String getNumber(int number){
        return switch (number) {
            case 10 -> TEN;
            case 100 -> HUNDRED;
            case 1000 -> THOUSAND;
            case 1000000 -> MILLION;
            case 1 -> ONE;
            case 2 -> TWO;
            case 3 -> THREE;
            case 4 -> FOUR;
            case 5 -> FIVE;
            case 6 -> SIX;
            case 7 -> SEVEN;
            case 8 -> EIGHT;
            case 9 -> NINE;
            case 11 -> ELEVEN;
            case 12 -> TWELVE;
            case 13 -> THIRTEEN;
            case 14 -> FOURTEEN;
            case 15 -> FIFTEEN;
            case 16 -> SIXTEEN;
            case 17 -> SEVENTEEN;
            case 18 -> EIGHTEEN;
            case 19 -> NINETEEN;
            case 20 -> TWENTY;
            case 30 -> THIRTY;
            case 40 -> FORTY;
            case 50 -> FIFTY;
            case 60 -> SIXTY;
            case 70 -> SEVENTY;
            case 80 -> EIGHTY;
            case 90 -> NINETY;
            default -> "Invalid Number";
        };
    }
}
