from datetime import datetime
from typing import Optional, List

import room as Room
import booking as Booking

class HotelSystem:
    def __init__(self):
        self.rooms: List[Room] = []
        self.bookings: List[Booking] = []
        self.festive_period_multiplier = 1.2
        self.initialize_rooms()

    def initialize_rooms(self):
        room_configs = [
            (101, Room.RoomType.STANDARD, 10000),
            (102, Room.RoomType.STANDARD, 10000),
            (201, Room.RoomType.DELUXE, 20000),
            (202, Room.RoomType.DELUXE, 20000),
            (301, Room.RoomType.SUITE, 35000),
            (302, Room.RoomType.SUITE, 35000),
        ]
        for room_number, room_type, price in room_configs:
            self.rooms.append(Room(room_number, room_type, price))

    def book_room(self, guest_details: dict, room_type: RoomType, nights: int,
                  check_in_date: datetime, festive_period: bool = False) -> Optional[Booking]:
        available_room = next(
            (room for room in self.rooms
             if room.room_type == room_type and room.is_available),
            None
        )

        if not available_room:
            raise ValueError(f"No available rooms of type {room_type.value}")

        # Create guest and booking
        guest = Guest(
            guest_details["name"],
            guest_details["phone_number"],
            guest_details["email"]
        )

        booking = Booking(guest, available_room, check_in_date, nights)
        booking.calculate_payment(festive_period)

        # Update room status
        available_room.mark_as_occupied()

        self.bookings.append(booking)
        return booking

    def cancel_booking(self, booking_reference: str) -> bool:
        booking = next(
            (b for b in self.bookings
             if b.booking_reference == booking_reference and b.is_active),
            None
        )

        if not booking:
            raise ValueError("Booking not found or already cancelled")

        booking.cancel_booking()
        return True

    def view_available_rooms(self, room_type: Optional[RoomType] = None) -> List[Room]:
        available_rooms = [
            room for room in self.rooms
            if room.is_available and not room.needs_maintenance
        ]

        if room_type:
            available_rooms = [
                room for room in available_rooms
                if room.room_type == room_type
            ]

        return available_rooms

    def generate_report(self, start_date: datetime, end_date: datetime) -> dict:
        relevant_bookings = [
            booking for booking in self.bookings
            if booking.check_in_date >= start_date
               and booking.check_in_date <= end_date
        ]

        total_revenue = sum(booking.total_payment for booking in relevant_bookings)
        occupancy_rate = len(relevant_bookings) / len(self.rooms) * 100

        return {
            "total_bookings": len(relevant_bookings),
            "total_revenue": total_revenue,
            "occupancy_rate": occupancy_rate,
            "bookings": relevant_bookings
        }

    def simulate_maintenance(self, room_number: int):
        room = next(
            (room for room in self.rooms if room.room_number == room_number),
            None
        )

        if not room:
            raise ValueError("Room not found")

        room.mark_as_under_maintenance()
