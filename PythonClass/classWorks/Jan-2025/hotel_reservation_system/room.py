class Room:
    def __init__(self, room_number, room_type, price_per_night, is_available, needs_maintenance):
        self.room_number = room_number
        self.room_type = room_type
        self.price_per_night = price_per_night
        self.is_available = is_available
        self.needs_maintenance = needs_maintenance


    def mark_occupied(self):
        self.is_available = False
        return self.is_available

    def mark_as_available(self):
        self.is_available = True

    def mark_under_maintenance(self):
        self.needs_maintenance = True
