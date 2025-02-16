import unittest
from dairy.src.dairy import Dairy


class TestDairy(unittest.TestCase):
    def setUp(self):
        self.dairy = Dairy("testUser", "1234")

    def test_new_dairy_should_be_locked_initially(self):
        self.assertTrue(self.dairy.is_locked())

    def test_new_dairy_has_correct_name(self):
        self.assertEqual("testUser", self.dairy.get_name())

    def test_validate_pin_with_correct_pin_should_return_true(self):
        self.assertTrue(self.dairy.validate_pin("1234"))

    def test_validate_pin_with_wrong_pin_should_throw_exception(self):
        with self.assertRaises(ValueError):
            self.dairy.validate_pin("wrongPin")

    def test_validate_pin_with_empty_pin_should_throw_exception(self):
        with self.assertRaises(ValueError):
            self.dairy.validate_pin("")

    def test_lock_dairy_with_correct_pin_should_lock_dairy(self):
        self.dairy.unlock_dairy("1234")
        self.dairy.lock_dairy("1234")
        self.assertTrue(self.dairy.is_locked())

    def test_lock_dairy_with_wrong_pin_should_throw_exception(self):
        with self.assertRaises(ValueError):
            self.dairy.lock_dairy("wrongPin")

    def test_unlock_dairy_with_correct_pin_should_unlock_dairy(self):
        self.dairy.unlock_dairy("1234")
        self.assertFalse(self.dairy.is_locked())

    def test_unlock_dairy_with_wrong_pin_should_throw_exception(self):
        with self.assertRaises(ValueError):
            self.dairy.unlock_dairy("wrongPin")

    def test_create_dairy_entry_should_increment_entries_count(self):
        self.dairy.unlock_dairy("1234")
        entry1 = self.dairy.create_dairy_entry("Title 1", "Body 1")
        entry2 = self.dairy.create_dairy_entry("Title 2", "Body 2")
        self.assertEqual(1, entry1.get_entry_id())
        self.assertEqual(2, entry2.get_entry_id())

    def test_create_multiple_dairy_entry(self):
        self.dairy.unlock_dairy("1234")
        self.dairy.create_dairy_entry("Title", "Body")
        self.dairy.create_dairy_entry("Title@", "Body@")
        self.assertEqual(2, self.dairy.get_dairy_entry_count())

    def test_create_dairy_entry_with_empty_title_should_throw_exception(self):
        self.dairy.unlock_dairy("1234")
        with self.assertRaises(ValueError):
            self.dairy.create_dairy_entry("", "Body")

    def test_create_dairy_entry_with_empty_body_should_throw_exception(self):
        self.dairy.unlock_dairy("1234")
        with self.assertRaises(ValueError):
            self.dairy.create_dairy_entry("Title", "")

    def test_find_dairy_entry_by_id_existing_entry_should_return_entry(self):
        self.dairy.unlock_dairy("1234")
        original_entry = self.dairy.create_dairy_entry("Title", "Body")
        found_entry = self.dairy.find_dairy_entry_by_id(original_entry.get_entry_id())
        self.assertEqual(original_entry.get_entry_id(), found_entry.get_entry_id())
        self.assertEqual(original_entry.get_title(), found_entry.get_title())
        self.assertEqual(original_entry.get_body(), found_entry.get_body())

    def test_find_dairy_entry_by_id_when_dairy_is_locked_should_throw_exception(self):
        self.dairy.unlock_dairy("1234")
        self.dairy.create_dairy_entry("Title", "Body")
        self.dairy.lock_dairy("1234")
        with self.assertRaises(RuntimeError):
            self.dairy.find_dairy_entry_by_id(1)

    def test_update_entry_by_id_should_update_title_and_body(self):
        self.dairy.unlock_dairy("1234")
        entry = self.dairy.create_dairy_entry("Original Title", "Original Body")
        self.dairy.update_entry_by_id(entry.get_entry_id(), "New Title", "New Body")
        updated_entry = self.dairy.find_dairy_entry_by_id(entry.get_entry_id())
        self.assertEqual("New Title", updated_entry.get_title())
        self.assertEqual("New Body", updated_entry.get_body())

    def test_update_entry_by_id_when_dairy_is_locked_should_throw_exception(self):
        self.dairy.unlock_dairy("1234")
        entry = self.dairy.create_dairy_entry("Title", "Body")
        self.dairy.lock_dairy("1234")
        with self.assertRaises(RuntimeError):
            self.dairy.update_entry_by_id(entry.get_entry_id(), "New Title", "New Body")

    def test_update_entry_by_id_with_non_existing_entry_should_throw_exception(self):
        self.dairy.unlock_dairy("1234")
        with self.assertRaises(ValueError):
            self.dairy.update_entry_by_id(999, "New Title", "New Body")

    def test_delete_entry_by_id_with_non_existing_entry_should_throw_exception(self):
        self.dairy.unlock_dairy("1234")
        with self.assertRaises(ValueError):
            self.dairy.delete_dairy_entry_by_id("1234", 999)
