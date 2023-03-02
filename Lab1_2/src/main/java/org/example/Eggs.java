package org.example;

public class Eggs extends Food {
    private String number;

    public Eggs(String number) {
        super("Яйца");
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object arg0) {
        if (!super.equals(arg0)) {
            return false;
        }

        if (!(arg0 instanceof Eggs)) {
            return false;
        }

        return number.equals(((Eggs) arg0).number);
    }

    @Override
    public void consume() {
        System.out.println(this + " съедено");
    }

    @Override
    public String toString() {
        return this.name + " " + number;
    }

    @Override
    public double calculateCalories() {
        return switch (number) {
            case "одно" -> 10;
            case "два" -> 20;
            case "три" -> 30;
            default -> 0;
        };
    }
}
