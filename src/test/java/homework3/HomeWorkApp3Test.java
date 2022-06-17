package homework3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeWorkApp3Test {
    private static HomeWorkApp3 hw = new HomeWorkApp3();
    @Test
    void testArrayIsBalanced() {
        int[] arr = {2, 4, 7, 3, 1, 5, 7, 5};
        assertTrue(hw.arrayIsBalanced(arr));
        int[] arr1 = {20, 4, 7, 3, 1, 5, 7, 5};
        assertFalse(hw.arrayIsBalanced(arr1));
    }

    @Test
    void testGetValueByIndex() {
        int[] arr = {2, 4, 7, 3, 1, 5, 7, 5};
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> hw.getValueByIndex(arr, 25));
    }

}