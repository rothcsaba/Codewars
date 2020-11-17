package main.java;

import java.util.HashSet;
import java.util.Set;

public class SudokuValidator {

    public static boolean check(int[][] sudoku) {
        for(int i = 0; i < 9; i++) {
            Set<Integer> setRow = new HashSet<>();
            Set<Integer> setColumn = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0 || !setRow.add(sudoku[i][j]) || !setColumn.add(sudoku[j][i])) {
                    return false;
                }
            }
        }
        for(int i = 0; i < 3; i++) {
            Set<Integer> subgrids = new HashSet<>();
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (!subgrids.add(sudoku[3 * i + j][3 * i + k])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] sudoku = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        System.out.println(check(sudoku));
    }
}
