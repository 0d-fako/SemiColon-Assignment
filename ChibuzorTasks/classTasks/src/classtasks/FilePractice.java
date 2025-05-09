package classtasks;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilePractice {

    public static void createFile(String filePath) {
        if (filePath == null || filePath.isEmpty()) throw new IllegalArgumentException("File path cannot be null or empty");
    }

    public static File findFileByPath(String filePath) {
        Path foundPath = Paths.get(filePath);
        return Files.exists(foundPath) ? foundPath.toFile() : null;
    }

    public static void writeToFile(String filePath, String content) {

    }
}

