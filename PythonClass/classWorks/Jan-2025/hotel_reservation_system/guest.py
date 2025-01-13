
class Guest:
    def __init__(self, name: str, phone_number: str, email: str):
        self.name = name
        self.phone_number = phone_number
        self.email = email


    def set_name(self, name: str):
        self.name = name

    def set_phone_number(self, phone_number: str):
        self.phone_number = phone_number

    def set_email(self, email: str):
        self.email = email

    def get_name(self) -> str:
        return self.name

    def get_phone_number(self) -> str:
        return self.phone_number

    def get_email(self) -> str:
        return self.email

    def get_details(self) -> dict:
        return {
            "name": self.name,
            "phone_number": self.phone_number,
            "email": self.email,
        }

    def __str__(self):
        return f"{self.name} \n{self.email} \n{self.phone_number}"