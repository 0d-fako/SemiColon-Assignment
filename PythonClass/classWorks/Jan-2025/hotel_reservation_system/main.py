import datetime
import room as Room
import guest as Guest
import time
import random
import booking
import hotel_system

hotel_system = hotel_system()


def main_menu():
    while True:
        print("\nHotel Reservation System")
        print("1. Book Room")
        print("2. View Available Rooms")
        print("3. Cancel Booking")
        print("4. Generate Reports")
        print("5. Simulate Maintenance")
        print("6. Exit")

        choice = input("Enter your choice (1-6): ")

        try:
            if choice == "1":
                guest_details = {
                    "name": input("Enter guest name: "),
                    "phone_number": input("Enter phone number: "),
                    "email": input("Enter email: ")
                }

                print("\nRoom Types:")
                for room_type in Room.RoomType:
                    print(f"- {room_type.value}")

                room_type = input("Enter room type: ")
                room_type = Room.RoomType[room_type.upper()] if room_type.upper() in Room.RoomType.__members__ else None
                if room_type is None:
                    raise ValueError("Invalid room type selected")

                nights = int(input("Enter number of nights: "))
                festive_period = input("Is it a festive period? (y/n): ").lower() == 'y'

                new_booking = hotel_system.bookRoom(
                    guest_details,
                    room_type,
                    nights,
                    festive_period
                )
                print(f"\nBooking confirmed! Reference: {new_booking['reference']}")
                print(f"Total payment: ${new_booking['total_payment']}")

            elif choice == "2":
                # Call the viewAvailableRooms method
                available_rooms = hotel_system.viewAvailableRooms()
                print("\nAvailable Rooms:")
                for room in available_rooms:
                    print(f"Room {room['number']}: {room['type']} (Price: ${room['price']})")

            elif choice == "3":
                reference = input("Enter booking reference: ")

                if hotel_system.cancelBooking(reference):
                    print("Booking cancelled successfully")
                else:
                    print("Booking reference not found.")

            elif choice == "4":
    
                start_date = datetime.datetime.now() - datetime.timedelta(days=30)
                report = hotel_system.generateReport(start_date, datetime.datetime.now())
                print("\nReport:")
                print(f"Total Bookings: {report['total_bookings']}")
                print(f"Total Revenue: ${report['total_revenue']}")
                print(f"Occupancy Rate: {report['occupancy_rate']}%")

            elif choice == "5":
                room_number = int(input("Enter room number: "))
                hotel_system.simulateMaintenance(room_number)  # Call simulateMaintenance
                print("Room marked for maintenance.")

            elif choice == "6":
                print("Thank you for using the Hotel Reservation System!")
                break

            else:
                print("Invalid option. Please try again.")

        except Exception as e:
            print(f"Error: {str(e)}")

main_menu()