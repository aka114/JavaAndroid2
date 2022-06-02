package algoritmsAndStructures.lesson2;

public class Main {
    public static void main(String[] args) {
        MyArray arr = new MyArray(new int[]{5,3,7,2,8,6,1,9,4});
        arr.display();
        arr.append(10);
        arr.display();
        arr.delete(3);
        arr.display();
        arr.insert(0, 3);
        arr.insert(2, 3);
        arr.display();
        arr.deleteAll(3);
        arr.display();

        arr = new MyArray(new int[]{5,3,7,2,8,6,1,9,4});
        System.out.println("Bubble iter nubmer: " + arr.sortBubble());
        arr.display();

        arr = new MyArray(new int[]{5,3,7,2,8,6,1,9,4});
        System.out.println("Bubble imp iter nubmer: " + arr.sortBubbleImproved());
        arr.display();

        arr = new MyArray(new int[]{5,3,7,2,8,6,1,9,4});
        System.out.println("Select iter nubmer: " + arr.sortSelect());
        arr.display();

        arr = new MyArray(new int[]{5,3,7,2,8,6,1,9,4});
        System.out.println("Insert iter nubmer: " + arr.sortInsert());
        arr.display();

        arr = new MyArray(new int[]{5,3,7,2,8,6,1,9,4});
        System.out.println("Insert iter nubmer: " + arr.sortByCounting());
        arr.display();

    }
}
