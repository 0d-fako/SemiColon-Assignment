from unittest import TestCase
from television import *


class TestTelevision(TestCase):
    def test_television(self):
        my_television = Television()


    def test_that_television_come_on(self):
        my_television = Television()
        my_television.turn_on()
        self.assertTrue(my_television.get_status())


    def test_that_television_turn_off_when_initiated(self):
        my_television = Television()
        self.assertFalse(my_television.get_status())

    def test_that_television_can_turn_on_and_increase_volume(self):
        my_television = Television()
        my_television.turn_on()
        my_television.increase_volume()
        my_television.increase_volume()
        self.assertEqual(2, my_television.get_volume())

    def test_that_television_volume_isZero_when_initiated(self):
        my_television = Television()
        self.assertEqual(0, my_television.get_volume())


    def test_that_television_can_turn_on_increase_volume_and_decrease_volume(self):
        my_television = Television()
        my_television.turn_on()
        my_television.increase_volume()
        my_television.increase_volume()
        self.assertEqual(2, my_television.get_volume())
        my_television.decrease_volume()
        my_television.decrease_volume()
        self.assertEqual(0, my_television.get_volume())

    def test_that_television_can_turn_on_and_turn_off(self):
        my_television = Television()
        my_television.turn_on()
        my_television.turn_off()
        self.assertFalse(my_television.get_status())


    def test_that_television_can_be_muted(self):
        my_television = Television()
        my_television.turn_on()
        my_television.mute_television()
        self.assertEqual(0, my_television.get_volume())

    def test_that_television_can_be_unmuted(self):
        my_television = Television()
        my_television.turn_on()
        my_television.increase_volume()
        my_television.increase_volume()
        my_television.mute_television()
        self.assertEqual(0, my_television.get_volume())
        my_television.unmute_television()
        self.assertEqual(2, my_television.get_volume())

    def test_decrease_volume_when_off(self):
        my_television = Television()
        my_television.decrease_volume()
        self.assertEqual(0, my_television.get_volume())

    def test_increase_channel_level(self):
        my_television = Television()
        my_television.turn_on()
        my_television.increase_channel_level()
        self.assertEqual(2, my_television.get_channel())

    def test_decrease_channel_level(self):
        my_television = Television()
        my_television.turn_on()
        my_television.increase_channel_level()
        my_television.decrease_channel_level()
        self.assertEqual(1, my_television.get_channel())

    def test_search_specific_channel(self):
        my_television = Television()
        my_television.turn_on()
        my_television.search_channel(15)
        self.assertEqual(15, my_television.get_channel())

    def test_turn_on_and_get_channel(self):
        my_television = Television()

    def test_increase_volume_beyond_max(self):
        my_television = Television()
        my_television.turn_on()
        for i in range(12):
            my_television.increase_volume()
        self.assertEqual(10, my_television.get_volume())
