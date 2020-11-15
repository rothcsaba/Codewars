package main.java;

public class Max {

    public static int sequence(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }

        int maxSum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return Math.max(maxSum, 0);
    }

    public static void main(String[] args) {
        System.out.println(sequence(new int[]{}));
        System.out.println(sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }


}
