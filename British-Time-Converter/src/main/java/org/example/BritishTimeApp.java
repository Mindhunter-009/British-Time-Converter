package org.example;

import java.util.Scanner;


public class BritishTimeApp  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TimeToSpeechConverter converter = new TimeToSpeechConverter();

        System.out.println("Enter time in 24-hour format (HH:mm):");
        String input = scanner.nextLine();

        try {
            String[] parts = input.split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);

            String spoken = converter.toBritishSpokenForm(hour, minute);
            System.out.println("British Spoken Time: " + spoken);

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter time in HH:mm format.");
        }
    }
}