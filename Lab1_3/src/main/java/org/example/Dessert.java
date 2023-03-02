package org.example;

public class Dessert extends Food {
    private String component1;

    private String component2;

    public Dessert(String component1, String component2) {
        super("Десерт");
        this.component1 = component1;
        this.component2 = component2;
    }

    @Override
    public void consume() {
        System.out.println(this + " съеден");
    }

    public boolean equals(Object arg0) {
        if (!super.equals(arg0)) {
            return false;
        }

        if (!(arg0 instanceof Dessert)) {
            return false;
        }


        return component1.equals(((Dessert) arg0).component1) && component2.equals(((Dessert) arg0).component2);
    }

    @Override
    public double calculateCalories() {
        var result = 0;

        result += switch (component1) {
            case "сахар" -> 100;
            case "мёд" -> 236;
            default -> 0;
        };

        result += switch (component2) {
            case "молоко" -> 50;
            case "мука" -> 25;
            default -> 0;
        };

        return result;
    }

    @Override
    public String toString() {
        return super.toString() + " с компонентами " + component1 + ", " + component2;
    }
}
