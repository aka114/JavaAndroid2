package lesson8.part1;

public class Dog extends Animal implements Runner, Jumper {

    @Override
    public void jump() {
        System.out.println("Dog jump");
    }

    @Override
    public void run() {
        System.out.println("Dog run");
    }
}
