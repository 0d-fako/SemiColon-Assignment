package classtasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FilePracticeTest {

    private String path;


    @BeforeEach
    void setUp() {

    }


    @AfterEach
    void tearDown() {

    }


    @ParameterizedTest
    @NullAndEmptySource
    void testThatCreateFileIfFilePathNullOrEmptyThrowsException (String filePath) {
        FilePractice filePractice = new FilePractice();
        assertThrows( IllegalArgumentException.class, () -> filePractice.createFile(filePath));
    }

    @Test
    void testThatDuplicateFileNameThrowsException () {
        FilePractice filePractice = new FilePractice();
        assertThrows( IllegalArgumentException.class, () -> filePractice.createFile(path));
    }





}
