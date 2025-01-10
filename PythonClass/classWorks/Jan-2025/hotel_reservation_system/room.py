class Room:
    room_number = [[101, 102], [201, 202], [301, 302]]
    room_type = ["Single", "Double", "Suite"]
    price_per_night = [10000, 20000, 40000]
    is_available = True
    needs_maintenance = False

    def __init__(self, room_number, room_type, price_per_night, is_available, needs_maintenance):
        self.room_number = room_number
        self.room_type = room_type
        self.price_per_night = price_per_night
        self.is_available = is_available
        self.needs_maintenance = needs_maintenance


    def mark_occupied(self):
        self.is_available = False
        return self.is_available

    def mark_as_available():
    markAsUnderMaintenance():
