import unittest

from my_array import Array

class TestArray(unittest.TestCase):

    def setUp(self):
        self.array = Array(5)

    def test_initialization(self):
        self.assertEqual(self.array.size(), 5)
        self.assertTrue(self.array.is_empty())

    def test_set_and_get_item(self):
        self.array.set_item(0, 10)
        self.array.set_item(1, 20)
        self.assertEqual(self.array.get_item(0), 10)
        self.assertEqual(self.array.get_item(1), 20)

    def test_out_of_bounds(self):
        with self.assertRaises(IndexError):
            self.array.get_item(5)
        with self.assertRaises(IndexError):
            self.array.set_item(5, 30)

    def test_is_empty(self):
        self.assertTrue(self.array.is_empty())
        self.array.set_item(0, 10)
        self.assertFalse(self.array.is_empty())

    def test_delete(self):
        self.array.set_item(0, 10)
        self.array.set_item(1, 20)
        self.array.delete(1)
        self.assertEqual(self.array.get_item(1), None)
        self.assertEqual(self.array.to_string(), '[10, None, None, None, None]')
        with self.assertRaises(IndexError):
            self.array.delete(5)

    def test_to_string(self):
        self.array.set_item(0, 10)
        self.array.set_item(1, 20)
        self.assertEqual(self.array.to_string(), '[10, 20, None, None, None]')

