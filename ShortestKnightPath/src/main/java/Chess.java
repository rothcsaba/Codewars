package main.java;

import java.util.Collections;
import java.util.HashSet;

public class Chess {

    public static int knight(String start, String finish) {
        HashSet<String> steps = new HashSet<>(Collections.singletonList(start));
        int numberOfMoves = 0;
        while (!steps.contains(finish)) {
            numberOfMoves++;
            for (Object step : steps.toArray()) {
                char x = step.toString().charAt(0);
                char y = step.toString().charAt(1);
                if (x > 'b' && y < '8') {
                    steps.add("" + (char) (x - 2) + (char) (y + 1));
                }
                if (x > 'b' && y > '1') {
                    steps.add("" + (char) (x - 2) + (char) (y - 1));
                }
                if (x > 'a' && y < '7') {
                    steps.add("" + (char) (x - 1) + (char) (y + 2));
                }
                if (x > 'a' && y > '2') {
                    steps.add("" + (char) (x - 1) + (char) (y - 2));
                }
                if (x < 'h' && y < '7') {
                    steps.add("" + (char) (x + 1) + (char) (y + 2));
                }
                if (x < 'h' && y > '2') {
                    steps.add("" + (char) (x + 1) + (char) (y - 2));
                }
                if (x < 'g' && y < '8') {
                    steps.add("" + (char) (x + 2) + (char) (y + 1));
                }
                if (x < 'g' && y > '1') {
                    steps.add("" + (char) (x + 2) + (char) (y - 1));
                }
            }
        }
        return numberOfMoves;
    }

    public static void main(String[] args) {
        System.out.println(knight("a1", "c1"));
        System.out.println(knight("a1", "f1"));
        System.out.println(knight("a1", "f3"));
        System.out.println(knight("a1", "f4"));
        System.out.println(knight("a1", "f7"));
        System.out.println(knight("a1", "c5"));
    }
}
