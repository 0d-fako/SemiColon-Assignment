package mydairy;

import java.util.ArrayList;
import java.io.Serializable;

public class Dairies implements Serializable {
    private static final long serialVersionUID = 1L;
    private static ArrayList<Dairy> dairies;

    public Dairies() {
        dairies = new ArrayList<>();
    }

    public void addDairy(String name, String pin) {
        dairies.add(new Dairy(name, pin));
    }

    public static Dairy findDairyByName(String name) {
        for (Dairy dairy : dairies) {
            if (dairy.getName().equals(name)) return dairy;
        }
        throw new RuntimeException("Dairy not found");
    }

    public void deleteDairy(String name, String pin) {
        if(dairies.isEmpty() || !dairies.contains(findDairyByName(name))) throw new RuntimeException("Dairy not found");
        dairies.removeIf(dairy -> dairy.getName().equals(name));
    }
}