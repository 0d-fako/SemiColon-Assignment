import random


class Guest:
    def __init__(self, name: str, phone_number: str, email: str):
        self.name = name
        self.phone_number = phone_number
        self.email = email
        self.booking_reference = self.get_booking_reference(self)

    @staticmethod
    def get_booking_reference(self) -> str:
        self.booking_reference = "REF" + str(random.randint(100000, 999999))
        return self.booking_reference


    def get_details(self) -> dict:
        return {
            "name": self.name,
            "phone_number": self.phone_number,
            "email": self.email,
            "booking_reference": self.booking_reference
        }

    def __str__(self):
        return f"{self.name} ({self.email})"