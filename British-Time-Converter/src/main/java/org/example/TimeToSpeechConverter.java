package org.example;

public class TimeToSpeechConverter {

    private static final String[] HOURS = {
            "twelve", "one", "two", "three", "four", "five",
            "six", "seven", "eight", "nine", "ten", "eleven"
    };

    private static final String[] BELOW_20 = {
            "zero","one","two","three","four","five","six","seven","eight","nine",
            "ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen",
            "seventeen","eighteen","nineteen"
    };

    private static final String[] TENS = {
            "", "", "twenty", "thirty", "forty", "fifty"
    };

    public String toBritishSpokenForm(int hour, int minute)
    {
        // InValid Case
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Invalid time input.");
        }

        // Special cases
        if (hour == 0 && minute == 0) return "midnight";
        if (hour == 12 && minute == 0) return "noon";

        String hourWord = HOURS[hour % 12];
        String nextHourWord = HOURS[(hour + 1) % 12];

        if (minute == 0) {
            return hourWord + " o'clock";
        } else if (minute == 15) {
            return "quarter past " + hourWord;
        } else if (minute == 30) {
            return "half past " + hourWord;
        } else if (minute == 45) {
            return "quarter to " + nextHourWord;
        }

        if (minute % 5 == 0) {
            if (minute < 30) {
                return numberToWords(minute) + " past " + hourWord;
            } else {
                return numberToWords(60 - minute) + " to " + nextHourWord;
            }
        } else {
            // Digital style: "six thirty-two", use "oh" for single-digit minutes
            String minuteWords = minute < 10 ? "oh " + numberToWords(minute) : numberToWords(minute);
            return hourWord + " " + minuteWords;
        }
    }

    private String numberToWords(int n) {
        if (n < 0 || n > 59) throw new IllegalArgumentException("Out of range: " + n);
        if (n < 20) return BELOW_20[n];
        int tens = n / 10;
        int ones = n % 10;
        if (ones == 0) return TENS[tens];
        return TENS[tens] + "-" + BELOW_20[ones];
    }
}
