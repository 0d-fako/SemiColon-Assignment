import room
import guest
from datetime import date


class Booking:
    guest
    room
    checkInDate = date.today()
    checkOutDate = date.today()
    totalPayment = 0



    def calculate_payment(days, festive_period):
        if festive_period.equals("Yes"):
            payment =  (days * room.price_per_night[1]) *.20

    def cancel_booking(self):
        room.is_available = True
