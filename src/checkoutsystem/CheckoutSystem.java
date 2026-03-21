package checkoutsystem;

public class CheckoutSystem {

    public static void main(String[] args) {
        String[] products = {"Parfait", "Rice"};
        long[] prices = {2100, 550};
        int[] quantities = {2, 2};

        String receipt = checkoutTemplate(
                "Chukwuma Adekunle Ciroma",
                "John Doe",
                424,
                products,
                prices,
                quantities,
                927
        );

        System.out.println(receipt);
    }

    public static String checkoutTemplate(
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
                cashierName,
                customerName,
                items.toString(),
                subTotal,
                discount,
                vat,
                billTotal,
                billTotal
        );
    }

}
