package homeWork8;

public class Human implements Participant {

    String name;
    private int maxDistance;
    private int maxJumpHeight;
    private boolean lost = false;

    @Override
    public void run() {
        System.out.println("Человек бегает");
    }

    @Override
    public void jump() {
        System.out.println("Человек прыгает");
    }

    @Override
    public int getMaxDistance() {
        return maxDistance;
    }

    @Override
    public int getMaxHeight() {
        return maxJumpHeight;
    }

    public Human(String name, int maxDistance, int maxJumpHeight) {
        this.name = name;
        this.maxDistance = maxDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public String toString() {
        return "Человек " + name;
    }

    @Override
    public boolean isLost() {
        return lost;
    }

    @Override
    public void setLost() {
        this.lost = true;
    }
}
