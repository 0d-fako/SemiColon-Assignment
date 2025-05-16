package classtasks;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FilePractice {

    public static void createFile(String filePath) {
        try {
            if (filePath == null || filePath.isEmpty()) throw new IllegalArgumentException("File path cannot be null or empty");
            Path path = Paths.get(filePath);
            if (Files.exists(path)) throw new IllegalArgumentException("File already exists");

            Files.createFile(path);

            System.out.println("File created successfully: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
           Path path = Paths.get(filePath);
           if (!checkIfFileExists(Paths.get(filePath))) throw new IllegalArgumentException("File does not exist");
           else{
               List<String> lines = Files.readAllLines(Paths.get(filePath));
               String contents = String.join("\n", lines);
               Files.write(Paths.get(filePath), content.getBytes());
           }
       } catch (IOException e){
           System.err.println(e.getMessage());
       }
    }

    private static URI getValidUri(String filePath) {
        return URI.create(filePath);
    }



    private static boolean checkIfFileExists(Path foundPath) {
        return Files.exists(foundPath);
    }

    public static String getContentInFile(String path) {
        try {
            getValidUri(path);
            Path foundPath = Paths.get(path);
            if (!checkIfFileExists(foundPath)) throw new IllegalArgumentException("File does not exist");
            return new String(Files.readAllBytes(foundPath));
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return "Error reading file content.";
        }
    }


    public static void deleteFile(String filePath) {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            throw new IllegalArgumentException("File does not exist");
        }

        try {
            Files.delete(path);
            System.out.println("File deleted successfully: " + filePath);
        } catch (IOException e) {
            System.err.println("Error deleting file: " + e.getMessage());
        }
    }


    public static void deleteIfExists(String filePath) {
        Path path = Paths.get(filePath);
        try {
            if (Files.deleteIfExists(path)) {
                System.out.println("File deleted: " + filePath);
            } else {
                System.out.println("File does not exist: " + filePath);
            }
        } catch (IOException e) {
            System.err.println("Error deleting file: " + e.getMessage());
        }
    }


}


// Append
// Delete
// Update
// DeleteIfExist

//InputStream and OutputStream
