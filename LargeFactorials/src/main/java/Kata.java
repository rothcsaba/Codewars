package main.java;

import java.math.BigInteger;

public class Kata {

    public static String Factorial(int n) {
        if (n < 0) {
            return null;
        }
        if (n == 1) {
            return "1";
        } else {
            return new BigInteger(Factorial(n - 1)).multiply(BigInteger.valueOf(n)).toString();
        }
    }


    public static void main(String[] args) {
        System.out.println(Factorial(1));
        System.out.println(Factorial(5));
        System.out.println(Factorial(9));
        System.out.println(Factorial(15));
        System.out.println(Factorial(25));
    }
}
