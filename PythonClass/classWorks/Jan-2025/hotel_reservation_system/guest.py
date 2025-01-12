
class Guest:
    def __init__(self, name: str, phone_number: str, email: str):
        self.name = name
        self.phone_number = phone_number
        self.email = email


    def get_details(self) -> dict:
        return {
            "name": self.name,
            "phone_number": self.phone_number,
            "email": self.email,
        }

    def __str__(self):
        return f"{self.name} ({self.email})"