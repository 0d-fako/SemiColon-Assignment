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

        public void createDairyEntry() {
            if(this.isLocked) throw new RuntimeException("Locked");
            DairyEntry entry = new DairyEntry(this.id, this.name, this.pin);
            this.dairyEntries.add(entry);
            this.isLocked = true;
        }


        public void unlockDairy(String pin) {
            validatePin(pin);
            this.isLocked = false;
        }

        public void validatePin(String pin) {
            if(pin.isEmpty()) throw new RuntimeException("Pin cannot be empty");
            if(!pin.equals(this.pin)) throw new RuntimeException("Invalid pin");
        }

        public void lockDairy(String pin) {
            validatePin(pin);
            this.isLocked = true;
        }

        public boolean isLocked() {
            return this.isLocked;
        }


        public int getId() {
            return id;
        }



}
