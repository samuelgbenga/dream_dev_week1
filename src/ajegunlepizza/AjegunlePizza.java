package ajegunlepizza;

import java.util.Scanner;

public class AjegunlePizza {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final String AJEGUNLE_PIZZA = """
        ********************************************* 
                        Ajegunle Pizza
        *********************************************""";
        final String AJEGUNLE_PIZZA_PRICE = """
                       SELECT PIZZA TYPE
                       1 -> SAPA_SIZE
                       2 -> SMALL_MONEY
                       3 -> BIG_BOYS
                       4 -> ODOGWU 
                       ENTER YOUR OPTION (1-4):""";

        System.out.println(AJEGUNLE_PIZZA);


        final int[] SAPA_SIZE = {4, 2500}; //{slices, price}
        final int[] SMALL_MONEY = {6, 2900};
        final int[] BIG_BOYS = {8, 4000};
        final int[] ODOGWU = {12, 5200};

        int numberOfBoxes = 0;
        int price = 0;
        int leftOver = 0;

        int[][] ajegunlePizza = {
                SAPA_SIZE,
                SMALL_MONEY,
                BIG_BOYS,
                ODOGWU,
        };

        System.out.print(AJEGUNLE_PIZZA_PRICE);
        int pizzaType = input.nextInt();

        System.out.print("NUMBER OF PEOPLE: ");
        int numberOfPeople = input.nextInt();

        if(pizzaType <= 4 && pizzaType >= 1) {
             numberOfBoxes = getNumberOfBoxes(ajegunlePizza[pizzaType-1][0], numberOfPeople);
             price = getPrice(ajegunlePizza[pizzaType-1][1], numberOfBoxes);
             leftOver = getLeftOver(numberOfBoxes, ajegunlePizza[pizzaType-1][0], numberOfPeople);
            printResult(price, leftOver, numberOfBoxes);
        }else{
            System.out.println("SELECTED OPTION IS NOT AVAILABLE");
        };
    }

    public static int getNumberOfBoxes(int typeSlice, int slices){
        int a = slices / typeSlice;
        int b = slices % typeSlice;
        return a + (b > 0 ? 1 : 0);
    }

    public static int getPrice(int typePrize, int boxNumber){
        return typePrize * boxNumber;
    }

    public static int getLeftOver(int numberOfBox, int typeSlice, int numberOfPeople){
        return (numberOfBox * typeSlice ) - numberOfPeople;
    }

    public static void printResult(int price, int leftOver, int boxes){
        System.out.println("Number of boxes of pizza to buy = " + boxes + "(boxes)");
        System.out.println("Number left over slices after serving = " + leftOver + "(slices)");
        System.out.println("Price = " + price + "(Naira)");

    }


}
