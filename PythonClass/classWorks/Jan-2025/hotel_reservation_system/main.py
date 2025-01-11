import room
import guest
import time
import random
import booking



def main_menu():
    try:
        choice = int(input("\n"
                           "        1. Book Room\n"
                           "        2. View Available Rooms\n"
                           "        3. Cancel Booking\n"
                           "        4. Manage Guest Details\n"
                           "        5. Generate Reports\n"
                           "        6. Simulate Maintenance\n"
                           "        7. Assign Role\n"
                           "        8. Exit\n"
                           "        "))
    except ValueError:
        print("Please enter a number.")


    while choice != 8:
        If user selects 1:
            Prompt for guest details, room type, number of nights, festive period status
            Call bookRoom()
        Else if user selects 2:
            Call viewAvailableRooms()
        Else if user selects 3:
            Prompt for booking reference
            Call cancelBooking()
        Else if user selects 4:
            Prompt for room number
            Call manageGuestDetails()
        Else if user selects 5:
            Prompt for time period (weekly/monthly)
            Call generateReport()
        Else if user selects 6:
            Prompt for room number
            Call simulateMaintenance()
        Else if user selects 7:
            Prompt for user type and password
            Call assignRole()
        Else:
            Display "Invalid Option"

End