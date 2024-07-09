package org.example.chat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainChat extends UtilChat {

    private static final List<String> OPTIONS_LIST = new ArrayList<>();

    static {
        OPTIONS_LIST.add("Please choose an option:");
        OPTIONS_LIST.add("1.Log in or Register[NOT READY]");
        OPTIONS_LIST.add("2.Make CRUD operations");
        OPTIONS_LIST.add("3.Generate random food");
        OPTIONS_LIST.add("4.Exit program");

        OPTIONS_LIST.add("Invalid option. Please try again.");
        OPTIONS_LIST.add("Exiting Foodplanner. Goodbye!");
        OPTIONS_LIST.add("Feature not yet ready, please try something else!");
    }

    public MainChat() {
        printLogo();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            clearConsole();
            printMenu();
            String mainChoice = scanner.next();
            switch (mainChoice) {
                case "1":
                    printGreen(OPTIONS_LIST.get(7));
                    break;
                case "2":
                    System.out.println(ANSI_GREEN + "The weather is sunny with a chance of rain." + ANSI_RESET);
                    break;
                case "3":
                    System.out.println(ANSI_GREEN + "Goodbye! Have a great day!" + ANSI_RESET);
                    break;
                case "4":
                    running = false;
                    printRed(OPTIONS_LIST.get(6));
                    break;
                default:
                    printRed(OPTIONS_LIST.get(5));
            }

            System.out.println();  // Print a blank line for spacing
        }
        scanner.close();
    }

    private void printMenu() {
        printYellow(OPTIONS_LIST.get(0));
        for (int index = 1; index < 5; index++) {
            printBlue(OPTIONS_LIST.get(index));
        }
    }
}
