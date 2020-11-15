package main.java;

public class DuplicateEncoder {

    static String encodeM1(String word) {
        word = word.toLowerCase();
        String result = "";
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            result += word.lastIndexOf(c) == word.indexOf(c) ? "(" : ")";
        }
        return result;
    }

    static String encode(String word) {
        String encoded = "";

        for (int i = 0; i < word.length(); i++) {
            int sum = 0;
            for (int j = 0; j < word.length(); j++) {
                if (word.toLowerCase().charAt(i) == word.toLowerCase().charAt(j)) {
                    sum++;
                }
            }
            encoded = encoded.concat(sum > 1 ? ")" : "(");
        }

        return encoded;
    }

    public static void main(String[] args) {
        System.out.println(encode("Prespecialized"));
        System.out.println(encode("   ()(   "));
    }
}
