package algoritmsAndStructures.lesson1;

public class Main {
    public static void main(String[] args) {
        System.out.println(exponentiate(2, -22));
        System.out.println(exponentiateParity(2, -22));
        System.out.println(sequenceSum(0, 100));
    }

    private static int sequenceSum(int startNum, int endNum) {
        return (startNum + endNum) / 2 * (endNum - startNum + 1);
    }

    private static float exponentiateParity(float base, int exp) {
        int expCount = 1;
        int resizeExp = exp;
        while ((float)resizeExp % 2 == 0) {
            expCount *= 2;
            resizeExp /= 2;
        }
        return exponentiate(exponentiate(base, expCount), resizeExp);
    }

    private static float exponentiate(float base, int exp) {
        float result = 1;
        if (exp >= 0) {
            for (int i = 0; i < exp; i++) {
                result *= base;
            }
        } else {
            for (int i = 0; i > exp; i--) {
                result /= base;
            }
        }
        return result;
    }

}
