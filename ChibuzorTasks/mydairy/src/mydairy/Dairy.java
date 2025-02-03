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

        public DairyEntry createDairyEntry() {
            if(this.isLocked) throw new RuntimeException("Locked");
            DairyEntry entry = new DairyEntry(this.id, this.name, this.pin);
            this.dairyEntries.add(entry);
            this.isLocked = true;
            return entry;
        }

        public int getId() {
            return id;
        }
        


}
