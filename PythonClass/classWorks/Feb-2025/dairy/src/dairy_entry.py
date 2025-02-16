from dairy.src.dairy import *

import datetime

class DairyEntry:
    def __init__(self, entry_id, title, body):
        self.entry_id = entry_id
        self.title = None
        self.body = None
        self.set_title(title)
        self.set_body(body)
        self.date = datetime.date.today()

    def get_entry_id(self):
        return self.entry_id

    def set_title(self, title):
        if not title:
            raise ValueError("Title cannot be null or empty")
        self.title = title

    def get_title(self):
        return self.title

    def set_body(self, body):
        if not body:
            raise ValueError("Body cannot be null or empty")
        self.body = body

    def get_date(self):
        return self.date

    def get_body(self):
        return self.body

    def __str__(self):
        return f"Date: {self.date}\nTitle: {self.title}\nBody: {self.body}\n"
