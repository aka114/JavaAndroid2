package lesson8.part1;

public class Wolf extends Animal implements Participant {

    @Override
    public void jump() {
        System.out.println("Wolf jump");
    }

    @Override
    public void run() {
        System.out.println("Wolf run");
    }
}
