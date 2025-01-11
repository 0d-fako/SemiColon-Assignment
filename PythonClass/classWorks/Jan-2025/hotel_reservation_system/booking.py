import room
import guest
from datetime import date


class Booking:
    def __init__(self, guest, room, checkInDate, checkOutDate, totalPayment):
        self.guest = guest
        self.room = room
        self.checkInDate = checkInDate
        self.checkOutDate = checkOutDate
        self.totalPayment = totalPayment


    def calculate_payment(self, days, festive_period):
        if festive_period.equals("Yes"):
            payment =  days *.20

    def cancel_booking(self):
        room.is_available = True

    def check_in_booking(self):
        room.is_available = False
