import unittest

from src.sevensegment.seven_segment import SevenSegmentDisplay


class SevenSegmentDisplayTest(unittest.TestCase):
    def setUp(self):
        self.seven_segment_display = SevenSegmentDisplay()

    def test_input_string_must_longer_than_eight_letters_should_throw_exception(self):
        binary_letters = "111111111"
        with self.assertRaises(ValueError):
            self.seven_segment_display.validate_input(binary_letters)

    def test_input_string_must_lesser_than_eight_letters_should_throw_exception(self):
        binary_letters = "111111"
        with self.assertRaises(ValueError):
            self.seven_segment_display.validate_input(binary_letters)

    def test_input_string_must_contain_only_binary_else_throw_exception(self):
        binary_letters = "11111Q91"
        with self.assertRaises(ValueError):
            self.seven_segment_display.validate_input(binary_letters)

    def test_last_digit_to_turn_on_or_off_display(self):
        binary_letters = "11111111"
        self.assertTrue(self.seven_segment_display.is_on(binary_letters))
        binary_letters = "11111110"
        self.assertFalse(self.seven_segment_display.is_on(binary_letters))

    def test_convert_string_to_array_of_integers(self):
        binary_letters = "11111111"
        converted_array = self.seven_segment_display.convert_string_to_array_of_integers(binary_letters)
        result = [1, 1, 1, 1, 1, 1, 1]
        self.assertEqual(result, converted_array)

    def test_convert_string_to_array_of_integers_with_mixed_binary(self):
        binary_letters = "10101010"
        converted_array = self.seven_segment_display.convert_string_to_array_of_integers(binary_letters)
        expected_array = [1, 0, 1, 0, 1, 0, 1]
        self.assertEqual(expected_array, converted_array)

    def test_display_seven_segment_when_display_is_on(self):
        binary_letters = "11111111"
        converted_array = self.seven_segment_display.convert_string_to_array_of_integers(binary_letters)
        display = self.seven_segment_display.create_display_array(converted_array)

        expected_display = [
            ['#', '#', '#', '#'],
            ['#', ' ', ' ', '#'],
            ['#', '#', '#', '#'],
            ['#', ' ', ' ', '#'],
            ['#', '#', '#', '#']
        ]
        self.assertEqual(expected_display, display)


if __name__ == '__main__':
    unittest.main()