package lesson8.part2;

public class Cat {
    private Color color;

    class InnerClass {


    }
    static class StaticInnerClass {

    }

    public Cat(Color color) {
/*
        class MLClass {

        }

        MLClass mlClass = new MLClass();
*/

        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + color.getRussianColor() + '\'' +
                '}';
    }
}
