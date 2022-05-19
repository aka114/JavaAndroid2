package homeWork7;

public class Test {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Вася", 50);
        Cat cat2 = new Cat("Пушок", 70);
        Cat cat3 = new Cat(100);

        Cat[] catArr = {cat1, cat2, cat3};

        Plate plate = new Plate("Лохань", 300, 200); // чтобы не плескалось
        System.out.println(plate);

        for (Cat cat :
                catArr) {
            cat.eat(plate);
            System.out.println(cat);
        }
        plate.increaseFood(200);
        System.out.println(plate);
    }
}
