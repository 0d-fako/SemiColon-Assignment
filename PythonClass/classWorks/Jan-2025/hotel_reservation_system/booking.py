import random
import room as Room
import guest as Guest
from datetime import timedelta, datetime


class Booking:
    def __init__(self, guest: Guest, room: Room, check_in_date: datetime, nights: int):
        self.booking_reference = None
        self.guest = guest
        self.room = room
        self.check_in_date = check_in_date
        self.check_out_date = check_in_date + timedelta(days=nights)
        self.total_payment = 0
        self.is_active = True


    @staticmethod
    def set_booking_reference(self) -> str:
        self.booking_reference = "REF" + str(random.randint(100000, 999999))
        return self.booking_reference

    def calculate_payment(self, festive_period: bool = False) -> float:
        days = (self.check_out_date - self.check_in_date).days
        base_payment = self.room.price_per_night * days
        self.total_payment = base_payment * (1.2 if festive_period else 1)
        return self.total_payment
    
    def check_in_date(self):
        book_date = datetime.now()
        self.check_in_date = book_date
        return self.check_in_date
    
    def cancel_booking(self):
        if not self.is_active:
            raise ValueError("Booking already cancelled")
        self.is_active = False
        self.room.mark_as_available()
        self.guest.booking_reference = None

    def __str__(self):
        return f"Booking {self.booking_reference} - {self.guest.name} - Room {self.room.room_number}"