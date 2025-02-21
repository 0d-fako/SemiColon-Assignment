import bcrypt

ENCRYPTED = "encrypted.txt"

def hash_password(password):
    hashed_password = bcrypt.hashpw(password.encode("utf-8"), bcrypt.gensalt())
    return hashed_password

def save_to_file(username, password):
    with open(ENCRYPTED, 'a') as file:
        file.write(f'{username}:{password.decode("utf-8")}\n')

def register_user():
    while True:
        username = input("Enter Username: ")
        if not username:
            print("Username cannot be empty")
            continue
        break

    while True:
        password = input("Enter Password: ")
        if not password:
            print("Password cannot be empty")
            continue
        break

    save_to_file(username, hash_password(password))
    print("User registered successfully!")

def validate_user(username, password):
    with open(ENCRYPTED, 'r') as file:
        data = file.read()
        for line in data.split("\n"):
            if line:
                stored_username, stored_password = line.split(":")
                if stored_username == username:
                    return bcrypt.checkpw(password.encode("utf-8"), stored_password.encode("utf-8"))
    return False

def login_user():
    username = input("Enter Username: ")
    password = input("Enter Password: ")

    if validate_user(username, password):
        print("Login successful!")
    else:
        print("Invalid username or password.")

def main():
    while True:
        choice = input("Choose an option: (1) Register (2) Login (3) Exit: ")
        if choice == '1':
            register_user()
        elif choice == '2':
            login_user()
        elif choice == '3':
            break
        else:
            print("Invalid choice. Please try again.")

main()
