from unittest import TestCase
import codewars

class TestCodewarFunction(TestCase):
    def test_that_function_exists(self): 
        codewars.unsorted([1,5,2,2,2,5,5,4])
        
    def test_that_functions_returns_correct_value(self):
        actual = codewars.unsorted([1,5,2,2,2,5,5,4])
        expected = [[2,5],[1,4]]
        self.assertEqual(expected, actual) 