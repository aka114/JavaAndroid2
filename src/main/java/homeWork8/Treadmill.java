package homeWork8;

public class Treadmill implements Challenge {
    private int length;
    @Override
    public boolean completed(Participant participant) {
        if(participant.getMaxDistance() >= length) {
            System.out.println(participant + " пробежал дистанцию " + length + "м.");
            return true;
        }
        System.out.println(participant + " не смог пробежать дистанцию " + length + "м.");
        participant.setLost();
        return false;
    }

    public Treadmill(int length) {
        this.length = length;
    }
}
