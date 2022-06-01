package homeWork10;

import java.util.Arrays;

public class Box<E extends Fruit> {

    public E[] content;

    public Box() {

    }

    public void addFruit(E fruit) {

        int addIndex;
        if (content == null) {
            content = (E[])new Fruit[1];
            addIndex = 0;
        } else {
            addIndex = content.length;
            content = Arrays.copyOf(content, addIndex + 1);
        }
        content[addIndex] = fruit;
    }
    public void emptyBox() {
        content = null;
    }

    public double getWeight() {
        double weight = 0;
        if (content == null) {
            return 0;
        }
        for (E fruit:
                content) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    public void transfer(Box box) {
        for (Fruit fruit :
                box.content) {
            this.addFruit((E)fruit);
            box.emptyBox();
        }
    }
}
