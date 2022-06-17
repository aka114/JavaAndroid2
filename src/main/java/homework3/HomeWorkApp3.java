package homework3;

import java.util.Arrays;

public class HomeWorkApp3 {
    private static final int ARRAY_RANGE = 9;

    public static void main(String[] args) {

        // 1.
        int[] arr1 = {1, 0, 1, 1, 0, 1, 0 ,0, 1};
        invertArray(arr1);
        System.out.println(Arrays.toString(arr1));

        // 2.
        int[] arr2 = new int[100];
        fillArrayInc(arr2);
        System.out.println(Arrays.toString(arr2));

        // 3.
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplySomeElemettInArray(arr3);
        System.out.println(Arrays.toString(arr3));

        // 4.
        int[][] arr4 = new int[ARRAY_RANGE][ARRAY_RANGE];
        fillDiagonalOfArray(arr4);
        for (int[] ints : arr4) {
            System.out.println(Arrays.toString(ints));
        }

        // 5.
        int len = 10;
        int initialValue = 7;
        Integer[] arr5 = getInitializedArray(len, initialValue);
        System.out.println(Arrays.toString(arr5));

        // 6.
        int[] arr6 = {1, 5, 7, 3, 5, 8, 9, 12, 76, 3, -4, -24};
        Arrays.sort(arr6);
        int minValue = arr6[0];
        int maxValue = arr6[arr6.length - 1];
        System.out.printf("Min value %d, max value %d", minValue, maxValue);
        System.out.println();

        // 7.
//        int[] arr7 = {2, 4, 7, 3, 1, 5, 7, 5};
//        boolean isBalanced = arrayIsBalanced(arr7);
//        System.out.printf("Array is balanced - %b", isBalanced);
//        System.out.println();

        // 8.
//        int[] arr8 = {2, 5, 6, 3, 56, -4, 34, -23, 12};
//        int offset = -2;
//        System.out.println(Arrays.toString(arr8));
//        moveArrayElements(arr8, offset);
//        System.out.println(Arrays.toString(arr8));

    }

    public void moveArrayElements(int[] arr8, int offset) {

        int tempVal0 = 0;
        int tempVal1;
        int posOffset0;
        int posOffset1;
        int currentOffset = 0;
        int initialPos = 0;
        boolean newIteration = true;
        for (int i = 0; i < arr8.length; i++) {
            posOffset0 = (arr8.length + offset * i + currentOffset) % arr8.length;
            posOffset1 = (arr8.length + offset * (i + 1) + currentOffset) % arr8.length;
            if (posOffset0 < 0) {
                posOffset0 += arr8.length;
            }
            if (posOffset1 < 0)
                posOffset1 += arr8.length;

            if (posOffset0 == initialPos && i > 0) {
                currentOffset++;

                newIteration = true;

                posOffset0 = (arr8.length + offset * i + currentOffset) % arr8.length;
                posOffset1 = (arr8.length + offset * (i + 1) + currentOffset) % arr8.length;
            }
            tempVal1 = arr8[posOffset1];
            if (newIteration) {
                arr8[posOffset1] = arr8[posOffset0];
                tempVal0 = tempVal1;
                newIteration = false;
            } else {
                arr8[posOffset1] = tempVal0;
                tempVal0 = tempVal1;
            }

        }
    }

    public boolean arrayIsBalanced(int[] arr7) {

        int leftSum = 0;
        int rightSum = Arrays.stream(arr7).sum();
        for (int i : arr7) {
            leftSum += i;
            rightSum -= i;
            if (leftSum == rightSum) {
                return true;
            }
        }
        return false;
    }

    private static Integer[] getInitializedArray(int len, int initialValue) {
        Integer[] array = new Integer[len];
        Arrays.fill(array, initialValue);
        return array;
    }

    private static void fillDiagonalOfArray(int[][] arr4) {
        for (int i = 0; i < arr4.length; i++) {
            arr4[i][i] = 1;
            arr4[arr4.length - i - 1][i] = 1;
        }

    }

    private static void multiplySomeElemettInArray(int[] arr3) {
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }
    }

    private static void fillArrayInc(int[] arr2) {
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i + 1;
        }
    }

    private static void invertArray(int[] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = 1 - arr1[i];
        }
    }

    public int getValueByIndex(int[] arr, int idx) {
        return arr[idx];
    }
}
