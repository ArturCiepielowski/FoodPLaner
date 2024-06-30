package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Food {
    private static final HashMap<Integer, String> FOOD_MAP = new HashMap<>();
    private static final HashMap<String, String> DAYS_LIST = new HashMap<>();

    static {
        FOOD_MAP.put(1, "Kotlety drobiowe");
        FOOD_MAP.put(2, "Kotlety mielone");
        FOOD_MAP.put(3, "Spagetti Neapoli");
        FOOD_MAP.put(4, "Spagetti Bolognese");
        FOOD_MAP.put(5, "Chili con carne");
        FOOD_MAP.put(6, "Naleśniki");
        FOOD_MAP.put(7, "Pancake");
        FOOD_MAP.put(8, "Pizza");
        FOOD_MAP.put(9, "Pulpety");
        FOOD_MAP.put(10, "Kurczak w sosie pieczeniowym");

        DAYS_LIST.put("MONDAY", "Poniedziałek");
        DAYS_LIST.put("TUESDAY", "Wtorek");
        DAYS_LIST.put("WEDNESDAY", "Środa");
        DAYS_LIST.put("THURSDAY", "Czwartek");
        DAYS_LIST.put("FRIDAY", "Piątek");
        DAYS_LIST.put("SATURDAY", "Sobota");
        DAYS_LIST.put("SUNDAY", "Niedziela");
    }

    private String getRandomFood() {
        Random randomFood = new Random();
        return FOOD_MAP.get(randomFood.nextInt(10) + 1);
    }

    private String getTodayName(int additionalDay) {
        LocalDateTime today = LocalDateTime.now();
        String dayOfWeek = today.plusDays(additionalDay).getDayOfWeek().toString();
        return DAYS_LIST.get(dayOfWeek);
    }

    public Food() {
        for (int dayOfWeek = 0; dayOfWeek < 7; dayOfWeek++) {
            System.out.println(getTodayName(dayOfWeek)+": "+getRandomFood());
        }
    }

}
