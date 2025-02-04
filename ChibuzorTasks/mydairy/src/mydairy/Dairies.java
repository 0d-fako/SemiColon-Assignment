package mydairy;


import java.util.ArrayList;

public class Dairies {
    private ArrayList<Dairy> dairies;


    public Dairies() {
        dairies = new ArrayList<>();
    }

    public void addDairy(String name , String pin) {
        dairies.add(new Dairy(name, pin));
    }

    public Dairy findDairyByUsername(String name) {
        for (Dairy dairy : dairies) {
            if (dairy.getUsername().equals(name)) return dairy;
        }
        throw new RuntimeException("Dairy not found");
    }

    public void deleteDairy(String name, String pin) {
        if(dairies.isEmpty() || !dairies.contains(findDairyByUsername(name))) throw new RuntimeException("Dairy not found");
        dairies.removeIf(dairy -> dairy.getUsername().equals(name));
    }
}
