package classtasks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FilePracticeTest {

    @ParameterizedTest
    @NullAndEmptySource
    void testThatCreateFileIfFilePathNullOrEmptyThrowsException (String filePath) {
        FilePractice filePractice = new FilePractice();
        assertThrows( IllegalArgumentException.class, () -> filePractice.createFile(filePath));
    }



}
