package org.example;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Chat chat = new Chat();
        Scanner sc = new Scanner(System.in);
        int firstChoice = chat.numberQuestion(sc, "Planujesz obiad na:\n 1.Dzisiaj\n 2.Na więcej dni");
        if (firstChoice != 1 && firstChoice != 2)
            System.out.println("Niepoprawna odpowiedź. Przerywam działanie programu.");
        else {
            if (firstChoice == 1) new Food(firstChoice);
            if (firstChoice == 2) {
                int secondChoice = chat.numberQuestion(sc, "Na ile dni chcesz zaplanować obiad? \n");
                new Food(secondChoice);
            }
        }
    }
}