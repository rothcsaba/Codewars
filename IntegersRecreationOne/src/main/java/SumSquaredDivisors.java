package main.java;

import java.util.Arrays;

public class SumSquaredDivisors {

    public static String listSquared(long m, long n) {
        StringBuilder solution = new StringBuilder("[");
        for (long i = m; i <= n; i++) {
            long sum = 0;
            for (long j = 1; j <= i; j++) {
                if (i % j == 0) {
                    sum += j * j;
                }
            }
            if (Math.sqrt(sum) % 1 == 0) {
                solution.append("[").append(i).append(", ").append(sum).append("], ");
            }
        }
        if (solution.length() > 1) {
            solution.delete(solution.length() - 2, solution.length());
        }
        return solution.toString().concat("]");
    }

    public static void main(String[] args) {
        System.out.println(listSquared(5, 10));
        System.out.println(listSquared(1, 250));
        System.out.println(listSquared(42, 250));
        System.out.println(listSquared(250, 500));
    }
}
