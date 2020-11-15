package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AreSame {

    public static boolean compM1(int[] a, int[] b) {
        if ((a == null) || (b == null)) {
            return false;
        }
        int[] aa = Arrays.stream(a).map(n -> n * n).toArray();
        Arrays.sort(aa);
        Arrays.sort(b);
        return (Arrays.equals(aa, b));

    }

    public static boolean compM2(final int[] a, final int[] b) {
        return a != null && b != null && a.length == b.length
                && Arrays.equals(Arrays.stream(a).map(i -> i * i).sorted().toArray(), Arrays.stream(b).sorted().toArray());
    }

    public static boolean comp(int[] a, int[] b) {

        if ((a == null || b == null) || (a.length != b.length)) {
            return false;
        }

        if (a.length < 1) {
            return b.length < 1;
        }

        ArrayList<Integer> aList = new ArrayList<>();
        ArrayList<Integer> bList = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            aList.add(a[i] * a[i]);
            bList.add(b[i]);
        }

        Collections.sort(aList);
        Collections.sort(bList);

        return aList.equals(bList);
    }

    public static void main(String[] args) {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11, 1008};
        int[] b = new int[]{121, 14641, 20736, 36100, 25921, 361, 20736, 361};


        System.out.println(comp(a, b));
    }
}

