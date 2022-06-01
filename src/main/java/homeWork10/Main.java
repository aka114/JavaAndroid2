package homeWork10;

import lesson10.E;

import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {

        Box<Apple> box1 = new Box<>();
        Box<Orange> box2 = new Box<>();
        Box<Apple> box3 = new Box<>();

        Apple apple1 = new Apple("Красное");
        Apple apple2 = new Apple("Зеленое");
        Apple apple3 = new Apple("Желтое");
        Apple apple4 = new Apple("Желтое");

        //Apple[] arr= {apple4};

        Orange orange1 = new Orange("Спелый");
        Orange orange2 = new Orange("Кислый");
        Orange orange3 = new Orange("Гнилой");
        box1.addFruit(apple1);
        box1.addFruit(apple2);
        //box1.addFruit(orange3);

        box2.addFruit(orange1);
        box2.addFruit(orange2);
        //box2.addFruit(apple3);

        box3.addFruit(apple3);
        box3.addFruit(apple4);

        swapElements(box1.content, 0, 1);

        System.out.println(box1.getWeight());
        System.out.println(box2.getWeight());
        System.out.println(box3.getWeight());
        System.out.println(box1.compare(box2));

        box1.transfer(box3);
        System.out.println(box1.getWeight());
        System.out.println(box3.getWeight());
        box3.transfer(box1);
        System.out.println(box1.getWeight());
        System.out.println(box3.getWeight());
    }

    public static void swapElements (Object[] arr, int index0, int index1) {
        Object index0Value = arr[index0];
        arr[index0] = arr[index1];
        arr[index1] = index0Value;
    }

}
