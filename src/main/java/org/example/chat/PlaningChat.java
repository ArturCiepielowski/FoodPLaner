package org.example.chat;

import org.example.Dish;
import org.example.DishDao;
import org.example.Food;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PlaningChat extends UtilChat {
    private static final List<String> QUESTION_LIST = new ArrayList<>();

    static {
        QUESTION_LIST.add("Please choose an option:");
        QUESTION_LIST.add("1.Generate dish idea for today.");
        QUESTION_LIST.add("2.Generate dish ideas for more days.");
        QUESTION_LIST.add("3.Go back to main menu");
        QUESTION_LIST.add("4.Exit program");
        QUESTION_LIST.add("For how many days you want to plan?");
        QUESTION_LIST.add("Invalid option. Please try again.");
        QUESTION_LIST.add("Exiting Foodplanner. Goodbye!");
    }

    public PlaningChat() {
        printLogo();
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            clearConsole();
            printQuestions();
            String crudChoice = sc.next();
            switch (crudChoice) {
                case "1":
                    generateFood(1);
                    break;
                case "2":
                    int daysNumber = numberQuestion(new Scanner(System.in), QUESTION_LIST.get(5));
                    generateFood(daysNumber);
                    break;
                case "3":
                    running = false;
                    break;
                case "4":
                    printRed(QUESTION_LIST.get(7));
                    System.exit(0);
                    break;
                default:
                    printRed(QUESTION_LIST.get(6));
            }
        }
    }

    private void printQuestions() {
        printYellow(QUESTION_LIST.get(0));
        for (int index = 1; index < 5; index++) {
            printBlue(QUESTION_LIST.get(index));
        }
    }

    public void generateFood(int amountOfDays) {
        LocalDate today = LocalDate.now();
        for (int dayOfWeek = 0; dayOfWeek < amountOfDays; dayOfWeek++) {
            LocalDate nextDays = today.plusDays(dayOfWeek);
            Dish chosenFood = getRandomFood();
            System.out.println(nextDays + " " + nextDays.getDayOfWeek().toString() + ": " + chosenFood.getName());
            //todo stworzyc dodatkowy czat pytajacy sie czy wypisac liste zakupow
//            System.out.println(Arrays.toString(FOOD_MAP.get(chosenFood)));
        }
    }

    private Dish getRandomFood() {
        DishDao dishDao = new DishDao();
        SessionFactory sessionFactory = dishDao.setUp();
        List<Dish> dishList = dishDao.listAllDishes();
        Random randomFood = new Random();
        int randomIndex = randomFood.nextInt(dishList.size());
        sessionFactory.close();
        return dishList.get(randomIndex);
    }
}
