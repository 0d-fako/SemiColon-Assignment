package classtasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

public class FilePracticeTest {

    private String path;


    @BeforeEach
    void setUp() {
        path = "C:\\Users\\Dell\\Desktop\\SemiColon-Assignment\\ChibuzorTasks\\classTasks\\src\\classtasks";
    }

    @AfterEach
    void tearDown() {
        try{
            Files.deleteIfExists(Path.of(path));
        }catch (IOException err){
            System.err.println(err.getMessage());
        }
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
        assertNotNull(content);
        assertEquals(content, word);

    }

    @Test
    void  testThatWriteMessageToAFileTwiceShouldHaveTwoOutput(){

    }




}
