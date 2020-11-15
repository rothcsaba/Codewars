package main.java;

public class ASum {

    public static long findNbM1(long m) {
        long mm = 0, n = 0;
        while (mm < m) mm += ++n * n * n;
        return mm == m ? n : -1;
    }

    public static long findNb(long m) {
        long n = 0;
        long sum = 0;
        while (sum < m) {
            sum += (n * n * n);
            if (sum == m) {
                return n;
            }
            n++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findNb(2304422822859502500L));
    }
}
