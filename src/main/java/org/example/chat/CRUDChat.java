package org.example.chat;

import org.example.Dish;
import org.example.DishDao;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CRUDChat extends UtilChat {
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
        EXQ_LIST.add("Which Dish do you want? Write ID.");
        EXQ_LIST.add("What is the new name for the Dish?");
        EXQ_LIST.add("What is the new description for the Dish?");
    }

    public CRUDChat() {
        printLogo();
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            clearConsole();
            printCrudOptions();
            String crudChoice = sc.next();
            switch (crudChoice) {
                case "1":
                    addDish();
                    System.out.println("Dish added");
                    break;
                case "2":
                    showDish();
                    System.out.println("Showed Dish");
                    break;
                case "3":
                    editDish();
                    System.out.println("Edited Dish");
                    break;
                case "4":
                    removeDish();
                    System.out.println("Deleted Dish");
                    break;
                case "5":
                    printAll();
                    System.out.println("Showed all Dishes");
                    break;
                case "6":
                    running = false;
                    break;
                case "7":
                    printRed(CRUD_LIST.get(8));
                    System.exit(0);
                    break;
                default:
                    printRed(CRUD_LIST.get(9));
            }
        }
    }

    private void printCrudOptions() {
        printYellow(CRUD_LIST.get(0));
        for (int index = 1; index < 8; index++) {
            printBlue(CRUD_LIST.get(index));
        }
    }

    private void addDish() {
        String dishName = wordQuestion(new Scanner(System.in), EXQ_LIST.get(0));
        String dishDesc = wordQuestion(new Scanner(System.in), EXQ_LIST.get(1));
        insertDish(dishName, dishDesc);
    }

    private void insertDish(String dishName, String dishDesc) {
        Dish newDish = new Dish();
        newDish.setName(dishName);
        newDish.setDescription(dishDesc);
        DishDao dishDao = new DishDao();
        SessionFactory sessionFactory = dishDao.setUp();
        dishDao.create(newDish);
        sessionFactory.close();
    }

    private void showDish() {
        String dishId = wordQuestion(new Scanner(System.in), EXQ_LIST.get(2));
        selectDish(dishId);
    }

    private void selectDish(String Id) {
        DishDao dishDao = new DishDao();
        SessionFactory sessionFactory = dishDao.setUp();
        Long dishId = Long.parseLong(Id);
        Dish dish = dishDao.read(dishId);
        printPurple("Dish name: " + dish.getName());
        printPurple("Dish description: " + dish.getDescription());
        sessionFactory.close();
    }

    private void editDish() {
        String dishId = wordQuestion(new Scanner(System.in), EXQ_LIST.get(2));
        String newName = wordQuestion(new Scanner(System.in), EXQ_LIST.get(3));
        String newDescription = wordQuestion(new Scanner(System.in), EXQ_LIST.get(4));
        updateDish(dishId, newName, newDescription);
    }

    private void updateDish(String dishId, String newName, String newDescription){
        DishDao dishDao = new DishDao();
        SessionFactory sessionFactory = dishDao.setUp();
        Long parsedDishId = Long.parseLong(dishId);
        Dish existingDish = dishDao.read(parsedDishId);
        if (newName != null&&!newName.isEmpty()) existingDish.setName(newName);
        if(newDescription!=null&&!newDescription.isEmpty()) existingDish.setDescription(newDescription);
        dishDao.update(existingDish);
        sessionFactory.close();
    }

    private void removeDish() {
        String dishId = wordQuestion(new Scanner(System.in), EXQ_LIST.get(2));
        deleteDish(dishId);
    }
    private void deleteDish(String dishId) {
        DishDao dishDao = new DishDao();
        SessionFactory sessionFactory = dishDao.setUp();
        Long parsedDishId = Long.parseLong(dishId);
        Dish existingDish = dishDao.read(parsedDishId);
        dishDao.delete(existingDish);
        sessionFactory.close();
    }

    private void printAll() {
        DishDao dishDao = new DishDao();
        SessionFactory sessionFactory = dishDao.setUp();
        List<Dish> dishList = dishDao.listAllDishes();
        for(Dish nextDish:dishList){
            System.out.println(nextDish.toString());
        }
        sessionFactory.close();
    }
}
