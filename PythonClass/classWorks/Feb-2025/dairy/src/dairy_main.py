from dairy.src.dairy.dairies import Dairies


def display_main_menu():
    print("\n--- Dairy Management System ---")
    print("1. Create New Dairy")
    print("2. Access Dairy")
    print("3. Delete Dairy")
    print("4. Exit")
    print("Enter your choice: ", end="")

def get_user_choice():
    try:
        return int(input())
    except ValueError:
        return -1

def create_new_dairy(dairies):
    username = input("Enter dairy username: ")
    pin = input("Create a PIN for your dairy: ")

    try:
        dairies.add_dairy(username, pin)
        print("Dairy created successfully!")
    except Exception as e:
        print("Error creating dairy:", e)

def access_dairy(dairies):
    username = input("Enter dairy username: ")
    pin = input("Enter PIN: ")

    try:
        dairy = dairies.find_dairy_by_name(username)
        dairy.unlock_dairy(pin)
        manage_dairy_menu(dairy)
    except Exception as e:
        print("Access denied:", e)

def manage_dairy_menu(dairy):
    while True:
        print("\n---", dairy.get_name(), "'s Dairy ---")
        print("1. Create Entry")
        print("2. View Entries")
        print("3. Update Entry")
        print("4. Delete Entry")
        print("5. Lock Dairy")
        print("6. Return to Main Menu")
        print("Enter your choice: ", end="")

        choice = get_user_choice()

        if choice == 1:
            create_entry(dairy)
        elif choice == 2:
            view_entries(dairy)
        elif choice == 3:
            update_entry(dairy)
        elif choice == 4:
            delete_entry(dairy)
        elif choice == 5:
            lock_dairy(dairy)
            break
        elif choice == 6:
            break
        else:
            print("Invalid choice. Please try again.")

def create_entry(dairy):
    title = input("Enter entry title: ")
    body = input("Enter entry body: ")

    if not title or not body:
        print("Title and body cannot be empty.")
        return

    try:
        dairy.create_dairy_entry(title, body)
        print("Entry created successfully!")
    except Exception as e:
        print("Error creating entry:", e)

def view_entries(dairy):
    pin = input("Enter your pin: ")

    try:
        entries = dairy.view_dairy_entry(pin)
        for i, entry in enumerate(entries):
            print(f"Entry {i + 1}: {entry.get_title()} - {entry.get_body()}")
    except Exception as e:
        print("Error viewing entries:", e)

def update_entry(dairy):
    try:
        entry_id = int(input("Enter entry ID to update: "))
        title = input("Enter new title: ")
        body = input("Enter new body: ")

        if not title or not body:
            print("Title and body cannot be empty.")
            return

        dairy.update_entry_by_id(entry_id, title, body)
        print("Entry updated successfully!")
    except Exception as e:
        print("Error updating entry:", e)

def delete_entry(dairy):
    try:
        entry_id = int(input("Enter entry ID to delete: "))
        pin = input("Enter your pin: ")

        dairy.delete_dairy_entry_by_id(pin, entry_id)
        print("Entry deleted successfully!")
    except Exception as e:
        print("Error deleting entry:", e)

def lock_dairy(dairy):
    pin = input("Enter PIN to lock the dairy: ")
    try:
        dairy.lock_dairy(pin)
        print("Dairy locked successfully!")
    except Exception as e:
        print("Error locking dairy:", e)

def delete_dairy(dairies):
    username = input("Enter dairy username to delete: ")
    pin = input("Enter PIN to confirm deletion: ")

    try:
        dairies.delete_dairy(username, pin)
        print("Dairy deleted successfully!")
    except Exception as e:
        print("Error deleting dairy:", e)

if __name__ == "__main__":
    dairies = Dairies()
    while True:
        display_main_menu()
        choice = get_user_choice()

        if choice == 1:
            create_new_dairy(dairies)
        elif choice == 2:
            access_dairy(dairies)
        elif choice == 3:
            delete_dairy(dairies)
        elif choice == 4:
            print("Exiting the Dairy App. Goodbye!")
            break
        else:
            print("Invalid choice. Please try again.")