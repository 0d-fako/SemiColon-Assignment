package classtasks;

public class FilePractice {

    public void createFile(String filePath) {
        if (filePath == null || filePath.isEmpty()) throw new IllegalArgumentException("File path cannot be null or empty");
    }
}
