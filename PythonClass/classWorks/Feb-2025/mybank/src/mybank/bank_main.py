from mybank.src.mybank.bank import Bank


def display_menu():
    print("\nWelcome to the Bank App!")
    print("1. Create Account")
    print("2. Deposit Money")
    print("3. Withdraw Money")
    print("4. Transfer Money")
    print("5. Check Balance")
    print("6. Exit")

def create_account(bank):
    first_name = input("Enter your first name: ")
    last_name = input("Enter your last name: ")
    pin = input("Set your PIN: ")
    try:
        bank.create_account(first_name, last_name, pin)
        print("Account created successfully!")
    except ValueError as e:
        print(f"Error: {e}")

def deposit_money(bank):
    account_number = input("Enter your account number: ")
    amount = float(input("Enter the amount to deposit: "))
    try:
        bank.deposit(account_number, amount)
        print("Deposit successful!")
    except ValueError as e:
        print(f"Error: {e}")

def withdraw_money(bank):
    account_number = input("Enter your account number: ")
    amount = float(input("Enter the amount to withdraw: "))
    pin = input("Enter your PIN: ")
    try:
        account = bank.find_account(account_number)
        account.withdraw(amount, pin)
        print("Withdrawal successful!")
    except ValueError as e:
        print(f"Error: {e}")

def transfer_money(bank):
    sender = input("Enter your account number: ")
    recipient = input("Enter the recipient's account number: ")
    amount = float(input("Enter the amount to transfer: "))
    pin = input("Enter your PIN: ")
    try:
        bank.transfer(sender, recipient, amount, pin)
        print("Transfer successful!")
    except ValueError as e:
        print(f"Error: {e}")

def check_balance(bank):
    account_number = input("Enter your account number: ")
    pin = input("Enter your PIN: ")
    try:
        balance = bank.check_balance(account_number, pin)
        print(f"Your balance is: {balance}")
    except ValueError as e:
        print(f"Error: {e}")

def main():
    bank = Bank("Python Bank")
    while True:
        display_menu()
        choice = input("Enter your choice: ")
        if choice == "1":
            create_account(bank)
        elif choice == "2":
            deposit_money(bank)
        elif choice == "3":
            withdraw_money(bank)
        elif choice == "4":
            transfer_money(bank)
        elif choice == "5":
            check_balance(bank)
        elif choice == "6":
            print("Thank you for using the Bank App. Goodbye!")
            break
        else:
            print("Invalid choice. Please try again.")
