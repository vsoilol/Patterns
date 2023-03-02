import java.util.*;

public class Main {
    public static void main(String[] args) {
        var breakfastFoods = new ArrayList<Food>();

        var comparator = new Comparator<Food>() {
            public int compare(Food o1, Food o2) {
                var o1ParametersCount = o1.getAdditionalParametersCount();
                var o2ParametersCount = o2.getAdditionalParametersCount();

                return Integer.compare(o2ParametersCount, o1ParametersCount);
            }
        };

        try {
            for (String arg : args) {
                String[] parts = arg.split("/");

                if (arg.equals("-calories")) {
                    System.out.println("Количество каллорий в завтраке: " + calculateBreakfastCalories(breakfastFoods) + "\n");
                    continue;
                }

                if (arg.equals("-sort")) {
                    breakfastFoods.sort(comparator);
                    continue;
                }


                var food = FoodFactory.getFood(parts[0], Arrays.stream(parts).skip(1).toArray(String[]::new));
                breakfastFoods.add(food);
            }

            for (Food item : breakfastFoods) {
                item.consume();
            }
            System.out.println();


            var data = getBreakfastInfo(breakfastFoods);

            for (var entry : data.entrySet()) {
                System.out.println(entry.getKey().toString() + ": " + entry.getValue());
            }

            System.out.println("\nВсего хорошего!");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static Map<Food, Integer> getBreakfastInfo(List<Food> foods) {
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

    private static double calculateBreakfastCalories(List<Food> foods) {
        return foods.stream().mapToDouble(Nutritious::calculateCalories).sum();
    }
}