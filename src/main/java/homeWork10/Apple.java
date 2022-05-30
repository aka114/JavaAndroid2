package homeWork10;

import java.lang.ref.SoftReference;

public class Apple extends Fruit implements TrueFruit {

    public double weight = 1.0;
    public Apple(){

    }

    public Apple(String name) {
        this.name = name;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
