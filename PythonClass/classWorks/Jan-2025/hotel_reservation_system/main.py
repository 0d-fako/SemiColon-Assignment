Main Menu
    Display options:
        1. Book Room
        2. View Available Rooms
        3. Cancel Booking
        4. Manage Guest Details
        5. Generate Reports
        6. Simulate Maintenance
        7. Assign Role
        8. Exit

    While user does not select Exit:
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