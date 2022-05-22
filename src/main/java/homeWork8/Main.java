package homeWork8;

public class Main {
    public static void main(String[] args) {

        Participant participant1 = new Human("Петя", 3000, 1);
        Participant participant2 = new Robot("478587", 10000, 6);
        Participant participant3 = new Cat("Пушок", 1000, 2);

        Participant[] partArr = {participant1, participant2, participant3};

        Challenge challenge1 = new Treadmill(3000);
        Challenge challenge2 = new Wall(2);
        Challenge[] challArr = {challenge1, challenge2};

        for (Challenge challenge: challArr) {
            for (Participant participant: partArr) {
                if (!participant.isLost() && !challenge.completed(participant)) {
                    System.out.println(participant + " выбыл из борьбы");
                }
            }
        }

    }
}
