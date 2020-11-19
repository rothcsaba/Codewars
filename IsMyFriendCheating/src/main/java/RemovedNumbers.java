package main.java;

import java.util.ArrayList;
import java.util.List;

public class RemovedNumbers {

    public static List<long[]> removNb(long n) {
        List<long[]> souliton = new ArrayList<>();
        if (n == 1) {
            return souliton;
        }
        long sum = (n * (n + 1)) / 2;
        for (long i = 1; i <= n; i++) {
            double j = (sum - i) / (i + 1.0);
            if (j <= n && j == (long) j) {
                souliton.add(new long[]{i, (long) j});
            }
        }
        return souliton;
    }

    public static void main(String[] args) {
        List<long[]> longs = removNb(26);
        for (long[] array : longs) {
            System.out.println(array[0] + " " + array[1]);
        }
    }
}
