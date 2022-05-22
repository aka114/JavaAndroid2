package homeWork8;

public class Cat implements Participant{

    String name;
    private int maxDistance;
    private int maxJumpHeight;
    private boolean lost = false;

    @Override
    public void run() {
        System.out.println("Кот бегает");
    }

    @Override
    public void jump() {
        System.out.println("Кот прыгает");
    }

    @Override
    public int getMaxDistance() {
        return maxDistance;
    }

    @Override
    public int getMaxHeight() {
        return maxJumpHeight;
    }

    public Cat(String name, int maxDistance, int maxJumpHeight) {
        this.name = name;
        this.maxDistance = maxDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public String toString() {
        return "Кот " + name;
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
