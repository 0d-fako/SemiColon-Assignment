import unittest

from dairy import *
from dairy.src.dairy import Dairy


class TestDairy(unittest.TestCase):
    def setUp(self):
        self.dairy = Dairy("testUser", "1234")

    def test_new_dairy_should_be_unlocked_initially(self):
        self.assertFalse(self.dairy.is_locked())

    def test_new_dairy_has_correct_name(self):
        self.assertEqual("testUser", self.dairy.get_name())

    def test_validate_pin_with_correct_pin_should_return_true(self):
        self.assertTrue(self.dairy.validate_pin("1234"))

    def test_validate_pin_with_wrong_pin_should_throw_exception(self):
        with self.assertRaises(RuntimeError):
            self.dairy.validate_pin("wrongPin")

    def test_validate_pin_with_empty_pin_should_throw_exception(self):
        with self.assertRaises(RuntimeError):
            self.dairy.validate_pin("")

    def test_lock_dairy_with_correct_pin_should_lock_dairy(self):
        self.dairy.lock_dairy("1234")
        self.assertTrue(self.dairy.is_locked())

    def test_lock_dairy_with_wrong_pin_should_throw_exception(self):
        with self.assertRaises(RuntimeError):
            self.dairy.lock_dairy("wrongPin")

    def test_unlock_dairy_with_correct_pin_should_unlock_dairy(self):
        self.dairy.lock_dairy("1234")
        self.dairy.unlock_dairy("1234")
        self.assertFalse(self.dairy.is_locked())

    def test_unlock_dairy_with_wrong_pin_should_throw_exception(self):
        self.dairy.lock_dairy("1234")
        with self.assertRaises(RuntimeError):
            self.dairy.unlock_dairy("wrongPin")

    def test_create_dairy_entry_should_increment_entries_count(self):
        entry1 = self.dairy.create_dairy_entry("Title 1", "Body 1")
        entry2 = self.dairy.create_dairy_entry("Title 2", "Body 2")
        self.assertEqual(1, entry1['id'])
        self.assertEqual(2, entry2['id'])

    def test_create_multiple_dairy_entry(self):
        self.dairy.lock_dairy("1234")
        self.dairy.unlock_dairy("1234")
        self.dairy.create_dairy_entry("Title", "Body")
        self.dairy.create_dairy_entry("Title@", "Body@")
        self.assertEqual(2, self.dairy.get_dairy_entry_count())

    def test_create_dairy_entry_with_empty_title_should_throw_exception(self):
        with self.assertRaises(ValueError):
            self.dairy.create_dairy_entry("", "Body")

    def test_create_dairy_entry_with_empty_body_should_throw_exception(self):
        with self.assertRaises(ValueError):
            self.dairy.create_dairy_entry("Title", "")

    def test_find_dairy_entry_by_id_existing_entry_should_return_entry(self):
        original_entry = self.dairy.create_dairy_entry("Title", "Body")
        found_entry = self.dairy.find_dairy_entry_by_id(original_entry['id'])
        self.assertEqual(original_entry['id'], found_entry['id'])
        self.assertEqual(original_entry['title'], found_entry['title'])
        self.assertEqual(original_entry['body'], found_entry['body'])

    def test_find_dairy_entry_by_id_when_dairy_is_locked_should_throw_exception(self):
        self.dairy.create_dairy_entry("Title", "Body")
        self.dairy.lock_dairy("1234")
        with self.assertRaises(RuntimeError):
            self.dairy.find_dairy_entry_by_id(1)

    def test_update_entry_by_id_should_update_title_and_body(self):
        entry = self.dairy.create_dairy_entry("Original Title", "Original Body")
        self.dairy.update_entry_by_id(entry['id'], "New Title", "New Body")
        updated_entry = self.dairy.find_dairy_entry_by_id(entry['id'])
        self.assertEqual("New Title", updated_entry['title'])
        self.assertEqual("New Body", updated_entry['body'])

    def test_update_entry_by_id_when_dairy_is_locked_should_throw_exception(self):
        entry = self.dairy.create_dairy_entry("Title", "Body")
        self.dairy.lock_dairy("1234")
        with self.assertRaises(RuntimeError):
            self.dairy.update_entry_by_id(entry['id'], "New Title", "New Body")

    def test_update_entry_by_id_with_non_existing_entry_should_throw_exception(self):
        with self.assertRaises(RuntimeError):
            self.dairy.update_entry_by_id(999, "New Title", "New Body")

    def test_delete_entry_by_id_with_non_existing_entry_should_throw_exception(self):
        with self.assertRaises(RuntimeError):
            self.dairy.delete_dairy_entry_by_id("1234", 999)