package homework13;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    private ArrayList<Stage> stages;
    private volatile static Car winner;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

    public static Car getWinner() {
        return winner;
    }

    public static void setWinner(Car winner) {
        Race.winner = winner;
    }
}