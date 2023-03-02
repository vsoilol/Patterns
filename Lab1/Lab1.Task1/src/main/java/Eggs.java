public class Eggs extends Food{
    private String number;

    public Eggs(String number) {
        super("Яйца");
        this.number = number;
    }

    @Override
    public void consume() {
        System.out.println(this + " съедено");
    }

    @Override
    public String toString() {
        return this.name + " " + number;
    }
}