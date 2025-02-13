from dairy.src.dairy_entry import DairyEntry


class Dairy:
    def __init__(self, name, pin):
        self.name = name
        self.pin = pin
        self.dairy_entries = []
        self.is_locked = False
        self.id = 0

    def create_dairy_entry(self, title, body):
        if self.is_locked:
            self.unlock_dairy(self.pin)
        entry = DairyEntry(self.id + 1, title, body)
        self.dairy_entries.append(entry)
        self.is_locked = True
        self.id += 1
        return entry

    def unlock_dairy(self, pin):
        if self.validate_pin(pin):
            self.is_locked = False

    def validate_pin(self, pin):
        if not pin:
            raise RuntimeError("Pin cannot be empty")
        if pin != self.pin:
            raise RuntimeError("Invalid pin")
        return True

    def lock_dairy(self, pin):
        if self.is_locked:
            raise RuntimeError("Locked")
        if self.validate_pin(pin):
            self.is_locked = True

    def is_locked(self):
        return self.is_locked

    def delete_dairy_entry_by_id(self, pin, id):
        if not self.validate_pin(pin):
            raise RuntimeError("Invalid pin")
        entry = self.find_dairy_entry_by_id(id)
        if entry is None:
            raise RuntimeError("Dairy entry not found")
        self.dairy_entries.remove(entry)

    def find_dairy_entry_by_id(self, id):
        if not self.dairy_entries:
            return None
        if self.is_locked:
            raise RuntimeError("Locked")
        for entry in self.dairy_entries:
            if entry.get_id() == id:
                return entry
        return None

    def get_dairy_entry_count(self):
        return len(self.dairy_entries)

    def view_dairy_entry(self, pin):
        if not self.validate_pin(pin):
            raise RuntimeError("Invalid pin")
        self.unlock_dairy(pin)
        entries = "**************************\n".join([str(entry) for entry in self.dairy_entries])
        return entries

    def update_entry_by_id(self, id, title, body):
        if self.is_locked:
            raise RuntimeError("Locked")
        entry = self.find_dairy_entry_by_id(id)
        entry.set_title(title)
        entry.set_body(body)

    def get_name(self):
        return self.name