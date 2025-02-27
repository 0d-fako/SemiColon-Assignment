import bcrypt
import re

ENCRYPTED = "encrypted.txt"

def hash_password(password):
    hashed_password = bcrypt.hashpw(password.encode("utf-8"), bcrypt.gensalt())
    return hashed_password

def save_to_file(email_address, password):
    with open(ENCRYPTED, 'a') as file:
        file.write(f'{email_address}:{password.decode("utf-8")}\n')

def validate_email(email_address):
    pattern = r'^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$'
    return re.match(pattern, email_address)

def register_user():

    while True:
        email_address = input("Enter Email address: ")
        if not validate_email(email_address):
            print("Please enter a valid email address. {example@gmail.com}")
            continue
        break

    while True:
        password = input("Enter Password: ")
        if not password:
            print("Password cannot be empty")
            continue
        break

    save_to_file(email_address, hash_password(password))
    print("User registered successfully!")

def validate_user(email_address, password):
    with open(ENCRYPTED, 'r') as file:
        data = file.read()
        for line in data.split("\n"):
            if line:
                stored_email, stored_password = line.split(":")
                if stored_email == email_address:
                    return bcrypt.checkpw(password.encode("utf-8"), stored_password.encode("utf-8"))
    return False

def login_user():
    email_address = input("Enter Email Address: ")
    password = input("Enter Password: ")

    if validate_user(email_address, password):
        print("Login successful!")
    else:
        print("Invalid email address or password.")

def main():
    while True:
        choice = input("Choose an option: \n(1) Register \n(2) Login \n(3) Exit: \n>>>>")
        if choice == '1':
            register_user()
        elif choice == '2':
            login_user()
        elif choice == '3':
            break
        else:
            print("Invalid choice. Please try again.")

main()
