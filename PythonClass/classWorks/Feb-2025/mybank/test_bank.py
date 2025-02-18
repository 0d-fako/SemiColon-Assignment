import unittest
from mybank.bank import Bank

class TestBank(unittest.TestCase):
    def setUp(self):
        self.bank = Bank("Test Bank")
        self.bank.create_account("John", "Doe", "1234")
        self.bank.create_account("Jane", "Doe", "4321")

    def test_create_account(self):
        self.assertEqual(len(self.bank.get_accounts()), 2)
        account = self.bank.get_accounts()[0]
        self.assertEqual(account.get_account_number(), "0")
        self.assertEqual(str(account), "FullName: John Doe, accountNumber=0")

    def test_create_account_invalid_input(self):
        with self.assertRaises(ValueError, msg="First name cannot be empty"):
            self.bank.create_account("", "Doe", "1234")
        with self.assertRaises(ValueError, msg="Last name cannot be empty"):
            self.bank.create_account("John", "", "1234")
        with self.assertRaises(ValueError, msg="PIN cannot be empty"):
            self.bank.create_account("John", "Doe", "")

    def test_transfer(self):
        self.bank.deposit("0", 200.0)
        self.bank.transfer("0", "1", 100.0, "1234")
        self.assertEqual(self.bank.check_balance("0", "1234"), 100.0)
        self.assertEqual(self.bank.check_balance("1", "4321"), 100.0)

    def test_transfer_invalid(self):
        with self.assertRaises(ValueError, msg="Insufficient balance for transfer"):
            self.bank.transfer("0", "1", 300.0, "1234")
        with self.assertRaises(ValueError, msg="Sender and recipient cannot be the same"):
            self.bank.transfer("0", "0", 100.0, "1234")
        with self.assertRaises(ValueError, msg="Recipient not found"):
            self.bank.transfer("0", "2", 100.0, "1234")

    def test_deposit(self):
        self.bank.deposit("0", 100.0)
        self.assertEqual(self.bank.check_balance("0", "1234"), 100.0)

    def test_deposit_invalid(self):
        with self.assertRaises(ValueError, msg="Amount must be positive"):
            self.bank.deposit("0", -50.0)
        with self.assertRaises(ValueError, msg="Account not found"):
            self.bank.deposit("2", 100.0)

    def test_check_balance(self):
        self.bank.deposit("0", 150.0)
        self.assertEqual(self.bank.check_balance("0", "1234"), 150.0)

    def test_check_balance_invalid(self):
        with self.assertRaises(ValueError):
            self.bank.check_balance("0", "wrong_pin")
