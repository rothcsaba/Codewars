package main.java;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TimeFormatter {

    public static String formatDurationM1(int seconds) {
        return seconds == 0 ? "now" :
                Arrays.stream(
                        new String[]{
                                formatTime("year", (seconds / 31536000)),
                                formatTime("day", (seconds / 86400) % 365),
                                formatTime("hour", (seconds / 3600) % 24),
                                formatTime("minute", (seconds / 60) % 60),
                                formatTime("second", (seconds % 3600) % 60)})
                        .filter(e -> e != "")
                        .collect(Collectors.joining(", "))
                        .replaceAll(", (?!.+,)", " and ");
    }

    public static String formatTime(String s, int time) {
        return time == 0 ? "" : Integer.toString(time) + " " + s + (time == 1 ? "" : "s");
    }

    public static String formatDuration(int seconds) {
        if (seconds == 0) {
            return "now";
        }
        int second = seconds % 60;
        int minute = (seconds % 3600 - second) / 60;
        int hour = (seconds % 86400 - second - 60 * minute) / 3600;
        int day = (seconds % 31536000 - second - 60 * minute - 3600 * hour) / 86400;
        int year = (seconds - second - 60 * minute - 3600 * hour - 86400 * day) / 31536000;
        String answer = "";
        if (year > 0) {
            answer += year + (year == 1 ? " year" : " years") + ", ";
        }
        if (day > 0) {
            answer += day + (day == 1 ? " day" : " days") + ", ";
        }
        if (hour > 0) {
            answer += hour + (hour == 1 ? " hour" : " hours") + ", ";
        }
        if (minute > 0) {
            answer += minute + (minute == 1 ? " minute" : " minutes") + ", ";
        }
        if (second > 0) {
            answer += second + (second == 1 ? " second" : " seconds");
        }
        if (answer.charAt(answer.length() - 1) == ' ') {
            answer = answer.substring(0, answer.length() - 2);
        }
        return answer.replaceFirst("(?s)" + ", " + "(?!.*?" + ", " + ")", " and ");
    }

    public static void main(String[] args) {
        System.out.println(formatDuration(3662));
        System.out.println(formatDuration(31626061));
        System.out.println(formatDuration(31626060));
    }
}
