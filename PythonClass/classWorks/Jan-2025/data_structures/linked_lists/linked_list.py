class Node:
    def __init__(self, value, next_node=None):
        self.value = value
        self.next_node = next_node


class LinkedList:
    def __init__(self):
        self.first_node = None
        self.last_node = None

    def append(self, value):
        node = Node(value, None)
        if self.first_node is None:
            self.first_node = node
            self.last_node = node
        else:
            self.last_node.next_node = node
            self.last_node = node

    def delete(self, value):
        if self.first_node is None:
            self.first_node = value
            self.last_node = value
            return
        else:
            node = self.first_node
            self.first_node = self.first_node.next_node
            self.last_node = self.last_node.next_node
            return
