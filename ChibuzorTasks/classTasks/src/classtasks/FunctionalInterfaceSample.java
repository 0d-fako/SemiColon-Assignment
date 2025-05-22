package classtasks;

import java.util.function.BiPredicate;

public class FunctionalInterfaceSample {
    public static void main(String[] args) {


        BiPredicate<Integer, Integer> isEven = (x, y) -> x % 2 == 0;


        System.out.println(isEven.test(1, 2));


    }
}
