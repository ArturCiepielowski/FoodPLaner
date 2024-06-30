package org.example;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Na ile dni chcesz zaplanować obiad? \n");
        Scanner sc = new Scanner(System.in);
        int amountOfDays = sc.nextInt();
        Food todayFood = new Food(amountOfDays);
    }
}