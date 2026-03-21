package ArrayKata;

public class ArrayKata {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(maximumIn(array));
        System.out.println(minimumIn(array));
        System.out.println(sumOf(array));
        System.out.println(sumOfEvenNumbersIn(array));
        System.out.println(sumOfOddNumbersIn(array));
    }


    public static int maximumIn(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static int minimumIn(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return min;
    }

    public static int sumOf(int[] arr) {
        if (arr == null) {
            return 0;
        }

        int sum = 0;

        for (int num : arr) {
            sum += num;
        }

        return sum;
    }

    public static int sumOfEvenNumbersIn(int[] arr) {
        if (arr == null) {
            return 0;
        }

        int sum = 0;

        for (int num : arr) {
           if(num % 2 == 0) sum += num;
        }

        return sum;
    }

    public static int sumOfOddNumbersIn(int[] arr) {
        if (arr == null) {
            return 0;
        }

        int sum = 0;

        for (int num : arr) {
            if(num % 2 != 0) sum += num;
        }

        return sum;
    }
}

