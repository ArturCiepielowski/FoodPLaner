package org.example.chat;

import org.example.Dish.Dish;
import org.example.Dish.DishDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CRUDChat extends UtilChat {
    private static final String DISH_NOT_FOUND = "Dish not found! Please provide correct name.";
    private static final List<String> CRUD_LIST = new ArrayList<>();
    private static final List<String> EXQ_LIST = new ArrayList<>();

    static {
        CRUD_LIST.add("Please choose an action you want to take:");
        CRUD_LIST.add("1.Add dish to database");
        CRUD_LIST.add("2.Show a certain dish");
        CRUD_LIST.add("3.Edit certain dish");
        CRUD_LIST.add("4.Delete a dish");
        CRUD_LIST.add("5.Show all dishes");
        CRUD_LIST.add("6.Go back to main menu");
        CRUD_LIST.add("7.Exit program");
        CRUD_LIST.add("Exiting Foodplanner. Goodbye!");
        CRUD_LIST.add("Invalid option. Please try again.");

        EXQ_LIST.add("What is the name of Dish?");
        EXQ_LIST.add("What is the description of Dish?");
        EXQ_LIST.add("Which Dish do you want? Write name.");
        EXQ_LIST.add("What is the new name for the Dish?");
        EXQ_LIST.add("What is the new description for the Dish?");
    }

    public static void displayCRUDChat() {
        printLogo();
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            printCrudOptions();
            String crudChoice = sc.next();
            switch (crudChoice) {
                case "1" -> {
                    getDishNameAndDesc();
                    System.out.println("Dish added");
                }
                case "2" -> {
                    if (!showDish()) System.out.println(DISH_NOT_FOUND);
                    else System.out.println("Dish showed");
                }
                case "3" -> {
                    if (!editDish()) System.out.println(DISH_NOT_FOUND);
                    else System.out.println("Dish edited");
                }
                case "4" -> {
                    if (!removeDish()) System.out.println(DISH_NOT_FOUND);
                    else System.out.println("Dish removed");
                }
                case "5" -> {
                    DishDao.printAllDishes();
                    System.out.println("Showed all Dishes");
                }
                case "6" -> running = false;
                case "7" -> {
                    printRed(CRUD_LIST.get(8));
                    System.exit(0);
                }
                default -> printRed(CRUD_LIST.get(9));
            }
        }
    }

    private static void printCrudOptions() {
        printYellow(CRUD_LIST.get(0));
        for (int index = 1; index < 8; index++) {
            printBlue(CRUD_LIST.get(index));
        }
    }

    private static void getDishNameAndDesc() {
        Dish dish = new Dish();
        dish.setName(wordQuestion(new Scanner(System.in), EXQ_LIST.get(0)));
        dish.setDescription(wordQuestion(new Scanner(System.in), EXQ_LIST.get(1)));
        DishDao.insertDish(dish);
    }

    private static boolean showDish() {
        String dishId = wordQuestion(new Scanner(System.in), EXQ_LIST.get(2));
         return DishDao.selectDish(dishId);
    }

    private static boolean editDish() {
        String dishName = wordQuestion(new Scanner(System.in), EXQ_LIST.get(2));
        String newName = wordQuestion(new Scanner(System.in), EXQ_LIST.get(3));
        String newDescription = wordQuestion(new Scanner(System.in), EXQ_LIST.get(4));
        return DishDao.updateDish(dishName, newName, newDescription);
    }

    private static boolean removeDish() {
        String dishName = wordQuestion(new Scanner(System.in), EXQ_LIST.get(2));
        return DishDao.deleteDish(dishName);
    }
}
