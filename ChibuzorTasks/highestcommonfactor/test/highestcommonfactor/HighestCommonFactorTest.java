package highestcommonfactor;

import static highestcommonfactor.HighestCommonFactor.findHCF;
import static highestcommonfactor.HighestCommonFactor.findHCFVariableLength;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class HighestCommonFactorTest {
    @Test
    public void testFindHCFVariableLength(){
        assertEquals(10, findHCFVariableLength(20,10,30,40,50));
        assertEquals(12, findHCFVariableLength(24, 36));
        assertEquals(30, findHCFVariableLength(60, 30, 90));
        assertEquals(14, findHCFVariableLength(14, 28));
        assertEquals(1, findHCFVariableLength(8,9,18));
    }
}





