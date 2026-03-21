package checkoutsystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckoutSystem {

    public static void main(String[] args) {
        String[] products = {"Parfait", "Rice"};
        long[] prices = {2100, 550};
        int[] quantities = {2, 2};

        String checkout = checkoutTemplate(
                "Chukwuma Adekunle Ciroma",
                "John Doe",
                424,
                products,
                prices,
                quantities,
                927
        );

        String receipt = receiptTemplate(
                "Chukwuma Adekunle Ciroma",
                "John Doe",
                424,
                products,
                prices,
                quantities,
                927,
                2100,
                550
        );
        System.out.println(receipt);
    }

    private static String checkoutTemplate(
            String customerName,
            String cashierName,
            long discount,
            String[] product,
            long[] productPrice,
            int[] productQuantity,
            long vat
    ) {

        long subTotal = 0;

        StringBuilder items = new StringBuilder();
        for (int i = 0; i < product.length; i++) {
            long total = productPrice[i] * productQuantity[i];
            subTotal += total;

            items.append(String.format(
                    "%-10s %5d %10d %10d%n",
                    product[i],
                    productQuantity[i],
                    productPrice[i],
                    total
            ));
        }

        long billTotal = subTotal - discount + vat;

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
            Sub Total:     %d
            Discount:      %d
            VAT:           %d
            ============================================
            Bill Total:    %d
            ============================================
            THIS IS NOT A RECEIPT KINDLY PAY %d
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
            long discount,
            String[] product,
            long[] productPrice,
            int[] productQuantity,
            long vat,
            long amountPaid,
            long balance
    ) {

        long subTotal = 0;

        StringBuilder items = new StringBuilder();
        for (int i = 0; i < product.length; i++) {
            long total = productPrice[i] * productQuantity[i];
            subTotal += total;

            items.append(String.format(
                    "%-10s %5d %10d %10d%n",
                    product[i],
                    productQuantity[i],
                    productPrice[i],
                    total
            ));
        }

        long billTotal = subTotal - discount + vat;

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
            Sub Total:     %d
            Discount:      %d
            VAT:           %d
            ============================================
            Bill Total:     %d
            Amount Paid:    %d
            Balance:        %d
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

    private static String getLocalDateString(){
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MMM-yy hh:mm:ss a");

        return now.format(formatter);
    }
}
