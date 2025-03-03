from unittest import TestCase

import corn_flakes
from corn_flakes import *


class TestCornFlakes(TestCase):
    def test_flakes(self):
        corn_flakes.convert_string_to_dictionary("semicolon.africa")


    def test_corn_flakes_works_on_short_string(self):
        result = corn_flakes.convert_string_to_dictionary("semicolon.africa")
        output = {'s': 1, 'e': 1, 'm': 1, 'i': 2, 'c': 2, 'o': 2, 'l': 1, 'n': 1, '.': 1, 'a': 2, 'f': 1, 'r': 1}
        self.assertEqual(result, output)


    def test_accept_and_replace_string(self):
        corn_flakes.accept_and_replace_first_character("Hello", "World")


    def test_accept_and_replace_string_works(self):
        result = corn_flakes.accept_and_replace_first_character("Hello", "World")
        output = "Wello Horld"
        self.assertEqual(result, output)


    def test_accept_string_and_parameter(self):
        corn_flakes.accept_string_and_add_parameter_to_middle_or_end("Helloo", "ce")


    def test_accept_string_and_parameter_works_for_words_with_even_length(self):
        result = corn_flakes.accept_string_and_add_parameter_to_middle_or_end("Helloo", "ce")
        output = "Helceloo"
        self.assertEqual(result, output)

    def test_accept_string_and_parameter_works_for_words_with_uneven_length(self):
        result = corn_flakes.accept_string_and_add_parameter_to_middle_or_end("Hello", "ce")
        output = "Helloce"
        self.assertEqual(result, output)


    def test_mixed_cased_function(self):
        corn_flakes.accept_mixed_case_string_and_move_upper_case_to_front("sEmIColOn")


    def test_mixed_cases_function_works(self):
        result = corn_flakes.accept_mixed_case_string_and_move_upper_case_to_front("sEmIColOn")
        output = "EICOsmoln"
        self.assertEqual(result, output)


    def test_param_counter(self):
        corn_flakes.accept_string_and_param_return_count_of_param_in_string("semicolon", "o")


    def test_param_counter_works(self):
        result = corn_flakes.accept_string_and_param_return_count_of_param_in_string("semicolon", "o")
        output = ("o", 2)
        self.assertEqual(result, output)

    def test_remove_special_characters(self):
        corn_flakes.accept_string_and_remove_special_characters("he,ll.o")


    def test_remove_special_characters_works(self):
        result = corn_flakes.accept_string_and_remove_special_characters("he,ll.o")
        output = "hello"
        self.assertEqual(result, output)