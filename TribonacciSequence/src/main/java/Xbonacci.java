package main.java;

public class Xbonacci {

    public static double[] tribonacci(double[] s, int n) {
        if (n == 0) {
            return new double[0];
        }
        double[] solution = new double[n];
        for (int i = 0; i < n; i++) {
            solution[i] = i < 3 ? s[i] : solution[i - 1] + solution[i - 2] + solution[i - 3];
        }
        return solution;
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(new double[]{0, 1, 1}, 10));
    }
}
