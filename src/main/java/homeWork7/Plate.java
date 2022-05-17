package homeWork7;

public class Plate {
    int volume;
    String name = "Миска";
    int foodAmount = volume;

    public Plate(String name, int volume,int foodAmount) {
        this.name = name;
        this.volume = volume;
        this.foodAmount = Math.min(volume, foodAmount);
    }

    public Plate(int volume,int foodAmount) {
        this.volume = volume;
        this.foodAmount = Math.min(volume, foodAmount);
    }

    public Plate(String name, int volume) {
        this.name = name;
        this.volume = volume;
        this.foodAmount = Math.min(volume, foodAmount);
    }

    public Plate(int volume) {
        this.name = "Миска";
        this.volume = volume;
        this.foodAmount = Math.min(volume, foodAmount);
    }

    public void decreaseFood(int piece) {
        foodAmount -= Math.min(piece, foodAmount);
    }

    public void increaseFood(int piece) {
        foodAmount += Math.min(piece, volume - foodAmount);
    }

    @Override
    public String toString() {
        return "Plate{" +
                "name=" + name +
                ", volume='" + volume + '\'' +
                ", foodAmount=" + foodAmount +
                '}';
    }
}
