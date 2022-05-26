package homeWork9;

public class Main {
    public static void main(String[] args) {

        //String[][] arr = {{"1", "2", "6", "4"}, {"4", "3", "5", "2"}, {"5", "4", "9", "6"}, {"6", "4", "8", "7"}, {"9", "0", "5", "4"}};
        //String[][] arr = {{"jhjh", "2", "6", "4"}, {"4", "3", "5", "2"}, {"5", "4", "9", "6"}, {"6", "4", "8", "null"}};
        String[][] arr = {{"1", "2", "6", "4"}, {"4", "3", "5", "2"}, {"5", "4", "9", "6"}, {"6", "4", "8", "7"}};


        int result = testExeption(arr);
        System.out.println(result);
    }

    private static int testExeption(String[][] arr) {
        int sum = 0;
        int i;
        int j;
        try {
            if (arr.length != 4 || arr[0].length != 4) {
                sum = -999999999;
                throw new MyArraySizeExeption();
            } else {
                for (i = 0; i < arr.length; i++) {
                    for (j = 0; j < arr.length; j++) {
                        try {
                            sum += Integer.parseInt(arr[i][j]);
                        } catch (NumberFormatException e) {
                            sum = 999999999;
                            throw new MyArrayDataExeption(i, j);
                        }
                    }
                }
            }
        } catch (MyArrayDataExeption | MyArraySizeExeption e) {
            e.printStackTrace();
        } finally {
            return sum;
        }

    }
}
