package lesson8.part1;

public class Cat extends Animal implements Runner, Jumper {

    @Override
    public void run() {
        System.out.println("Cat run");
    }

    @Override
    public void jump() {
        System.out.println("Cat jump");
    }
}
