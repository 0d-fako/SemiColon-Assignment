from unittest import TestCase
from . import *


def test_sum_all_digits(self):
   actual = sum_all_digits(123)
   expected = 6
   self.assertEqual(expected, actual)

def test_future_day_number(self):
   actual = future_day_number(1, 3)
   expected = "Today is monday and the future day is thursday"
   self.assertEqual(expected, actual)