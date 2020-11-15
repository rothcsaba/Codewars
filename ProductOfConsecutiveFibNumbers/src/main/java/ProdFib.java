package main.java;

public class ProdFib {

    public static long[] productFib(long prod) {
        long fib1 = 0;
        long fib2 = 1;
        do {
            long fib = fib1;
            fib1 = fib2;
            fib2 = fib + fib1;
        } while (fib1 * fib2 < prod);
        return new long[] {fib1, fib2, fib1 * fib2 == prod ? 1 : 0};
    }

    public static void main(String[] args) {
        System.out.println(productFib(4895));
        System.out.println(productFib(5895));
    }
}
