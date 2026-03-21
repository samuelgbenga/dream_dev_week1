package ArrayKata;

import java.util.Arrays;

public class ArrayKata {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] array1 = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5,  5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5,  5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 3, 2};
        System.out.println(maximumIn(array));
        System.out.println(minimumIn(array));
        System.out.println(sumOf(array));
        System.out.println(sumOfEvenNumbersIn(array));
        System.out.println(sumOfOddNumbersIn(array));
        System.out.println(Arrays.toString(maximumAndMinimumOf(array)));
        System.out.println(Arrays.toString(noOfOddNumbersIn(array)));
        System.out.println(Arrays.toString(noOfEvenNumbersIn(array)));
        System.out.println(Arrays.toString(evenNumbersIn(array1)));
        System.out.println(Arrays.toString(oddNumbersIn(array1)));
        System.out.println(Arrays.toString(evenNumbersIn(array2)));
        System.out.println(Arrays.toString(oddNumbersIn(array2)));
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

    public static int[] maximumAndMinimumOf(int[] arr) {
        int[] result = new int[2];

        if (arr == null || arr.length == 0) {
            return result;
        }

        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        result[1] = max;
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        result[0] = min;
        return result;
    }

    public static int[] noOfOddNumbersIn(int[] arr) {
        int[] result = new int[1];

        if (arr == null) {
            return result;
        }

        int count = 0;

        for (int num : arr) {
            if(num % 2 != 0) {
                count += 1;
            };
        }
        result[0] = count;
        return result;
    }

    public static int[] noOfEvenNumbersIn(int[] arr) {
        int[] result = new int[1];

        if (arr == null) {
            return result;
        }

        int count = 0;

        for (int num : arr) {
            if(num % 2 == 0) {
                count += 1;
            };
        }
        result[0] = count;
        return result;
    }

    public static int[] evenNumbersIn(int[] arr) {
        int[] result = new int[5];

        if (arr == null) {
            return result;
        }

        int count = 0;

        for (int j : arr) {
            if (j % 2 == 0) {
                result[count] = j;
                count++;
            }
            if((result.length - count) < 1) {
                result = getNewArray(result);
            };
        }

        return getActualSizeArray(result ,getActualSizeWithoutZeros(result));
    }

    public static int[] oddNumbersIn(int[] arr) {
        int[] result = new int[5];

        if (arr == null) {
            return result;
        }

        int count = 0;

        for (int j : arr) {
            if (j % 2 != 0) {
                result[count] = j;
                count++;
            }
            if((result.length - count) < 1) {
                result = getNewArray(result);
            };
        }

        return getActualSizeArray(result ,getActualSizeWithoutZeros(result));
    }
    public static int[] getNewArray(int[] oldArray) {
        int[] newArray = new int[oldArray.length+5];

        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }

        return newArray;
    }

    public static int getActualSizeWithoutZeros(int[] oldArray) {
        int count = 0;

        for (int i : oldArray) {
            if(i == 0) continue;
            count++;
        }
        return count;
    }

    public static int[] getActualSizeArray(int[] oldArray, int actualSize) {
        int[] newArray = new int[actualSize];

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = oldArray[i];
        }

        return newArray;
    }
}

