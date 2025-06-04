package baseconverter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseConverterTest {

    @Test
    public void baseConverterTest() {
        int numberToConvert = 111111;
        int base  = 10;

        BaseConverter converter = new BaseConverter();

        converter.baseConverter(base, numberToConvert);


    }
}
