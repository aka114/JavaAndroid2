package homework12;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        testSingleThread();
        testMultiThread();

    }

    private static final int SIZE = 10;

    private static void testSingleThread() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        long timeStamp = System.currentTimeMillis();
        processArray(arr, 0);

        System.out.println(Arrays.toString(arr));
        System.out.printf("Time for single thread %d ms%n", System.currentTimeMillis() - timeStamp);
    }

    private static void testMultiThread() throws InterruptedException {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        long timeStamp = System.currentTimeMillis();
        float[] arr1 = new float[SIZE/2];
        float[] arr2 = new float[SIZE/2];

        System.arraycopy(arr, 0, arr1, 0, arr1.length);
        System.arraycopy(arr, arr2.length, arr2, 0, arr2.length);

        Thread t1 = new Thread(() -> processArray(arr1, 0));
        Thread t2 = new Thread(() -> processArray(arr2, arr2.length));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.arraycopy(arr1, 0, arr, 0, arr1.length);
        System.arraycopy(arr2, 0, arr, arr2.length, arr2.length);
        System.out.println(Arrays.toString(arr));
        System.out.printf("Time for double thread %d ms%n", System.currentTimeMillis() - timeStamp);
    }

    private static void processArray(float[] arr, int bias) {
        int j;
        for (int i = 0; i < arr.length; i++) {
            j = i + bias;
            arr[i] = (float) (arr[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) *
                    Math.cos(0.4f + j / 2));
        }
    }

}
