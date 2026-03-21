package ArrayKata;

public class ArrayKata {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(array[0]);
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
}

