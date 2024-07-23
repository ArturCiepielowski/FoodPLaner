package org.example.chat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UtilChat {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_CLEAR_SCREEN = "\u001B[2J";
    public static final String ANSI_HOME = "\u001B[H";
    private static final List<String> TEXT_LIST = new ArrayList<>();

    static {
        TEXT_LIST.add("=====================================");
        TEXT_LIST.add("     WELCOME TO THE FOODPLANNER!");
    }

    public static String wordQuestion(Scanner sc, String question) {
        printGreen(question);
        return sc.nextLine();
    }

    public static int numberQuestion(Scanner sc, String question) {
        printGreen(question);
        return sc.nextInt();
    }

    public static void printLogo() {
        printCyan(TEXT_LIST.get(0));
        printGreen(TEXT_LIST.get(1));
        printCyan(TEXT_LIST.get(0));
    }

    public static void printMenu(int numOfPos,List<String> menuList) {
        printYellow(menuList.get(0));
        for (int index = 1; index < numOfPos; index++) {
            printBlue(menuList.get(index));
        }
    }

    public static void printYellow(String text) {
        System.out.println(ANSI_YELLOW + text + ANSI_RESET);
    }

    public static void printCyan(String text) {
        System.out.println(ANSI_CYAN + text + ANSI_RESET);
    }

    public static void printGreen(String text) {
        System.out.println(ANSI_GREEN + text + ANSI_RESET);
    }

    public static void printBlue(String text) {
        System.out.println(ANSI_BLUE + text + ANSI_RESET);
    }

    public static void printRed(String text) {
        System.out.println(ANSI_RED + text + ANSI_RESET);
    }

    public static void printPurple(String text) {
        System.out.println(ANSI_PURPLE + text + ANSI_RESET);
    }

    public static void printWhite(String text) {
        System.out.println(ANSI_WHITE + text + ANSI_RESET);
    }

    public static void clearConsole() {
        System.out.print(ANSI_CLEAR_SCREEN + ANSI_HOME);
        System.out.flush();
    }
}
