package org.example.chat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CRUDChat extends UtilChat{
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
}
