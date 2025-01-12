import datetime
from room import RoomType
import hotel_system

FESTIVE_YES_RESPONSE = 'y'



def book_room():
    guest_details = {
        "name": input("Enter guest name: "),
        "phone_number": input("Enter phone number: "),
        "email": input("Enter email: ")
    }
    print("\nRoom Types:")
    for room_type in RoomType:
        print(f"- {room_type.value}")
    try:
        room_type = RoomType[input("Enter room type: ").upper()]
    except KeyError:
        raise ValueError("Invalid room type selected")

    nights = int(input("Enter number of nights: "))
    festive_period = input("Is it a festive period? (y/n): ").lower() == FESTIVE_YES_RESPONSE

    new_booking = hotel_system.bookRoom(guest_details, room_type, nights, festive_period)
    print(f"\nBooking confirmed! Reference: {new_booking['reference']}")
    print(f"Total payment: ${new_booking['total_payment']}")


def view_available_rooms():
    available_rooms = hotel_system.viewAvailableRooms()
    print("\nAvailable Rooms:")
    for room in available_rooms:
        print(f"Room {room['number']}: {room['type']} (Price: ${room['price']})")


def cancel_booking():
    reference = input("Enter booking reference: ")
    if hotel_system.cancelBooking(reference):
        print("Booking cancelled successfully")
    else:
        print("Booking reference not found.")


def generate_reports():
    start_date = datetime.datetime.now() - datetime.timedelta(days=30)
    report = hotel_system.generateReport(start_date, datetime.datetime.now())
    print("\nReport:")
    print(f"Total Bookings: {report['total_bookings']}")
    print(f"Total Revenue: ${report['total_revenue']}")
    print(f"Occupancy Rate: {report['occupancy_rate']}%")


def simulate_maintenance():
    room_number = int(input("Enter room number: "))
    hotel_system.simulateMaintenance(room_number)
    print("Room marked for maintenance.")


def main_menu():
    while True:
        print("\nHotel Reservation System")
        print("1. Book Room")
        print("2. View Available Rooms")
        print("3. Cancel Booking")
        print("4. Generate Reports")
        print("5. Simulate Maintenance")
        print("6. Exit")

        user_choice = input("Enter your choice (1-6): ")
        try:
            if user_choice == "1":
                book_room()
            elif user_choice == "2":
                view_available_rooms()
            elif user_choice == "3":
                cancel_booking()
            elif user_choice == "4":
                generate_reports()
            elif user_choice == "5":
                simulate_maintenance()
            elif user_choice == "6":
                print("Thank you for using the Hotel Reservation System!")
                break
            else:
                print("Invalid option. Please try again.")
        except ValueError as e:
            print(f"Input Error: {e}")
        except Exception as e:
            print(f"Unexpected Error: {str(e)}")



main_menu()