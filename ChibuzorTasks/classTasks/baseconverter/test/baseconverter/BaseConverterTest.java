package baseconverter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class BaseConverterTest {

    @Test
    public void baseConverterForDecimalTest() {
        int numberToConvert = 110;
        int newBase  = 10;
        int convertedInterger = 6;
        int currentBase = 2;
        BaseConverter converter = new BaseConverter();

        int ExpectedResult = converter.baseConverter(newBase, numberToConvert, currentBase);
        assertEquals(convertedInterger, ExpectedResult);

    }

    @Test
    public void baseConverterForOctalTest() {
        int numberToConvert = 10;
        int newBase  = 8;
        int convertedInterger = 3;
        int currentBase = 2;
        BaseConverter converter = new BaseConverter();

        int ExpectedResult = converter.baseConverter(newBase, numberToConvert, currentBase);
        assertEquals(convertedInterger, ExpectedResult);
        }


}
