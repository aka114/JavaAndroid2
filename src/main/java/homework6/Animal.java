package homework6;

public class Animal {

    int run;
    int swim;
    String name;
    public static int animalCounter = 0;

    public Animal() {
        animalCounter++;
    }

    public boolean canSwim (int distance) {
        return swim >= distance;
    }

    public boolean canRun (int distance) {
        return run >= distance;
    }

}
