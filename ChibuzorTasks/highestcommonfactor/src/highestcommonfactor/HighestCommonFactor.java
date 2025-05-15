package highestcommonfactor;

public class HighestCommonFactor {

    public static int findHCF(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
            return a;
    }

    public static int findHCFVariableLength(int... numbers) {
        int hcf = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            hcf = findHCF(hcf, numbers[i]);
        }
        return hcf;
    }

}
