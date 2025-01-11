import random
class Guest:
    def __init__(self, name, phone_number, email, booking_reference):
        self.name = name
        self.phone_number = phone_number
        self.email = email
        self.booking_reference = booking_reference


    def get_details(self):
        return self.name, self.phone_number, self.email, self.booking_reference
