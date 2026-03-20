package kata;

public class Kata {

    public static void main(String[] args) {
        System.out.println("Hello World");

        System.out.println(isPrimeNumber(-2));
        //isPrimeNumber(2);
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
}
