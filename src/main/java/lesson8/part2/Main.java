package lesson8.part2;

public class Main {
    public static void main(String[] args) {
//        testEnum();
        testEnum();
    }

    private static void testAnonClass() {

    }

    private static void testEnum() {

/*
        Cat cat = new Cat(Color.BLACK);
        System.out.println(cat);
*/
        /*PrintHello hello1 = new WorldHello();
        PrintHello hello2 = new GBHello();*/

        PrintHello hello1 = new PrintHello() {
            @Override
            public void printHello() {
                System.out.println("Привет, ГБ 2");
            }
        };

        hello1.printHello();
//        hello2.printHello();

    }
}
