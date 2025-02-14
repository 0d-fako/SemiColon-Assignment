package mydairy.src.mydairy;

import java.util.ArrayList;
import java.io.Serializable;

public class Dairy implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String pin;
    private ArrayList<DairyEntry> dairyEntries;
    private boolean isLocked;

    public Dairy(String name, String pin) {
        this.name = name;
        this.pin = pin;
        this.dairyEntries = new ArrayList<>();
        this.isLocked = false;
        this.id = 0;
    }

    public DairyEntry createDairyEntry(String title, String body) {
        if(this.isLocked) unlockDairy(pin);
        DairyEntry entry = new DairyEntry(++id, title, body);
        this.dairyEntries.add(entry);
        this.isLocked = true;
        return entry;
    }

    public void unlockDairy(String pin) {
        if(validatePin(pin)) this.isLocked = false;
    }

    public boolean validatePin(String pin) {
        if(pin.isEmpty()) throw new RuntimeException("Pin cannot be empty");
        if(!pin.equals(this.pin)) throw new RuntimeException("Invalid pin");
        return true;
    }

    public void lockDairy(String pin) {
        if(this.isLocked) throw new RuntimeException("Locked");
        if(validatePin(pin)) this.isLocked = true;
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public void deleteDairyEntryById(String pin, int id) {
        if(!validatePin(pin)) throw new RuntimeException("Invalid pin");
        if(findDairyEntryById(id)==null) throw new RuntimeException("Dairy entry not found");
        DairyEntry dairyEntry;
        dairyEntry = findDairyEntryById(id);
        this.dairyEntries.remove(dairyEntry);
    }

    public DairyEntry findDairyEntryById(int id) {
        if(dairyEntries.isEmpty()) return null;
        if(this.isLocked) throw new RuntimeException("Locked");
        for(DairyEntry entry : this.dairyEntries) {
            if(entry.getId() == id) {
                return entry;
            }
        }
        return null;
    }

    public int getDairyEntryCount() {
        return this.dairyEntries.size();
    }

    public String viewDairyEntry(String pin) {
        if(!validatePin(pin)) throw new RuntimeException("Invalid pin");
        this.unlockDairy(pin);
        StringBuilder entries = new StringBuilder();
        for(DairyEntry entry : this.dairyEntries) {
            entries.append("**************************");
            entries.append(entry.toString());
            entries.append("**************************");
            entries.append("\n");
        }
        return entries.toString();
    }

    public void updateEntryById(int id, String title, String body) {
        if(this.isLocked) throw new RuntimeException("Locked");
        DairyEntry dairyEntry = findDairyEntryById(id);
        dairyEntry.setTitle(title);
        dairyEntry.setBody(body);
    }

    public String getName() {
        return this.name;
    }
}