package homeWork7;

public class Cat {
    private String name = "Дворовый";
    private int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public Cat(String name) {
        this.name = name;
        this.appetite = 10;
    }

    public Cat(int appetite) {
        this.appetite = appetite;
    }

    public Cat() {
        this.appetite = 10;
    }

    public boolean eat(Plate plate, int portion) {
        var piece = Math.min(portion, appetite);
        if (plate.foodAmount >= piece) {
            plate.decreaseFood(piece);
            appetite -= piece;
            checkSatiety();
            return true;
        }
        return false;
    }

    public void eat(Plate plate) {
        if (plate.foodAmount >= appetite) {
            plate.decreaseFood(appetite);
            appetite = 0;
            checkSatiety();
        }
    }

    private void checkSatiety() {
        satiety = appetite <= 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", satiety=" + satiety +
                '}';
    }
}
