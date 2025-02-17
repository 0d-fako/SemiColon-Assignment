package turtle;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

public class SevenSegmentDisplayTest {
    private SevenSegmentDisplay sevenSegmentDisplay;


    @BeforeEach
    public void setUp() {
        sevenSegmentDisplay = new SevenSegmentDisplay();
    }


    @Test
    public void inputStringMustLongerThanEightLettersShouldThrowExceptionTest() {
        String binaryLetters = "111111111";
        assertThrows(IllegalArgumentException.class,()-> sevenSegmentDisplay.validateInputLength(binaryLetters));

    }

    @Test
    public void inputStringMustLesserThanEightLettersShouldThrowExceptionTest(){
        String binaryLetters = "111111";
        assertThrows(IllegalArgumentException.class,()-> sevenSegmentDisplay.validateInputLength(binaryLetters));
    }


    @Test
    public void lastDigitToTurnOnOrOffDisplayTest(){
        String binaryLetters = "11111111";
        assertTrue(sevenSegmentDisplay.isOn(binaryLetters));
        binaryLetters = "11111110";
        assertFalse(sevenSegmentDisplay.isOn(binaryLetters));
    }

    @Test
    public void convertStringToArrayOfIntegersTest() {
        String binaryLetters = "11111111";
        int[] convertedArray = sevenSegmentDisplay.convertStringToArrayOfIntegers(binaryLetters);
        int[] result = {1,1,1,1,1,1,1};
        assertArrayEquals(result, convertedArray );
    }

}
