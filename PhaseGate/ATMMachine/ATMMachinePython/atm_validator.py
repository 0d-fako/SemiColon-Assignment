import random
import re

class Account:
    def __init__(self, account_number, pin, first_name, last_name):
        self.first_name = first_name
        self.last_name = last_name
        self.account_number = account_number
        self.balance = 0.0
        self.pin = pin
        self.is_active = True

    def get_account_number(self):
        return self.account_number

    def validate_pin(self, input_pin):
        return self.pin == input_pin

    def change_pin(self, old_pin, new_pin):
        if self.validate_pin(old_pin):
            self.pin = new_pin
            print("PIN changed successfully")
        else:
            print("Incorrect current PIN. PIN change unsuccessful")

    def get_balance(self):
        return self.balance

    def deposit(self, amount):
        if amount > 0:
            self.balance += amount
            print(f"Deposited N{amount:.2f}. New Balance: N{self.balance:.2f}")
        else:
            print("Invalid deposit amount")

    def withdraw(self, amount):
        if 0 < amount <= self.balance:
            self.balance -= amount
            print(f"Withdrawn N{amount:.2f}. New balance: N{self.balance:.2f}")
            return True
        else:
            print("Insufficient Funds or Invalid Withdrawal amount")
            return False

    def set_first_name(self, first_name):
        self.first_name = first_name

    def get_first_name(self):
        return self.first_name

    def set_last_name(self, last_name):
        self.last_name = last_name

    def get_last_name(self):
        return self.last_name

    def is_active(self):
        return self.is_active

    def deactivate(self):
        self.is_active = False


class Bank:
    def __init__(self, max_accounts):
        self.max_accounts = max_accounts
        self.accounts = [None] * max_accounts
        self.current_account_count = 0

    def create_account(self):
        if self.current_account_count >= self.max_accounts:
            print("Maximum Account reached")
            return

        first_name = input("Please enter your first name: ")
        last_name = input("Please enter your last name: ")

        account_number = self.generate_account_number()
        while not self.is_account_number_unique(account_number):
            account_number = self.generate_account_number()

        while True:
            pin = input("Set your PIN (4 digits): ")
            if re.match(r'^\d{4}$', pin):
                break
            print("PIN must be 4 digits, please try again")

        new_account = Account(account_number, pin, first_name, last_name)
        self.accounts[self.current_account_count] = new_account
        self.current_account_count += 1
        print("Account created successfully")
        print(f"Your account number is: {account_number}")

    def is_account_number_unique(self, account_number):
        for i in range(self.current_account_count):
            if self.accounts[i].get_account_number() == account_number:
                return False
        return True

    def generate_account_number(self):
        return f"{random.randint(0, 99999999):08d}"

    def transfer(self, source_account):
        recipient_account_number = input("Enter recipient Account Number: ")
        recipient_account = self.find_account(recipient_account_number)

        if recipient_account is None:
            print("Recipient not found")
            return

        try:
            amount = float(input("Enter transfer amount: "))
            if source_account.withdraw(amount):
                recipient_account.deposit(amount)
                print("Transfer Successful")
        except ValueError:
            print("Invalid transfer amount")

    def find_account(self, account_number):
        for i in range(self.current_account_count):
            if self.accounts[i].get_account_number() == account_number:
                return self.accounts[i]
        return None

    def login(self):
        account_number = input("Please enter your account number: ")
        account = self.find_account(account_number)

        if account is None:
            print("Account not found")
            return None

        pin = input("Please enter your PIN: ")
        if account.validate_pin(pin):
            return account
        else:
            print("Incorrect PIN")
            return None

    def close_account(self, account):
        if account.get_balance() > 0:
            print("Cannot close account. Balance must be zero")
            return

        response = input("Are you sure you want to close this account (yes/no): ").lower()
        if response != 'yes':
            print("Account closure cancelled")
            return

        account.deactivate()
        self.remove_account_from_accounts(account)
        print(f"Account {account.get_account_number()} closed successfully")

    def remove_account_from_accounts(self, account_to_remove):
        for i in range(self.current_account_count):
            if self.accounts[i] == account_to_remove:
                for j in range(i, self.current_account_count - 1):
                    self.accounts[j] = self.accounts[j + 1]
                self.accounts[self.current_account_count - 1] = None
                self.current_account_count -= 1
                break


def main():
    bank = Bank(1000)

    while True:
        print("\n------ATM MENU-----")
        print("1. Create Account")
        print("2. Login")
        print("3. Exit")

        try:
            response = int(input("Choose an option: "))
        except ValueError:
            print("Invalid input. Please enter a number.")
            continue

        if response == 1:
            bank.create_account()
        elif response == 2:
            logged_in_account = bank.login()
            if logged_in_account:
                logged_in_menu(logged_in_account, bank)
        elif response == 3:
            print("Thank you for using our ATM")
            break
        else:
            print("Invalid Option, Try again")


def logged_in_menu(account, bank):
    while True:
        print("\n--- ACCOUNT MENU ---")
        print("1. Check Balance")
        print("2. Deposit")
        print("3. Withdraw")
        print("4. Transfer")
        print("5. Change PIN")
        print("6. Close Account")
        print("7. Logout")

        try:
            choice = int(input("Choose an option: "))
        except ValueError:
            print("Invalid input. Please enter a number.")
            continue

        if choice == 1:
            print(f"Current Balance: N{account.get_balance():.2f}")
        elif choice == 2:
            try:
                deposit_amount = float(input("Enter deposit amount: "))
                account.deposit(deposit_amount)
            except ValueError:
                print("Invalid deposit amount")
        elif choice == 3:
            try:
                withdraw_amount = float(input("Enter withdrawal amount: "))
                account.withdraw(withdraw_amount)
            except ValueError:
                print("Invalid withdrawal amount")
        elif choice == 4:
            bank.transfer(account)
        elif choice == 5:
            old_pin = input("Enter current PIN: ")
            new_pin = input("Enter new PIN: ")
            account.change_pin(old_pin, new_pin)
        elif choice == 6:
            bank.close_account(account)
            break
        elif choice == 7:
            print("Logging out...")
            break
        else:
            print("Invalid option. Try again.")

main()