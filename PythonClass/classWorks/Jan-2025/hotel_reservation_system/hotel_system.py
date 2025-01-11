import room
import booking


class HotelReservationSystem:
    def __init__(self):
        self.rooms = []
        self.bookings = []  # List of bookings
        self.admins = []  # List of administrator users
        self.festivePeriodMultiplier = .20  # Pricing adjustment for festive periods

    def initializeRooms(self):
        """
        Initializes room data for the hotel.
        Example: Adding specific rooms and their properties.
        """
        pass

    def bookRoom(self, guestDetails, roomType, nights, festivePeriod=False):
        """
        Books a room for a guest based on type and number of nights.

        Parameters:
        - guestDetails: Information about the guest.
        - roomType: Type of room being booked.
        - nights: Number of nights the room is booked for.
        - festivePeriod: Boolean indicating if the festive multiplier applies.
        """
        pass

    def cancelBooking(self, bookingReference):
        """
        Cancel a booking by its reference number.

        Parameters:
        - bookingReference: A unique identifier for the booking.
        """
        pass

    def viewAvailableRooms(self):
        """
        Displays all available rooms.
        """
        pass

    def manageGuestDetails(self, roomNumber):
        """
        Allows management of guest details (e.g., updating guest info).

        Parameters:
        - roomNumber: The room number to be updated.
        """
        pass

    def assignRole(self, userType, password):
        """
        Assign a role (e.g., admin/guest) to a user.

        Parameters:
        - userType: Type of user (e.g., "admin").
        - password: Password for the user.
        """
        pass

    def generateReport(self, timePeriod):
        """
        Generate and return a report for a specific time period.

        Parameters:
        - timePeriod: The time period for the report.
        """
        pass

    def sendNotification(self, bookingReference):
        """
        Sends a notification about the booking.

        Parameters:
        - bookingReference: A unique identifier for the booking.
        """
        pass

    def simulateMaintenance(self, roomNumber):
        """
        Simulate a maintenance scenario for testing/information.

        Parameters:
        - roomNumber: The room to place in maintenance mode.
        """
        pass

    def updatePricing(self, festivePeriod):
        """
        Update room pricing based on the festive period.

        Parameters:
        - festivePeriod: Boolean; if true, apply festive multiplier.
        """
        if festivePeriod:
            self.festivePeriodMultiplier = 1.5  # Adjust the multiplier for festive pricing
        else:
            self.festivePeriodMultiplier = 1.0  # Reset to standard pricing