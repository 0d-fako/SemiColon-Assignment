from account import Account

class Bank:
    def __init__(self, bank_name):
        self.bank_name = bank_name
        self.account_counter = 0
        self.accounts = []

    def create_account(self, first_name, last_name, pin):
        if not first_name or not last_name or not pin:
            raise ValueError("First name, last name, and PIN cannot be null or empty")
        account = Account(first_name, last_name, self.generate_account_number(), pin)
        self.accounts.append(account)

    def generate_account_number(self):
        number = str(self.account_counter)
        self.account_counter += 1
        return number

    def transfer(self, sender, recipient, amount, pin):
        sender_account = self.find_account(sender)
        recipient_account = self.find_account(recipient)
        if not sender_account or not recipient_account:
            raise ValueError("Sender or recipient not found")
        if sender_account == recipient_account:
            raise ValueError("Sender and recipient cannot be the same")
        sender_account.withdraw(amount, pin)
        recipient_account.deposit(amount)

    def find_account(self, account_number):
        if not account_number:
            raise ValueError("Invalid account number")
        for account in self.accounts:
            if account.get_account_number() == account_number:
                return account
        return None

    def get_accounts(self):
        return self.accounts

    def get_bank_name(self):
        return self.bank_name

    def deposit(self, account_number, amount):
        account = self.find_account(account_number)
        if not account:
            raise ValueError("Account not found")
        if amount < 0:
            raise ValueError("Amount must be positive")
        account.deposit(amount)

    def check_balance(self, account_number, pin):
        if not account_number:
            raise ValueError("Account number cannot be null")
        if not pin:
            raise ValueError("Invalid pin")

        account = self.find_account(account_number)
        if not account:
            raise ValueError("No account found")
        if account.get_pin() != pin:
            raise ValueError("Invalid PIN")

        return account.get_balance()

