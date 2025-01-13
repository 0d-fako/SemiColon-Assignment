from enum import Enum

class RoomType(Enum):
    STANDARD = "Standard"
    DELUXE = "Deluxe"
    SUITE = "Suite"


class Room:
    def __init__(self, room_number: int, room_type: RoomType, price_per_night: float):
        self.room_number = room_number
        self.room_type = room_type
        self.price_per_night = price_per_night
        self.is_available = True
        self.needs_maintenance = False

    def set_room_number(self, room_number: int):
        self.room_number = room_number

    def set_room_type(self, room_type: RoomType):
        self.room_type = room_type

    def set_price_per_night(self, price_per_night: float):
        self.price_per_night = price_per_night

    def get_room_number(self):
        return self.room_number

    def get_room_type(self):
        return self.room_type

    def get_price_per_night(self):
        return self.price_per_night

    def mark_as_occupied(self):
        if self.needs_maintenance:
            raise ValueError("Room is under maintenance")
        self.is_available = False

    def mark_as_available(self):
        if self.needs_maintenance:
            raise ValueError("Room is under maintenance")
        self.is_available = True

    def mark_as_under_maintenance(self):
        self.needs_maintenance = True
        self.is_available = False

    def __str__(self):
        status = "Available" if self.is_available else "Occupied"
        if self.needs_maintenance:
            status = "Under Maintenance"
        return f"Room {self.room_number} ({self.room_type.value}) - {status} - ${self.price_per_night}/night"