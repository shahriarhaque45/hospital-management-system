package com.curalink.utils;

import java.util.Scanner;

public class SystemUtils {
    public static Scanner scanner = new Scanner(System.in);

    public static int readInt(String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void pause() {
        System.out.print("\nPress Enter to go back...");
        scanner.nextLine();
    }
    
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
