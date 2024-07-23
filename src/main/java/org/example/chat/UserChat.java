package org.example.chat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserChat extends UtilChat {
    private static final List<String> USER_LIST = new ArrayList<>();

    static {
        USER_LIST.add("Please choose an option:");
        USER_LIST.add("1.Log in");
        USER_LIST.add("2.Register");
        USER_LIST.add("3.Exit");
        USER_LIST.add("Exiting Foodplanner. Goodbye!");
        USER_LIST.add("Invalid option. Please try again.");
    }

    public static void displayUserChat() {
        printLogo();
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            printMenu(4, USER_LIST);
            String userChoice = sc.next();
            switch (userChoice) {
                case "1" -> printGreen("LogIn");
                case "2" -> printGreen("Register");
                case "3" -> {
                    printRed(USER_LIST.get(3));
                    System.exit(0);
                }
                default -> printRed(USER_LIST.get(5));
            }
        }
        sc.close();
    }

}
