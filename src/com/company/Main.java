package com.company;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static String askUser(String message, String regex) {
        String input;
        do {
            System.out.println(message);
            input = scanner.nextLine();
        } while (!input.matches(regex));
        return input;
    }

    public static String handleString(String string, String number) {
        if (string.length() <= Integer.parseInt(number)) {
            return string;
        }

        return string.replaceFirst(String.format("(.{%s})(.+)", number), "$2$1");
    }

    public static void main(String[] args) {
        String userInput = askUser("Please enter a string. Valid string", "(:?.|\\s)+");
        String number = askUser("Please enter a number. Valid number, please", "^[1-9][0-9]*$");
        System.out.println(handleString(userInput, number));
    }
}
