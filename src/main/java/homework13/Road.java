package homework13;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        Lock lock = new ReentrantLock();
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
            if (c.race.getWinner() == null && c.race.getStages().indexOf(this) == c.race.getStages().size() - 1) {
                lock.lock();
                c.race.setWinner(c);
                System.out.println(c.getName() + " победил в гонке!");
                lock.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
