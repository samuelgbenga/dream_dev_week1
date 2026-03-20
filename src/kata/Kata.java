package kata;

public class Kata {

    public static void main(String[] args) {
        System.out.println("Hello World");

        System.out.println(isSquare(400));

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

    public static boolean isSquare(int number) {
        if (number < 0) return false;

        for (int i = 0; i <= Math.sqrt(number); i++) {
            if (i * i == number) return true;
        }

        return false;
    }
}
