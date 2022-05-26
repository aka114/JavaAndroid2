package homeWork9;

public class MyArrayDataExeption extends Exception {
    public MyArrayDataExeption(int row, int col) {
        super(String.format("Недопустимый символ в строке %s колонке %s", row, col));
    }
}
