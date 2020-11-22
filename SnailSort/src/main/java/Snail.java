package main.java;

import java.util.Arrays;

public class Snail {

    public static int[] snailM1(int[][] array) {
        if (array[0].length == 0) {
            return new int[0];
        }
        int n = array.length;
        int[] answer = new int[n * n];
        int index = 0;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i; j++) {
                answer[index++] = array[i][j];
            }
            for (int j = i + 1; j < n - i; j++) {
                answer[index++] = array[j][n - i - 1];
            }
            for (int j = i + 1; j < n - i; j++) {
                answer[index++] = array[n - i - 1][n - j - 1];
            }
            for (int j = i + 1; j < n - i - 1; j++) {
                answer[index++] = array[n - j - 1][i];
            }
        }
        if (n % 2 != 0) {
            answer[index] = array[n / 2][n / 2];
        }
        return answer;
    }

    public static int[] snail(int[][] array) {
        if (array == null || array[0].length == 0) {
            return new int[]{};
        }
        int length = array.length;
        int size = length * length;
        int actualSize = size;
        int[] solution = new int[size];
        int turn = 0;
        do {
            for (int i = turn; i < length - turn; i++) {
                solution[size - actualSize] = array[turn][i];
                actualSize--;
                if (actualSize == 0) {
                    break;
                }
            }
            for (int j = turn + 1; j < length - turn; j++) {
                solution[size - actualSize] = array[j][length - turn - 1];
                actualSize--;
                if (actualSize == 0) {
                    break;
                }
            }
            for (int k = length - turn - 2; k >= turn; k--) {
                solution[size - actualSize] = array[length - turn - 1][k];
                actualSize--;
                if (actualSize == 0) {
                    break;
                }
            }
            for (int l = length - turn - 2; l > turn; l--) {
                solution[size - actualSize] = array[l][turn];
                actualSize--;
                if (actualSize == 0) {
                    break;
                }
            }
            turn++;
        } while (actualSize > 0);
        return solution;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(snail(null)));

        int[][] array2 = new int[][]{{}};
        System.out.println(Arrays.toString(snail(array2)));

        int[][] array3
                = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(Arrays.toString(snail(array3)));

        int[][] array4
                = {{1, 2, 3, 1},
                {4, 5, 6, 4},
                {7, 8, 9, 7},
                {7, 8, 9, 7}};
        System.out.println(Arrays.toString(snail(array4)));
    }
}
