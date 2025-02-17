package turtle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ArrayKataTest {
    private ArrayKata arrayKata;

    @BeforeEach
    public void setUp() {
        arrayKata = new ArrayKata();
    }

    @Test
    public void testArrayKata() {
        char[][] input = {{'x', 'o', 'x'}, {'x','x','o'}, {'x','o','o'}};
        int[][] output = {{1, 0, 1}, {1, 1, 0}, {1, 0, 0}};

        int [][] result =  arrayKata.modify(input);

        Assertions.assertArrayEquals(result, output);
    }

}
