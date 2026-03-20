package backtosenderlogistics;

import java.util.Scanner;

public class BackToSenderLogistics {

    private static final int DELIVERY_PER_DAY = 100;
    private static final int BASE_PAYMENT = 5000;

    public static void main(String[] args) {


        System.out.println("Hello World");
        System.out.println("Delivery per day: " + DELIVERY_PER_DAY);
        amountToPay(40);
        amountToPay(10);
        amountToPay(80);
        amountToPay(50);
        amountToPay(20);
        amountToPay(30);
        amountToPay(60);
        amountToPay(70);
        amountToPay(90);
        amountToPay(100);
        amountToPay(0);
        amountToPay(-1);
        amountToPay(101);
        amountToPay(25);

    }

    public static int amountToPay(int deliveredPayDay){
        int deliveredPerDay = getValidDeliveryPerDay(deliveredPayDay);
        if(deliveredPerDay == -1) {
            System.out.println("Nothing for you baba");
            return 0;
        }
        int percentage = calculatePercentage(deliveredPerDay);
        int peggedAmount = getThePeggedAmount(percentage);
        int finalAmount = doTheFinalCalculation(deliveredPerDay, peggedAmount);
        System.out.println("Amount to pay: " + finalAmount);
        return finalAmount;

    }


    public static int getValidDeliveryPerDay(int deliveredPerDay){
        //Scanner scanner = new Scanner(System.in);
       // System.out.println("Enter delivery per day: ");
       // int deliveredPerDay = scanner.nextInt();
        if(deliveredPerDay < 0 || deliveredPerDay > DELIVERY_PER_DAY){
            System.out.println("Baba you they lie.");
            return -1;
        }
        return deliveredPerDay;
    }

    public static int calculatePercentage(int deliveredPerDay){
       int result = (int) ( ((double)deliveredPerDay / DELIVERY_PER_DAY) * 100);
        System.out.println("Percentage: " + result);
        return result;
    }

    public static int getThePeggedAmount(int percentage){
        if(percentage >= 70){
            return 500;
        }
        if(percentage >= 60 ){
            return 250;
        }
        if(percentage >= 50){
            return 200;
        }
        else return 160;
    }

    public static int doTheFinalCalculation(int deliveredPerDay, int peggedAmount){
        return (deliveredPerDay * peggedAmount) + BASE_PAYMENT;
    }


}
