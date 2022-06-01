package homeWork10;

public class Orange extends Fruit implements TrueFruit{

    public double weight = 1.5;

    public Orange() {
    }

    public Orange(String name) {
        this.name = name;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
