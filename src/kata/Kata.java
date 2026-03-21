package kata;

public class Kata {

    public static void main(String[] args) {
        System.out.println("Hello World");

        System.out.println(isPalindrome(40004));

        System.out.println(isPrimeNumber(40004));
        System.out.println(isEven(40004));
        System.out.println(subtract(40, 300));
        System.out.println(divide(40004,500));
        System.out.println(factorOf(40004));
        System.out.println(isSquare(40004));
        System.out.println(isSquare(50004));
        System.out.println(factorialOf(40004));
        System.out.println(squareOf(40004));

    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isPrimeNumber(int number){
        number = Math.abs(number);
        if(number <= 1) return false;
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0) return false;
        }
        return true;
    }

    public static int subtract(int num1, int num2){
        int result = num1 - num2;
        return Math.abs(result);
    }

    public static float divide(int a, int b) {
        return b == 0 ? 0 : (float) a / b;
    }

    public static int factorOf(int number) {
        if (number <= 0) return 0;

        int count = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        return count;
    }

    private static boolean isSquare(int number) {
        if (number < 0) return false;

        for (int i = 0; i <= Math.sqrt(number); i++) {
            if (i * i == number) return true;
        }

        return false;
    }

    public static boolean isPalindrome(int number) {

        if (number < 10000 || number > 99999) {
            return false;
        }

        int first = number / 10000;
        int second = (number / 1000) % 10;
        int fourth = (number / 10) % 10;
        int fifth = number % 10;

        return first == fifth && second == fourth;
    }

    public static long factorialOf(int number) {
        if (number < 0) {
            return 0;
        }

        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }

        return result;
    }

    public static long squareOf(int number) {
        return (long) number * number;
    }
}
