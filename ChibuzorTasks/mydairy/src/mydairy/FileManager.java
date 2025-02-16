package mydairy.src.mydairy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
    private static final String FILE_PATH = "dairies.dat";

    public static void saveDairies(Dairies dairies) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                Files.newOutputStream(Paths.get(FILE_PATH)))) {
            oos.writeObject(dairies);
            System.out.println("Dairies successfully saved to " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error saving Dairies: " + e.getMessage());
        }
    }

    public static Dairies loadDairies() {
        Path path = Paths.get(FILE_PATH);
        if (!Files.exists(path)) {
            System.out.println("No existing data file. Starting fresh.");
            return new Dairies();
        }

        try (ObjectInputStream ois = new ObjectInputStream(
                Files.newInputStream(path))) {
            return (Dairies) ois.readObject();
        } catch (ClassNotFoundException e) {
            System.err.println("Data format mismatch: " + e.getMessage());
            return new Dairies();
        } catch (IOException e) {
            System.err.println("Error loading Dairies: " + e.getMessage());
            return new Dairies();
        }
    }
}