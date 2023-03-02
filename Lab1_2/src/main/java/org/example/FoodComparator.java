package org.example;

import java.util.Comparator;

public class FoodComparator implements Comparator<Food> {
    @Override
    public int compare(Food o1, Food o2) {
        var o1Parameter = o1.getAdditionalParameter();
        var o2Parameter = o2.getAdditionalParameter();

        return o2Parameter.compareTo(o1Parameter);
    }
}
