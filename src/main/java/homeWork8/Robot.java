package homeWork8;

public class Robot implements Participant{

    String serialNumber;
    private int maxDistance;
    private int maxJumpHeight;
    private boolean lost = false;

    @Override
    public void run() {
        System.out.println("Робот бегает");
    }

    @Override
    public void jump() {
        System.out.println("Робот прыгает");
    }

    @Override
    public int getMaxDistance() {
        return maxDistance;
    }

    @Override
    public int getMaxHeight() {
        return maxJumpHeight;
    }

    public Robot(String serialNumber, int maxDistance, int maxJumpHeight) {
        this.serialNumber = serialNumber;
        this.maxDistance = maxDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public String toString() {
        return "Робот SN " + serialNumber;
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
