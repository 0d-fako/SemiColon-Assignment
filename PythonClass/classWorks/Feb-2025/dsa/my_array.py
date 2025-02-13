class Array:
    def __init__(self, size):
        self.array = [None] * size

    def is_empty(self):
        for x in self.array:
            if x is not None:
                return False
        return True

    def get_item(self, index):
        if 0 <= index < len(self.array):
            return self.array[index]
        else:
            raise IndexError("Array index out of bounds")

    def set_item(self, index, value):
        if 0 <= index < len(self.array):
            self.array[index] = value
        else:
            raise IndexError("Array index out of bounds")

    def delete(self, index):
        if 0 <= index < len(self.array):
            self.array[index] = None
        else:
            raise IndexError("Array index out of bounds")

    def size(self):
        return len(self.array)

    def to_string(self):
        return str(self.array)
