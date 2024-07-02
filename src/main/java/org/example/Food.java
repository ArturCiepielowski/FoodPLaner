package org.example;

import java.time.LocalDate;
import java.util.*;

public class Food {
    private static final HashMap<String, String[]> FOOD_MAP = new HashMap<>();
    private static final HashMap<String, String> DAYS_LIST = new HashMap<>();

    static {
        FOOD_MAP.put("Kotlety drobiowe", new String[]{"Pierś Z Kurczaka", "Przyprawa do mięs","Mąka tortowa","Bułka tarta","4xJajka","Sól","Pieprz","Olej"});
        FOOD_MAP.put("Kotlety mielone",new String[]{"Mięso mielone","Czerstwa bułka","Cebula","1xJajko","Sól","Woda/mleko"});
        FOOD_MAP.put("Spagetti Neapoli",new String[]{"Makaron","Sos Neapoli","Mozarella","Groszek","Olej","Woda"});
        FOOD_MAP.put("Spagetti Bolognese",new String[]{"Makaron","Sos Bolognese","Mozarella","Czerwona fasola","Olej","Woda"});
        FOOD_MAP.put("Chili con carne",new String[]{"placeholder","placeholder"});
        FOOD_MAP.put("Naleśniki",new String[]{"placeholder1","placeholder1"});
        FOOD_MAP.put("Pancake",new String[]{"placeholder2","placeholder2"});
        FOOD_MAP.put("Pizza",new String[]{"placeholder3","placeholder3"});
        FOOD_MAP.put("Pulpety",new String[]{"placeholder4","placeholder4"});
        FOOD_MAP.put("Kurczak w sosie pieczeniowym",new String[]{"placeholder5","placeholder5"});

        DAYS_LIST.put("MONDAY", "Poniedziałek");
        DAYS_LIST.put("TUESDAY", "Wtorek");
        DAYS_LIST.put("WEDNESDAY", "Środa");
        DAYS_LIST.put("THURSDAY", "Czwartek");
        DAYS_LIST.put("FRIDAY", "Piątek");
        DAYS_LIST.put("SATURDAY", "Sobota");
        DAYS_LIST.put("SUNDAY", "Niedziela");
    }

    private String foodName;
    private String foodDescription;
    private List<Ingredients> ingredientsList;

    public Food(int amountOfDays) {
        LocalDate today = LocalDate.now();
        for (int dayOfWeek = 0; dayOfWeek < amountOfDays; dayOfWeek++) {
            LocalDate nextDays = today.plusDays(dayOfWeek);
            String chosenFood = getRandomFood();
            System.out.println(nextDays + " " + getTodayName(nextDays) + ": " + chosenFood);
            //todo stworzyc dodatkowy czat pytajacy sie czy wypisac liste zakupow
//            System.out.println(Arrays.toString(FOOD_MAP.get(chosenFood)));
        }
    }

    private String getRandomFood() {
        List<String> dishList = new ArrayList<>(FOOD_MAP.keySet());
        Random randomFood = new Random();
        int randomIndex = randomFood.nextInt(dishList.size());
        return dishList.get(randomIndex);
    }

    private String getTodayName(LocalDate nextDays) {
        String dayOfWeek = nextDays.getDayOfWeek().toString();
        return DAYS_LIST.get(dayOfWeek);
    }

}
