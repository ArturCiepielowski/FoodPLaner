package org.example.chat;

import org.example.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlaningChat extends UtilChat{
    private static final List<String> QUESTION_LIST =new ArrayList<>();

    static {
        QUESTION_LIST.add("Planujesz obiad na:\n 1.Dzisiaj\n 2.Na więcej dni");
        QUESTION_LIST.add("Na ile dni chcesz zaplanować obiad? \n");
        QUESTION_LIST.add("Niepoprawna odpowiedź. Przerywam działanie programu.");
    }
    public PlaningChat() {
        Scanner sc = new Scanner(System.in);
        int firstChoice = numberQuestion(sc, QUESTION_LIST.get(0));
        if (firstChoice != 1 && firstChoice != 2)
            System.out.println(QUESTION_LIST.get(2));
        else {
            if (firstChoice == 1) new Food(firstChoice);
            if (firstChoice == 2) {
                int secondChoice = numberQuestion(sc, QUESTION_LIST.get(1));
                new Food(secondChoice);
            }
        }
    }

}
