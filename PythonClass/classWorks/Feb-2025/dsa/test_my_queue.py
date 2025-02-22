import unittest

from my_queue import Queue

class TestQueue(unittest.TestCase):
    def setUp(self):
        self.queue = Queue()

    def test_is_empty(self):
        self.assertTrue(self.queue.is_empty())

    def test_enqueue(self):
        self.queue.enqueue(1)
        self.assertFalse(self.queue.is_empty())

    def test_dequeue(self):
        self.queue.enqueue(1)
        self.queue.enqueue(2)
        self.assertEqual(self.queue.dequeue(), 1)
        self.assertEqual(self.queue.dequeue(), 2)
        with self.assertRaises(IndexError):
            self.queue.dequeue()

    def test_peek(self):
        self.queue.enqueue(1)
        self.queue.enqueue(2)
        self.assertEqual(self.queue.peek(), 1)
        self.queue.dequeue()
        self.assertEqual(self.queue.peek(), 2)
        self.queue.dequeue()
        with self.assertRaises(IndexError):
            self.queue.peek()

    def test_size(self):
        self.assertEqual(self.queue.size(), 0)
        self.queue.enqueue(1)
        self.queue.enqueue(2)
        self.assertEqual(self.queue.size(), 2)
        self.queue.dequeue()
        self.assertEqual(self.queue.size(), 1)

