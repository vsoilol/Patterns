package org.example;

import org.example.enumns.CrustType;
import org.example.enumns.Size;
import org.example.enumns.Topping;

public class Pizza {
    private final Size size;
    private final CrustType crustType;
    private final Topping[] toppings;

    public Pizza(Size size, CrustType crustType, Topping[] toppings) {
        this.size = size;
        this.crustType = crustType;
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pizza: ");
        sb.append(size).append(" size, ");
        sb.append(crustType).append(" crust");

        if (toppings.length > 0) {
            sb.append(", with ");

            for (int i = 0; i < toppings.length; i++) {
                sb.append(toppings[i]);

                if (i != toppings.length - 1) {
                    sb.append(", ");
                }
            }
        }
        return sb.toString();
    }
}
