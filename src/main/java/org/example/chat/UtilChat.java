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
    public static final String ANSI_CLEAR_SCREEN = "\033[H\033[2J";
    public static final String ANSI_HOME = "\u001B[H";
    private static final List<String> TEXT_LIST =new ArrayList<>();

    static {
        TEXT_LIST.add("=====================================");
        TEXT_LIST.add("     WELCOME TO THE FOODPLANNER!");
    }

    protected String wordQuestion(Scanner sc, String question) {
        System.out.println(question);
        return sc.next();
    }
    protected int numberQuestion(Scanner sc, String question) {
        System.out.println(question);
        return sc.nextInt();
    }
    protected void printLogo(){
        printCyan(TEXT_LIST.get(0));
        printGreen(TEXT_LIST.get(1));
        printCyan(TEXT_LIST.get(0));
    }
    protected void printYellow(String text){
        System.out.println(ANSI_YELLOW + text + ANSI_RESET);
    }
    protected void printCyan(String text){
        System.out.println(ANSI_CYAN + text + ANSI_RESET);
    }
    protected void printGreen(String text){
        System.out.println(ANSI_GREEN + text + ANSI_RESET);
    }
    protected void printBlue(String text){
        System.out.println(ANSI_BLUE + text+ ANSI_RESET);
    }
    protected void printRed(String text){
        System.out.println(ANSI_RED + text+ ANSI_RESET);
    }
    protected void printPurple(String text){
        System.out.println(ANSI_PURPLE + text+ ANSI_RESET);
    }
    protected void printWhite(String text){
        System.out.println(ANSI_WHITE + text+ ANSI_RESET);
    }
    protected void clearConsole() {
        System.out.print(ANSI_CLEAR_SCREEN + ANSI_HOME);
        System.out.flush();
    }


}
