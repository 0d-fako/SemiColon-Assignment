package classtasks;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilePractice {

    public static void createFile(String filePath) {
        try {
            if (filePath == null || filePath.isEmpty()) throw new IllegalArgumentException("File path cannot be null or empty");
            URI uri = Path.of()
            if (Files.exists(Paths.get(filePath))) throw new IllegalArgumentException("File already exists");
        } catch ( IOException e){
            e.printStackTrace();


        }
        ;
    }

    public static File findFileByPath(String filePath) {
        Path foundPath = Paths.get(filePath);
        return Files.exists(foundPath) ? foundPath.toFile() : null;
    }

    public static void writeToFile(String filePath, String content) {
       try {
           if (filePath == null || filePath.isEmpty())
               throw new IllegalArgumentException("File path cannot be null or empty");
           if (content == null || content.isEmpty())
               throw new IllegalArgumentException("File content cannot be null or empty");
           getValidUri(filePath);
           Path path = Path.of(filePath);
           if (!checkIfFileExists(Path.of(filePath))) throw new IllegalArgumentException("File does not exist");
           else{
               Files.write(filePath, content.getBytes());
           }
       } catch (IOException e){
           System.err.println(e.getMessage());
       }
    }

    private static URI getValidUri(String filePath) {
        return URI.create(filePath);
    };


    private static boolean checkIfFileExists(Path foundPath) {
        return Files.exists(foundPath);
    }

    public static String getContentInFile(String path) {
        try{
            getValidUri(path);
            Path foundPath = Path.of(path);
            if (!checkIfFileExists(foundPath)) throw new IllegalArgumentException("File does not exist");

        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}


// Append
// Delete
//Update
