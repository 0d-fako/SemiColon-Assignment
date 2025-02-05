package mydairy;

import java.util.ArrayList;

public class Dairy {
        private int id;
        private String name;
        private String pin;
        private ArrayList<DairyEntry> dairyEntries;
        private boolean isLocked;


        public Dairy(String name,String pin) {
            this.name = name;
            this.pin = pin;
            this.dairyEntries = new ArrayList<>();
            this.isLocked = false;
            this.id = 0;

        }


        public DairyEntry createDairyEntry(String title, String body) {
            if(this.isLocked) throw new RuntimeException("Locked");
            DairyEntry entry = new DairyEntry(id++, title, body);
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
            if (validatePin(pin)) this.isLocked = true;
        }

        public boolean isLocked() {
            return this.isLocked;
        }


        public void deleteDairyEntryById(String pin, int id) {
            if(!validatePin(pin)) throw new RuntimeException("Invalid pin");
            DairyEntry dairyEntry;
            dairyEntry = findDairyEntryById(id);
            this.dairyEntries.remove(dairyEntry);
        }

        public DairyEntry findDairyEntryById(int id) {
            if(dairyEntries.isEmpty()) return null;
            if (this.isLocked) throw new RuntimeException("Locked");
            for (DairyEntry entry : this.dairyEntries) {
                if (entry.getId() == id) {
                    return entry;
                }
            }
            return null;
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
