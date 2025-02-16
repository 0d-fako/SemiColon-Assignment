from dairy.src.dairy import *
from dairy.src.dairy.dairy_entry import DairyEntry


class Dairy:
    def __init__(self, name, pin):
        self.name = name
        self.pin = pin
        self.dairy_entries = []
        self.locked = True
        self.next_entry_id = 1

    def create_dairy_entry(self, title, body):
        if self.locked:
            raise RuntimeError("Dairy is locked. Unlock it first.")
        entry = DairyEntry(self.next_entry_id, title, body)
        self.dairy_entries.append(entry)
        self.next_entry_id += 1
        return entry

    def unlock_dairy(self, pin):
        if self.validate_pin(pin):
            self.locked = False

    def validate_pin(self, pin):
        if not pin:
            raise ValueError("PIN cannot be empty")
        if pin != self.pin:
            raise ValueError("Invalid PIN")
        return True

    def lock_dairy(self, pin):
        if self.validate_pin(pin):
            self.locked = True
        else:
            raise ValueError("Invalid PIN")

    def is_locked(self):
        return self.locked

    def delete_dairy_entry_by_id(self, pin, entry_id):
        if self.locked:
            raise RuntimeError("Dairy is locked. Unlock it first.")
        if not self.validate_pin(pin):
            raise ValueError("Invalid PIN")
        entry = self.find_dairy_entry_by_id(entry_id)
        if entry is None:
            raise ValueError("Dairy entry not found")
        self.dairy_entries.remove(entry)

    def find_dairy_entry_by_id(self, entry_id):
        if self.locked:
            raise RuntimeError("Dairy is locked. Unlock it first.")
        for entry in self.dairy_entries:
            if entry.get_entry_id() == entry_id:
                return entry
        return None

    def get_dairy_entry_count(self):
        return len(self.dairy_entries)

    def view_dairy_entries(self, pin):
        if not self.validate_pin(pin):
            raise ValueError("Invalid PIN")
        if self.locked:
            raise RuntimeError("Dairy is locked. Unlock it first.")
        return self.dairy_entries

    def update_entry_by_id(self, entry_id, title, body):
        if self.locked:
            raise RuntimeError("Dairy is locked. Unlock it first.")
        entry = self.find_dairy_entry_by_id(entry_id)
        if entry is None:
            raise ValueError("Dairy entry not found")
        entry.set_title(title)
        entry.set_body(body)

    def get_name(self):
        return self.name

    def __str__(self):
        return f"Dairy Name: {self.name}, Locked: {self.locked}, Entries: {self.get_dairy_entry_count()}"