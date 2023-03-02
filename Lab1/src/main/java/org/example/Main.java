package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        var breakfastFoods = new ArrayList<Food>();

        for (String arg : args) {
            String[] parts = arg.split("/");

            var food = FoodFactory.getFood(parts[0], parts.length == 2 ? parts[1] : null);
            breakfastFoods.add(food);
        }

        for (Food item : breakfastFoods) {
            item.consume();
        }
        System.out.println();


        var data = getBreakfastInfoOnlyByName(breakfastFoods);

        for (var entry : data.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue());
        }

        System.out.println("\nВсего хорошего!");
    }

    private static Map<Food, Integer> getBreakfastInfoOnlyByName(List<Food> foods) {
        Map<Food, Integer> data = new HashMap<>();

        for (Food food : foods) {
            var key = data.keySet().stream().filter(i -> i.equals(food)).findFirst().orElse(null);

            if (key == null) {
                data.put(food, 1);
            } else {
                var value = data.get(key);
                data.replace(key, value + 1);
            }
        }

        return data;
    }
}