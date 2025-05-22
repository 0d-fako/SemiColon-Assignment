package classtasks;

import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.DoubleUnaryOperator;

public class FunctionalInterfaceSample {
    public static void main(String[] args) {


        BiPredicate<Integer, Integer> isEven = (x, y) -> x % 2 == 0;


        System.out.println(isEven.test(1, 2));



        BiPredicate<Long, Integer> isPreferable = (big, small) -> {
            if(big > small) return true;
            else if (big < small) return false;
            else return true;
        };


        System.out.println(isPreferable.test(1L, 2));


        DoublePredicate doublePredicate = x -> x % 2 == 0;

        System.out.println(doublePredicate.test(12.0));


        DoubleUnaryOperator doubleUnaryOperator = x -> x * 2;


        System.out.println(doubleUnaryOperator.applyAsDouble(12.0));



    }
}
