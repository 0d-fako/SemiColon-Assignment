import room
import guest
from datetime import date


class Booking:
    guest
    room
    checkInDate = date.today()
    checkOutDate = date.today()
    totalPayment = 0



    def calculate_payment(days, festivePeriod):
        payment =  days * room.price_per_night[1]

    def cancel_booking():
        room.is_available = True
