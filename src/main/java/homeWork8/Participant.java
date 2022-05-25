package homeWork8;

public interface Participant {

    void run();
    void jump();

    int getMaxDistance();
    int getMaxHeight();
    String toString();
    boolean isLost();
    void setLost();

}
