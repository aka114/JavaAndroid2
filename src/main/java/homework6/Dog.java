package homework6;

public class Dog extends Animal {

    public static int dogCounter = 0;

    public Dog() {
        run = 500;
        swim = 10;
        dogCounter++;
    }

    public Dog(String name, int run, int swim) {
        this.name = name;
        this.run = run;
        this.swim = swim;
        dogCounter++;
    }

}
