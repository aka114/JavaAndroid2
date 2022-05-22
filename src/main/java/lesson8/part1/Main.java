package lesson8.part1;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Duck duck = new Duck();
        Plane plane = new Plane();
        Wolf wolf = new Wolf();

        test(cat);
        test(dog);
        test(duck);
        test(wolf);
//        test(plane);

        Flying[] flyings = {duck, plane};

    }

    private static void test(Runner runner) {
        runner.run();
    }
}
