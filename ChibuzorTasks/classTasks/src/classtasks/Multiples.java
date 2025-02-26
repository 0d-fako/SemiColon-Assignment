package classTasks.src.classtasks;

import java.util.ArrayList;

public class Multiples {
    public ArrayList<Integer> multiples(int startingNumber, int endingNumber, int multiple) {
        ArrayList<Integer> multiples = new ArrayList<>();
        for (int i = startingNumber; i <= endingNumber; i++) {
            if (i % multiple == 0) {
                multiples.add(i);
            }
        }
        return multiples;
    }

    public int[] multiplesArray(int startingNumber, int endingNumber, int multiple) {
        int size = (endingNumber - startingNumber) / multiple + 1;
        int[] result = new int[size];
        int index = 0;

        for (int i = startingNumber; i <= endingNumber; i++) {
            if (i % multiple == 0) {
                result[index++] = i;
            }
        }
        return result;
    }

}
