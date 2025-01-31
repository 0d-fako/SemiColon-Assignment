class MyArray:

    def __init__(self, size):
        self.size = 0
        self.capacity = size
        self.data = []


    def put(self, value):
        if len(self.data) != self.capacity:
            self.data.append(value)
            self.size += 1


    def get(self, index):
        return self.data[index]


    def clear(self):
        self.data = []
        self.size = 0


    def length(self):
        return self.capacity


    def remove(self, index):
        self.data.pop(index)
        self.size -= 1


    def substring(self, start, end):
        return self.data[start:end]


    def sorted(self):
        return sorted(self.data)

    def __eq__(self, array):
        if not isinstance(array, MyArray):
            return NotImplemented
        if self.capacity != array.capacity:
            return False
        for i in range(len(self.data)):
            if self.data[i] != array.data[i]:
                return False
        return True


    def __str__(self):
        return str(self.data)

    def is_empty(self):
        return self.size == 0