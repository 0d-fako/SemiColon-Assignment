from unittest import TestCase
import array_search
import digit_value_counter




class TestJan(TestCase):
    def test_that_array_search_function_exist(self):
        array_search.array_search([1, 2, 3, 8],8)

    def test_that_array_search_function_return_correct_value(self):
        actual = array_search.array_search([1, 2, 3, 4], 2)
        expected = 1
        self.assertEqual(actual, expected)

    def test_that_digit_value_counter_function_exist(self):
        digit_value_counter.sum_of_pos_and_neg([1, 2, 3, 4, -1, 0])

    def test_that_digit_value_counter_function_return_correct_value(self):
        actual = digit_value_counter.sum_of_pos_and_neg([1, 2, 3, 4, -1, 0])
        expected = {"positive_sum": 4, "negative_sum": 1,"zero_sum": 1}
        self.assertEqual(actual, expected)