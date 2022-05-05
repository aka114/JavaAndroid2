package homework6;

public class homework6_test {

    public static void main(String[] args) {

        Cat cat1 = new Cat("Вася", 500);
        Cat cat2 = new Cat("Пушок", 300);
        Dog dog = new Dog("Шарик", 700, 100);

        System.out.printf("Общее количество животных - %d\n", Animal.animalCounter);
        System.out.printf("Из них котов - %d\n", Cat.catCounter);
        System.out.printf("Из них собак - %d\n", Dog.dogCounter);
        System.out.println(cat1.canSwim(1000));
        System.out.println(dog.canSwim(5));
    }
}
