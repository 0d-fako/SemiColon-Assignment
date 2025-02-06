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
