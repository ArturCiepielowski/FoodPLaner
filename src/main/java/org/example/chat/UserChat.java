package org.example.chat;

import org.example.login.AESEncryption;
import org.example.login.User;
import org.example.login.UserDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserChat extends UtilChat {
    private static final List<String> USER_LIST = new ArrayList<>();
    private static final List<String> LOGIN_LIST = new ArrayList<>();

    static {
        USER_LIST.add("Please choose an option:");
        USER_LIST.add("1.Log in");
        USER_LIST.add("2.Register");
        USER_LIST.add("3.Exit");
        USER_LIST.add("Exiting Foodplanner. Goodbye!");
        USER_LIST.add("Invalid option. Please try again.");

        LOGIN_LIST.add("Please write your username:");
        LOGIN_LIST.add("Please write your password");
        LOGIN_LIST.add("Please write your email");
        LOGIN_LIST.add("Thank you for registration! You can log in now.");
        LOGIN_LIST.add("Username or password incorrect");
    }

    public static void displayUserChat() {
        printLogo();
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            printMenu(4, USER_LIST);
            String userChoice = sc.next();
            switch (userChoice) {
                case "1" -> loginChat();
                case "2" -> registerChat();
                case "3" -> {
                    printRed(USER_LIST.get(4));
                    System.exit(0);
                }
                default -> printRed(USER_LIST.get(5));
            }
        }
        sc.close();
    }

    private static void loginChat() {
        String username = wordQuestion(new Scanner(System.in), LOGIN_LIST.get(0));
        String password = wordQuestion(new Scanner(System.in), LOGIN_LIST.get(1));
        String encryptedName = null;
        String encryptPass=null;
        try {
            encryptedName = AESEncryption.encrypt(username);
            encryptPass = AESEncryption.encrypt(password);
        }catch(Exception e){
            printRed(USER_LIST.get(5));
        }
        User currentUser = UserDao.verifyUser(encryptedName,encryptPass);
        if(currentUser!=null) {
            currentUser.setUsername(username);
            MainChat.displayMainChat(currentUser);
        }else printRed(LOGIN_LIST.get(4));
    }

    private static void registerChat() {
        User user = new User();
        String username = wordQuestion(new Scanner(System.in), LOGIN_LIST.get(0));
        String password = wordQuestion(new Scanner(System.in), LOGIN_LIST.get(1));
        String email = wordQuestion(new Scanner(System.in), LOGIN_LIST.get(2));
        try {
            user.setUsername(AESEncryption.encrypt(username));
            user.setPassword(AESEncryption.encrypt(password));
            user.setEmail(AESEncryption.encrypt(email));
        }catch (Exception e){
            printRed(USER_LIST.get(5));
        }
        UserDao.insertUser(user);
        System.out.println(LOGIN_LIST.get(3));
    }


}
