package org.example.chat;

import org.example.login.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainChat extends UtilChat {

    private static final List<String> OPTIONS_LIST = new ArrayList<>();

    static {
        OPTIONS_LIST.add("Please choose an option:");
        OPTIONS_LIST.add("1.Enter user dashboard [NOT READY]");
        OPTIONS_LIST.add("2.Make CRUD operations");
        OPTIONS_LIST.add("3.Generate random food");
        OPTIONS_LIST.add("4.Exit program");

        OPTIONS_LIST.add("Invalid option. Please try again.");
        OPTIONS_LIST.add("Exiting Foodplanner. Goodbye!");
        OPTIONS_LIST.add("Feature not yet ready, please try something else!");
    }

    public static void displayMainChat(/*User user*/) {
        printLogo();
//        printUserLogo(user.getUsername());
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            printMenu(5,OPTIONS_LIST);
            String mainChoice = sc.next();
            switch (mainChoice) {
                case "1" -> printGreen(OPTIONS_LIST.get(7));
                case "2" -> CRUDChat.displayCRUDChat();
                case "3" -> PlaningChat.displayPlaningChat();
                case "4" -> {
                    running = false;
                    printRed(OPTIONS_LIST.get(6));
                }
                default -> printRed(OPTIONS_LIST.get(5));
            }
            clearConsole();
            System.out.println();  // Print a blank line for spacing
        }
        sc.close();
    }


}
