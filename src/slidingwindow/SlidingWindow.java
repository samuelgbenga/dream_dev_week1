package slidingwindow;


public class SlidingWindow {
    public static void main(String[] args) {

        int[] newArr = {1,5,6,9,3,2};
        int k = 2;

        subArray(newArr, k);
    }


    private static void subArray(int[] arr, int k){
        int[] subArrayIndex = slidingWindow(arr, k);
        for(int i = subArrayIndex[0]; i <= k; i++){
            System.out.println(arr[i]);
        }
    }

    private static int[] slidingWindow(int[] arr, int k){

        int left = 0;

        int sumFromLeft = 0;

        int sumFromRight = 0;

        int maxSum = 0;

        int[] subArrIndex = new int[2];

        int right = arr.length - 1;

        while(right >= 0){

            // get the sum of k elements from left[index]
            sumFromRight = getSumFromRight(arr, right, k);

            if(maxSum < sumFromRight){
                maxSum = sumFromRight;
                subArrIndex[1] = right;
                subArrIndex[0] =  right - k;
            }

            // get the sum of k elements from righ[index]
            sumFromLeft = getSumFromLeft(arr, left, k);

            if(maxSum < sumFromLeft){
                maxSum = sumFromLeft;
                subArrIndex[0] = left;
                subArrIndex[1] = left + k;
            }

            left++;
            right--;
        }

        return subArrIndex;
    }

    public static int getSumFromLeft(int[] arr, int leftIndex, int k){

        int maxIndex = leftIndex + k;

        if(maxIndex > arr.length - 1) return 0;

        int sum = 0;

        for(int i = leftIndex; i <= maxIndex; i++){
            sum = sum + arr[i];
        }

        return sum;

    }

    public static int getSumFromRight(int[] arr, int rightIndex, int k){

        int minIndex = rightIndex - k;
        if(minIndex < 0) return 0;

        int sum = 0;

        for(int i = rightIndex; i >= minIndex; i--){
            sum = sum + arr[i];
        }

        return sum;

    }

}