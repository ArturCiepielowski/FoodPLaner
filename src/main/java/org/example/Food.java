package org.example;

import java.util.HashMap;
import java.util.Random;

public class Food {
    private static final HashMap<Integer, String> FOOD_MAP = new HashMap<>();

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
    }

    private String getRandomFood() {
        Random randomFood = new Random();
        return FOOD_MAP.get(randomFood.nextInt(10)+1);
    }

    public Food() {
        System.out.println(getRandomFood());
    }

}
