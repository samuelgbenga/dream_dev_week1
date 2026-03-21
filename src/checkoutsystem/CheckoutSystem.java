package checkoutsystem;

import java.util.Arrays;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckoutSystem {
    static Scanner input = new Scanner(System.in);
    static final double VAT_PERCENTAGE = 17.5;
    static String customerName, cashierName;
    static String[] products =  new String[2];
    static double[] prices = new double[2];
    static int[] quantities = new int[2];
    static int enterDiscount;
    static double amountPaid;


    public static void main(String[] args) {


        System.out.println("What is the Customer's name");
        customerName = input.nextLine();


        String yesOrNo;
        int counter = 0;
        do {
            takeInput(counter);
            counter++;
            System.out.println("Add more items? ");
            yesOrNo = input.nextLine();
        } while (yesOrNo.equalsIgnoreCase("yes"));

        getFinalSizeOfAllArray();

        System.out.println("What your Name? ");
        cashierName = input.nextLine();

        System.out.println("How much discount will he/she get? ");
        enterDiscount = Integer.parseInt(input.nextLine());


        System.out.println(checkoutTemplate());

        System.out.println("How much did the customer give you? ");
        amountPaid = Double.parseDouble(input.nextLine());

        System.out.println(receiptTemplate());
    }

    private static String checkoutTemplate() {

        double subTotal = 0;

        StringBuilder items = new StringBuilder();
        for (int i = 0; i < products.length; i++) {
            double total = prices[i] * quantities[i];
            subTotal += total;

            items.append(String.format(
                    "%-10s %5d %10.2f %10.2f%n",
                    products[i],
                    quantities[i],
                    prices[i],
                    total
            ));
        }

        double discount =  calculateTotalWithDiscount(enterDiscount, subTotal);
        double vat =  calculateTotalWithVAT(subTotal);
        double billTotal = subTotal - discount + vat;

        return String.format("""
            SEMICOLON STORES
            MAIN BRANCH
            LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.
            TEL: 03293828343
            Date: %s
            Cashier: %s
            Customer Name: %s
            ============================================
            ITEM        QTY     PRICE      TOTAL(NGN)
            --------------------------------------------
            %s
            --------------------------------------------
            Sub Total:     %.2f
            Discount:      %.2f
            VAT @ %.2f%%:  %.2f
            ============================================
            Bill Total:    %.2f
            ============================================
            THIS IS NOT A RECEIPT KINDLY PAY %.2f
            """,
                getLocalDateString(),
                cashierName,
                customerName,
                items,
                subTotal,
                discount,
                VAT_PERCENTAGE,
                vat,
                billTotal,
                billTotal
        );
    }

    private static String receiptTemplate(
    ) {

        double subTotal = 0;

        StringBuilder items = new StringBuilder();
        for (int i = 0; i < products.length; i++) {
            double total = prices[i] * quantities[i];
            subTotal += total;

            items.append(String.format(
                    "%-10s %5d %10.2f %10.2f%n",
                    products[i],
                    quantities[i],
                    prices[i],
                    total
            ));
        }
        double discount =  calculateTotalWithDiscount(enterDiscount, subTotal);
        double vat =  calculateTotalWithVAT(subTotal);
        double billTotal = subTotal - discount + vat;
        double balance = amountPaid - billTotal;
        return String.format("""
            SEMICOLON STORES
            MAIN BRANCH
            LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.
            TEL: 03293828343
            Date : %s
            Cashier: %s
            Customer Name: %s
            ============================================
            ITEM        QTY     PRICE      TOTAL(NGN)
            --------------------------------------------
            %s
            --------------------------------------------
            Sub Total:     %.2f
            Discount:      %.2f
            VAT @ %.2f%%:  %.2f
            ============================================
            Bill Total:     %.2f
            Amount Paid:    %.2f
            Balance:        %.2f
            ============================================
            THANK YOU FOR YOUR PATRONAGE
            """,
                getLocalDateString(),
                cashierName,
                customerName,
                items,
                subTotal,
                discount,
                VAT_PERCENTAGE,
                vat,
                billTotal,
                amountPaid,
                balance
        );
    }


    private static void takeInput(int counter){

        if(products.length - counter < 1) {
            updateAllArraySize();
        }

        System.out.println("What did the user buy?");
        products[counter] = input.nextLine();

        System.out.println("How many pieces?");
        quantities[counter] = Integer.parseInt(input.nextLine());

        System.out.println("How much per unit?");
        prices[counter] = Double.parseDouble(input.nextLine());
    }

    private static String getLocalDateString(){
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MMM-yy hh:mm:ss a");

        return now.format(formatter);
    }

    private static int[] getNewArray(int[] oldArray) {
        int[] newArray = new int[oldArray.length+5];

        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }

        return newArray;
    }

    private static String[] getNewArray(String[] oldArray) {
        String[] newArray = new String[oldArray.length+5];

        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }

        return newArray;
    }

    private static double[] getNewArray(double[] oldArray) {
        double[] newArray = new double[oldArray.length+5];

        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }

        return newArray;
    }
    
    private static int getActualSizeWithoutZeros(int[] oldArray) {
        int count = 0;

        for (int i : oldArray) {
            if(i == 0) continue;
            count++;
        }
        return count;
    }

    private static int getActualSizeWithoutZeros(double[] oldArray) {
        int count = 0;

        for (double i : oldArray) {
            if (Math.abs(i) < 1e-9) continue;
            count++;
        }
        return count;
    }

    private static int getActualSizeWithoutZeros(String[] oldArray) {
        int count = 0;

        for (String s : oldArray) {
            if (s == null || s.trim().isEmpty()) continue;
            count++;
        }
        return count;
    }


    private static int[] getActualSizeArray(int[] oldArray, int actualSize) {
        int[] newArray = new int[actualSize];

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = oldArray[i];
        }

        return newArray;
    }

    private static String[] getActualSizeArray(String[] oldArray, int actualSize) {
        String[] newArray = new String[actualSize];

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = oldArray[i];
        }

        return newArray;
    }

    private static double[] getActualSizeArray(double[] oldArray, int actualSize) {
        double[] newArray = new double[actualSize];

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = oldArray[i];
        }

        return newArray;
    }

    private static void updateAllArraySize(){
        products = getNewArray(products);
        prices = getNewArray(prices);
        quantities = getNewArray(quantities);

    }

    private static void getFinalSizeOfAllArray(){
        int actualSizeOfProductsWithoutZeros = getActualSizeWithoutZeros(products);
        int actualSizeOfPricesWithoutZeros = getActualSizeWithoutZeros(prices);
        int actualSizeOfQuantitiesWithoutZeros = getActualSizeWithoutZeros(quantities);
        products = getActualSizeArray( products,  actualSizeOfProductsWithoutZeros);
        prices = getActualSizeArray( prices,  actualSizeOfPricesWithoutZeros);
        quantities = getActualSizeArray( quantities,  actualSizeOfQuantitiesWithoutZeros);
    }

    public static double calculateTotalWithVAT(double amount) {
        return (VAT_PERCENTAGE / 100) * amount;
    }

    public static double calculateTotalWithDiscount(int discount, double amount) {
        return ((double) discount / 100) * amount;
    }
}
