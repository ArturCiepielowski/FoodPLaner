package org.example;

import java.util.Scanner;

public class Chat {
    public Chat() {
    }

    protected String wordQuestion(Scanner sc,String question){
        System.out.println(question);
        return sc.next();
    }
    protected int numberQuestion(Scanner sc,String question){
        System.out.println(question);
        return sc.nextInt();
    }
}
