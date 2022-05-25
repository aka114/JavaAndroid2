package homeWork9;

public class MyArraySizeExeption extends Exception {
    public MyArraySizeExeption() {
        super("Размер массива отличается от ожидаемого");
    }
    public MyArraySizeExeption(String message) {
            super(message);
    }
}
