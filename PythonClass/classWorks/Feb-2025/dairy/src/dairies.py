


class Dairies:
    def __init__(self):
        self.dairies = []  # List to store all diaries

    def add_dairy(self, name, pin):
        if self._dairy_exists(name):
            raise ValueError(f"A dairy with the name '{name}' already exists.")
        self.dairies.append(Dairy(name, pin))

    def find_dairy_by_name(self, name):
        for dairy in self.dairies:
            if dairy.get_name() == name:
                return dairy
        raise RuntimeError(f"No dairy with the name '{name}' found.")

    def delete_dairy(self, name, pin):
        dairy = self.find_dairy_by_name(name)
        if not dairy.validate_pin(pin):
            raise ValueError("Incorrect PIN. Deletion failed.")
        self.dairies.remove(dairy)

    def _dairy_exists(self, name):
        for dairy in self.dairies:
            if dairy.get_name() == name:
                return True
        return False

    def get_all_dairies(self):
        return self.dairies

    def __str__(self):
        if not self.dairies:
            return "No diaries found."
        return "\n".join([str(dairy) for dairy in self.dairies])