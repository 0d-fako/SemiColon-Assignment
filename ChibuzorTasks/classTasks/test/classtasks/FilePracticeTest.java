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
        assertThrows( IllegalArgumentException.class, () -> FilePractice.createFile(filePath));
    }

    @Test
    void testThatDuplicateFileNameThrowsException () {
        FilePractice.createFile("path");
        assertThrows( IllegalArgumentException.class, () -> FilePractice.createFile("path"));
    }

    @Test
    void testThatWriteToAFileIfFilePathDoesNotExistThrowsException () {
        assertThrows( IllegalArgumentException.class, () -> FilePractice.writeToFile(filePath, "Ifeanyi Weds Onyinye"));
    }


    @Test
    void testThatWriteToAFileWithValidFilePathAndContentShouldBe(){
        FilePractice.createFile("path");
        String word = "Hello World";
        FilePractice.writeToFile(word, path);
        String content = FilePractice.getContentInFile("path");

    }




}
