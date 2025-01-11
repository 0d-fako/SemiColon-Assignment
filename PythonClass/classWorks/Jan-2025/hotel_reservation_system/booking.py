import room
import guest
from datetime import date

class Booking:
    def __init__(self, guest, room, check_in_date, check_out_date, total_payment):
        self.guest = guest
        self.room = room
        self.checkInDate = check_in_date
        self.checkOutDate = check_out_date
        self.totalPayment = total_payment

    def calculate_payment(self, days, festive_period):
        if festive_period.equals("Yes"):
            payment =  days *.20

    def book_room(self, guest, room):



    def cancel_booking(self):
        room.is_available = True

    def check_in_booking(self):
        room.is_available = False
