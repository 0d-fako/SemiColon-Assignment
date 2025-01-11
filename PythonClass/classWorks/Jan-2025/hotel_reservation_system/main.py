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
                    print(f"- {Room.room_type.value}")

                room_type = Room.RoomType(input("Enter room type: "))
                nights = int(input("Enter number of nights: "))
                festive_period = input("Is it a festive period? (y/n): ").lower() == 'y'

                booking = hotel_system.book_room(
                    guest_details,
                    room_type,
                    nights,
                    datetime.now(),
                    festive_period
                )
                print(f"\nBooking confirmed! Reference: {booking.booking_reference}")
                print(f"Total payment: ${booking.total_payment}")

            elif choice == "2":
                available_rooms = hotel_system.view_available_rooms()
                print("\nAvailable Rooms:")
                for room in available_rooms:
                    print(room)

            elif choice == "3":
                reference = input("Enter booking reference: ")
                if hotel_system.cancel_booking(reference):
                    print("Booking cancelled successfully")

            elif choice == "4":
                start_date = datetime.now() - datetime.timedelta(days=30)
                report = hotel_system.generate_report(start_date, datetime.now())
                print("\nReport:")
                print(f"Total Bookings: {report['total_bookings']}")
                print(f"Total Revenue: N{report['total_revenue']}")
                print(f"Occupancy Rate: {report['occupancy_rate']}%")

            elif choice == "5":
                room_number = int(input("Enter room number: "))
                hotel_system.simulate_maintenance(room_number)
                print("Room marked for maintenance")

            elif choice == "6":
                print("Thank you for using the Hotel Reservation System!")
                break

            else:
                print("Invalid option. Please try again.")

        except Exception as e:
            print(f"Error: {str(e)}")


main_menu()