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

    def test_corn_flakes_throws_exception_for_non_string(self):
        with self.assertRaises(ValueError):
            self.dairy.lock_dairy("wrongPin")