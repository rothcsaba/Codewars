package main.java;

import java.util.*;

public class WeightSort {

    public static String orderWeightM1(String string) {
        String[] split = string.split(" ");
        Arrays.sort(split, new Comparator<String>() {
            public int compare(String a, String b) {
                int aWeight = a.chars().map(c -> Character.getNumericValue(c)).sum();
                int bWeight = b.chars().map(c -> Character.getNumericValue(c)).sum();
                return aWeight - bWeight != 0 ? aWeight - bWeight : a.compareTo(b);
            }
        });
        return String.join(" ", split);
    }

    public static String orderWeight(String strng) {
        strng = strng + "/";
        Map<Long, List<String>> numberAndSum = new TreeMap<>();
        String actualnumber = "";
        for (int i = 0; i < strng.length(); i++) {
            char next = strng.charAt(i);
            List<Character> numberdigits = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
            if (numberdigits.contains(next)) {
                actualnumber += next;
            } else {
                if (!actualnumber.isBlank()) {
                    long num = Long.parseLong(actualnumber);
                    String number = Long.toString(num);
                    long digitsum = 0;
                    while (num > 0) {
                        digitsum = digitsum + num % 10;
                        num = num / 10;
                    }
                    List<String> numbers = numberAndSum.get(digitsum) == null ? new ArrayList<>() : numberAndSum.get(digitsum);
                    numbers.add(number);
                    Collections.sort(numbers);
                    numberAndSum.put(digitsum, numbers);
                    System.out.println(actualnumber);
                    actualnumber = "";
                }
            }
        }
        String solution = "";
        solution = numberAndSum.values().toString().replaceAll(",", "")
                .replaceAll("]" , "").replaceAll("\\[", "");
        return solution;
    }

    public static void main(String[] args) {
//        System.out.println(orderWeight("103 123 4444 99 2000"));
//        System.out.println(orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
        System.out.println(orderWeight("103 123 4444 99 2000\n" +
                "2000 10003 1234000 44444444 9999 11 11 22 123\n" +
                "\n" +
                "10003 1234000 44444444 9999 2000 123456789\n" +
                "3 16 9 38 95 1131268 49455 347464 59544965313 496636983114762 85246814996697"));
    }
}
