package checkoutsystem;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckoutSystem {
    static Scanner input = new Scanner(System.in);
    static final double VAT_PERCENTAGE = 7.5;
    static String customerName, cashierName;
    static String[] products =  new String[2];
    static double[] prices = new double[2];
    static int[] quantities = new int[2];
    static int enterDiscount;


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

        System.out.println(customerName);
        System.out.println(products[0]);
        System.out.println(prices[0]);
        System.out.println(quantities[0]);



//        products[0] = "Parfait";
//        products[1] = "Rice";
//        prices[0] = 2100;
//        prices[1] = 550;
//        quantities[0] = 2;
//        quantities[1] = 2;
//
//        String checkout = checkoutTemplate(
//                "Chukwuma Adekunle Ciroma",
//                "John Doe",
//                424,
//                products,
//                prices,
//                quantities,
//                927
//        );
//
//        String receipt = receiptTemplate(
//                "Chukwuma Adekunle Ciroma",
//                "John Doe",
//                424,
//                products,
//                prices,
//                quantities,
//                927,
//                2100,
//                550
//        );
//        System.out.println(receipt);
    }

    private static String checkoutTemplate(
            String customerName,
            String cashierName,
            double discount,
            String[] product,
            double[] productPrice,
            int[] productQuantity,
            double vat
    ) {

        double subTotal = 0;

        StringBuilder items = new StringBuilder();
        for (int i = 0; i < product.length; i++) {
            double total = productPrice[i] * productQuantity[i];
            subTotal += total;

            items.append(String.format(
                    "%-10s %5d %10.2f %10.2f%n",
                    product[i],
                    productQuantity[i],
                    productPrice[i],
                    total
            ));
        }

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
            VAT:           %.2f
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
                vat,
                billTotal,
                billTotal
        );
    }

    private static String receiptTemplate(
            String customerName,
            String cashierName,
            double discount,
            String[] product,
            double[] productPrice,
            int[] productQuantity,
            double vat,
            double amountPaid,
            double balance
    ) {

        double subTotal = 0;

        StringBuilder items = new StringBuilder();
        for (int i = 0; i < product.length; i++) {
            double total = productPrice[i] * productQuantity[i];
            subTotal += total;

            items.append(String.format(
                    "%-10s %5d %10.2f %10.2f%n",
                    product[i],
                    productQuantity[i],
                    productPrice[i],
                    total
            ));
        }

        double billTotal = subTotal - discount + vat;

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
            VAT:           %.2f
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
                vat,
                billTotal,
                amountPaid,
                balance
        );
    }


    private static void takeInput(int counter){



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
}
