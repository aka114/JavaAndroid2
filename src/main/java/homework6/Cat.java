package homework6;

public class Cat extends Animal {

    public static int catCounter = 0;

    public Cat() {
        run = 200;
        swim = 0;
        catCounter++;
    }

    public Cat(String name, int run) {
        this.name = name;
        this.run = run;
        this.swim = 0;
        catCounter++;
    }

}
