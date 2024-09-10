package org.example.chat;

import org.example.dish.DishDao;
import org.example.login.AESEncryption;
import org.example.login.User;
import org.example.login.UserDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserDashboardChat extends UtilChat {
    private static final List<String> DASHBOARD_LIST = new ArrayList<>();
    private static final List<String> SUBQ_LIST = new ArrayList<>();

    static {
        DASHBOARD_LIST.add("Please choose an option:");
        DASHBOARD_LIST.add("1.Edit username");
        DASHBOARD_LIST.add("2.Edit password");
        DASHBOARD_LIST.add("3.Edit email");
        DASHBOARD_LIST.add("4.Delete user");
        DASHBOARD_LIST.add("5.Go back to main menu");
        DASHBOARD_LIST.add("Invalid option. Please try again.");

        SUBQ_LIST.add("Write your new username:");
        SUBQ_LIST.add(" will be you new username, are you sure you want it? [Y/N]");
        SUBQ_LIST.add("Write your new password:");
        SUBQ_LIST.add("Write your new password again:");
        SUBQ_LIST.add("You wrote 2 diferent passwords.");
        SUBQ_LIST.add("Write your new email:");
        SUBQ_LIST.add("Write your new email again:");
        SUBQ_LIST.add("You wrote 2 diferent emails.");


    }

    public static void displayUserDashboardChat(User user) {
        printUserLogo(user.getUsername());
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            printMenu(6, DASHBOARD_LIST);
            String crudChoice = sc.next();
            switch (crudChoice) {
                case "1" -> {
                  editUsername(user);
                  System.out.println("Username edited");
                }
                case "2" -> {}
                case "3" ->{}
                case "4" -> {}
                case "5" -> {running = false;}
                default -> printRed(DASHBOARD_LIST.get(6));
            }
        }
    }

    private static void editUsername(User user) {
        String newUssername = wordQuestion(new Scanner(System.in), SUBQ_LIST.get(0));
        String newUssernameVer = wordQuestion(new Scanner(System.in), newUssername + SUBQ_LIST.get(1));
        // todo pomyslec czy nie wsadzic zmienna encypted w userze
        if (newUssernameVer.toUpperCase().equals("Y")) {
            try {
//                String test1=AESEncryption.decrypt(user.getUsername());
//                String test2=AESEncryption.decrypt(newUssername);
                UserDao.updateUsername(AESEncryption.encrypt(user.getUsername()), AESEncryption.encrypt(newUssername));
            }catch(Exception e){
                System.out.println(e);
                printRed(DASHBOARD_LIST.get(6));
            }
            System.out.println("Done");
        }
    }
}
