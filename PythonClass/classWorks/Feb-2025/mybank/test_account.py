import unittest

from account import Account


class TestAccount(unittest.TestCase):
    def setUp(self):
        self.account = Account("Olu", "Mide", "123456789", "1234")

    def test_initial_balance(self):
        self.assertEqual(self.account.get_balance(), 0.0)

    def test_deposit_positive_amount(self):
        self.account.deposit(100.0)
        self.assertEqual(self.account.get_balance(), 100.0)

    def test_deposit_negative_amount(self):
        with self.assertRaises(ValueError):
            self.account.deposit(-50.0)

    def test_withdraw_valid_amount(self):
        self.account.deposit(200.0)
        self.account.withdraw(100.0, "1234")
        self.assertEqual(self.account.get_balance(), 100.0)

    def test_withdraw_insufficient_balance(self):
        with self.assertRaises(ValueError):
            self.account.withdraw(100.0, "1234")

    def test_withdraw_invalid_pin(self):
        self.account.deposit(200.0)
        with self.assertRaises(ValueError):
            self.account.withdraw(100.0, "wrong_pin")

    def test_update_pin_valid(self):
        self.account.update_pin("1234", "4321")
        self.assertEqual(self.account.pin, "4321")

    def test_update_pin_invalid(self):
        with self.assertRaises(ValueError):
            self.account.update_pin("wrong_pin", "4321")

    def test_to_string(self):
        self.assertEqual(str(self.account), "FullName: Olu Mide, accountNumber=123456789")

