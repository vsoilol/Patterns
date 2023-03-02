

public class Apple extends Food {
    // Новое внутреннее поле данных РАЗМЕР
    private String size;

    public Apple(String size) {
        // Вызвать конструктор предка, передав ему имя класса
        super("Яблоко");
        // Инициализировать размер яблока
        this.size = size;
    }

    // Переопределить способ употребления яблока
    public void consume() {
        System.out.println(this + " съедено");
    }

    // Селектор для доступа к полю данных РАЗМЕР
    public String getSize() {
        return size;
    }

    // Модификатор для изменения поля данных РАЗМЕР
    public void setSize(String size) {
        this.size = size;
    }

    // Переопределѐнная версия метода equals(), которая при сравнении
    // учитывает не только поле name (Шаг 1), но и проверяет совместимость
    // типов (Шаг 2) и совпадение размеров (Шаг 3)
    public boolean equals(Object arg0) {
        if (!super.equals(arg0)) {
            return false;
        }

        if (!(arg0 instanceof Apple)) {
            return false;
        }

        return size.equals(((Apple) arg0).size);
    }

    public String toString() {
        return super.toString() + " размера '" + size.toUpperCase() + "'";
    }

    @Override
    public double calculateCalories() {
        return switch (size) {
            case "большое" -> 50;
            case "маленькое" -> 25;
            default -> 0;
        };
    }
}
