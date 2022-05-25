package homeWork8;

public class Wall implements Challenge {

    private int height;
    @Override
    public boolean completed(Participant participant) {
        if(participant.getMaxHeight() >= height) {
            System.out.println(participant + " перепрыгнул препятствие " + height + "м.");
            return true;
        }
        System.out.println(participant + " не смог перепрыгнуть препятствие " + height + "м.");
        participant.setLost();
        return false;
    }

    public Wall(int height) {
        this.height = height;
    }
}
