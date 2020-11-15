package main.java;

public class NumberFun {

    public static long findNextSquareM1(long sq) {
        long root = (long) Math.sqrt(sq);
        return root * root == sq ? (root + 1) * (root + 1) : -1;
    }

    public static long findNextSquare(long sq) {
        double sqrt = Math.sqrt(sq);
        if (sqrt % 1 == 0) {
            return (long) Math.pow(((int) sqrt + 1), 2);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findNextSquare(121));
        System.out.println(findNextSquare(625));
        System.out.println(findNextSquare(114));
    }
}
