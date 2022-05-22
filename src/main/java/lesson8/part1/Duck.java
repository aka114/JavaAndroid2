package lesson8.part1;

public class Duck extends Animal implements Flying, Runner, Jumper {

    @Override
    public void fly() {
        System.out.println("Duck fly");
    }

    @Override
    public void jump() {
        System.out.println("Duck jump");
    }

    @Override
    public void run() {
        System.out.println("Duck run");
    }
}
