package mydairy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {
    private static final String FILE_PATH = "dairies.dat";

    public static void saveDairies(Dairies dairies) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                Files.newOutputStream(Paths.get(FILE_PATH)))) {
            objectOutputStream.writeObject(dairies);
            System.out.println("Dairies saved to " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error saving Dairies to " + e.getMessage());
        }
    }

    public static Dairies loadDairies() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new Dairies();
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                Files.newInputStream(Paths.get(FILE_PATH)))) {
            return (Dairies) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading Dairies from " + FILE_PATH);
            return null;
        }
    }
}