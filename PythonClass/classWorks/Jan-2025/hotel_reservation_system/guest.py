import random
class Guest:
    def __init__(self, name, phone_number, email, booking_reference):
        self.name = name
        self.phone_number = phone_number
        self.email = email
        self.booking_reference = booking_reference



    def get_booking_reference(self):
        self.booking_reference = "RES" + str(random.randint(1000, 9999))
        return self.booking_reference

    def get_details(self):
        self.name = input("Name: ")
        self.phone_number = input("Phone Number: ")
        self.email = input("Email: ")
        self.booking_reference = self.get_booking_reference()

        return self.name, self.phone_number, self.email, self.booking_reference
