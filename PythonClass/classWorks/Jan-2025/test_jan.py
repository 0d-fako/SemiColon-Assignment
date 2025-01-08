from email.charset import add_codec
from unittest import TestCase, expectedFailure
import array_search
import differentiation
import sum_of_pos_and_neg




class TestJan(Testcase):
    def test_that_array_search_function_exist(self):
        array_search.array_search([1, 2, 3],8)

    def test_that_array_search_function_return_correct_value(self):
        actual = array_search.array_search([1, 2, 3, 4], 2)
        expected = 1
        self.assertEqual(actual, expected)

    def test_that_array_search_function_raise_error_for_non_integer(self):
        self.assertRaises(TypeError, array_search.array_search, [1, 2, 3], "Rose")

    def test_that_differentiation_function_exist(self):
        differentiation.differentiate(1, 2)

    def test_that_differentiation_function_return_correct_value(self):
        actual = differentiation.differentiate(1, 2)
        expected = [1,1]
        self.assertEquals[actual, expected]

    def test_that_differentiation_function_raise_error_for_non_integer(self):
        actual = differentiation.differentiate("Rose", 2)
        expected = "Please enter a valid number"
        self.assertEquals[actual, expected]

    def test_that_sum_of_pos_and_neg_function_exist(self):
        sum_of_pos_and_neg.sum_of_pos_and_neg([1, 2, 3, 4, 5])

    def test_that_sum_of_pos_and_neg_function_return_correct_value(self):
        add_c