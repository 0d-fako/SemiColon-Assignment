class Set:
    def __init__(self):
        self.items = []

    def add(self, item):
        if item not in self.items:
            self.items.append(item)

    def remove(self, item):
        if item in self.items:
            self.items.remove(item)

    def contains(self, item):
        return item in self.items

    def size(self):
        return len(self.items)

    def union(self, other_set):
        result = Set()
        result.items = self.items[:]
        for item in other_set.items:
            result.add(item)
        return result

    def intersect(self, other_set):
        result = Set()
        for item in self.items:
            if item in other_set.items:
                result.add(item)
        return result
