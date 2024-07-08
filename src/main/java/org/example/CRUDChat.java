package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CRUDChat {
    private static final List<String> QUESTION_LIST =new ArrayList<>();

    static {
        QUESTION_LIST.add("Co chcesz zrobić:\n 1.Zapisac nowe danie?\n 2.Wczytać konkretne danie?");
        QUESTION_LIST.add("Na ile dni chcesz zaplanować obiad? \n");
        QUESTION_LIST.add("Niepoprawna odpowiedź. Przerywam działanie programu.");
    }

    public CRUDChat() {
        Scanner sc = new Scanner(System.in);
        int firstChoice = numberQuestion(sc, QUESTION_LIST.get(0));
        if (firstChoice != 1 && firstChoice != 2)
            System.out.println(QUESTION_LIST.get(2));
    }

    private String wordQuestion(Scanner sc,String question){
        System.out.println(question);
        return sc.next();
    }
    private int numberQuestion(Scanner sc,String question){
        System.out.println(question);
        return sc.nextInt();
    }
}
