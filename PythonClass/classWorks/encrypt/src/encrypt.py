import bcrypt

username = input("Enter Username: ")
password = input("Enter Password: ")


def hash_password (password):
    hashed_password = bcrypt.hashpw(password.encode('utf-8'), bcrypt.gensalt())
    return hashed_password

def save_to_file (username, password):
    with open('encrypted.txt', 'a') as file:
        file.write(f'{username} :  {hash_password(password.encode("utf-8"))}\n')


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



def main():
    register_user()
if __name__ == '__main__':
    main()