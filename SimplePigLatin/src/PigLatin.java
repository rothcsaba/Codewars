import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PigLatin {

    public static String pigItM1(String str) {
        // Referenced the first letter with number 1 and the rest of the word with number 2
        // and finished the new word with 'ay'
        return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
    }

    public static String pigItM2(String str) {
        return Arrays.stream(str.trim().split(" "))
                .map(v -> v.matches("[a-zA-Z]+") ? v.substring(1).concat(v.substring(0, 1)).concat("ay") : v)
                .collect(Collectors.joining(" "));
    }

    public static String pigIt(String str) {
        List<String> words = new ArrayList<>();
        String word = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                if (!word.isBlank()) {
                    words.add(word);
                }
                word = "";
            } else {
                word += str.charAt(i);
                if (i == str.length() - 1) {
                    words.add(word);
                }
            }
        }
        String solution = "";
        for (String original : words) {
            if (".".equals(original) || "!".equals(original) || "?".equals(original) || "[".equals(original) || "]".equals(original)) {
                solution += original + " ";
            } else {
                solution += original.substring(1, original.length()) + original.charAt(0) + "ay ";
            }
        }
        return solution.substring(0, solution.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(pigIt("Pig latin is cool"));
        System.out.println(pigIt("This is my string"));
        System.out.println(pigIt("Hello world !"));
    }
}
