package org.example;

import java.util.Scanner;

public class TestClass {

    public static void main(String[] args) {
      String newst=  wordQuestion(new Scanner(System.in),"write smth");
      if(!newst.isEmpty()) System.out.println("Empty");
      if(!newst.isBlank()) System.out.println("Blank");
      if(!newst.equals("")) System.out.println("Nothing");
      if(newst==null) System.out.println("Null");
    }

    protected static String wordQuestion(Scanner sc, String question) {

        return sc.nextLine();
    }
}
