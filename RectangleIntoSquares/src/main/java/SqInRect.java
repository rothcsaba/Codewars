package main.java;

import java.util.ArrayList;
import java.util.List;

public class SqInRect {

    public static List<Integer> sqInRectM1(int l, int w) {
        if(l == w)
            return null;
        else if(l > w)
            return sqInRect(w, l);

        List<Integer> answer = new ArrayList<>();
        answer.add(w);
        answer.addAll(sqInRect(w, l - w));
        return answer;
    }

    public static List<Integer> sqInRect(int lng, int wdth) {
        List<Integer> list = new ArrayList<>();
        if (lng == wdth) {
            return null;
        }
        int max = Math.max(lng, wdth);
        int min = Math.min(lng, wdth);
        do {
            list.add(min);
            int tmp = max - min;
            max = Math.max(min, tmp);
            min = Math.min(min, tmp);
        } while (Math.min(max, min) > 0);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(sqInRect(5, 3));
    }
}
