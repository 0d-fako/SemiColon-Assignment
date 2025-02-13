import datetime

class DairyEntry:
    def __init__(self, id, title, body):
        self.id = id
        self.set_title(title)
        self.set_body(body)
        self.date = datetime.date.today()

    def get_id(self):
        return self.id

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
