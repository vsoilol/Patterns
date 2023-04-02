package org.example;

import org.example.enumns.CrustType;
import org.example.enumns.Size;
import org.example.enumns.Topping;

import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder implements Builder<Pizza> {
    private Size size;
    private CrustType crustType;
    private final List<Topping> toppings;

    public PizzaBuilder() {
        this.toppings = new ArrayList<>();
    }

    public PizzaBuilder withSize(Size size) {
        this.size = size;
        return this;
    }

    public PizzaBuilder withCrustType(CrustType crustType) {
        this.crustType = crustType;
        return this;
    }

    public PizzaBuilder withTopping(Topping topping) {
        this.toppings.add(topping);
        return this;
    }

    public Pizza build() throws IllegalArgumentException{
        if (size == null) {
            throw new IllegalStateException("Pizza size cannot be null");
        }

        if (crustType == null) {
            throw new IllegalStateException("Pizza crust type cannot be null");
        }

        return new Pizza(size, crustType, toppings.toArray(new Topping[0]));
    }
}
