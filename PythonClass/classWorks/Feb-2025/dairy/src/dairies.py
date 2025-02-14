class Dairies:
    def __init__(self):
        self.dairies = []

    def add_dairy(self, name, pin):
        self.dairies.append(Dairy(name, pin))

    def find_dairy_by_name(self, name):
        for dairy in self.dairies:
            if dairy.get_name() == name:
                return dairy
        raise RuntimeError("Dairy not found")

    def delete_dairy(self, name):
        dairy = self.find_dairy_by_name(name)
        self.dairies.remove(dairy)