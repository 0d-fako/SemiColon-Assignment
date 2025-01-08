from unittest import TestCase
import array_search
import differentiation
import digit_value_counter




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

    def test_that_digit_value_counter_function_exist(self):
        digit_value_counter.sum_of_pos_and_neg([1, 2, 3, 4, 5])

    def test_that_digit_value_counter_function_return_correct_value(self):
        actual = digit_value_counter.sum_of_pos_and_neg([1, 2, 3, 4, -5])
        expected = [4, 1, 0]
        self.assertEquals[actual, expected]