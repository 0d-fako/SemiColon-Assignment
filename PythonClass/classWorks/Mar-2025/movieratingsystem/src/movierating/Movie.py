from datetime import datetime


class Movie:
    def __init__(self, title):
        self.title = title
        self.movie_date = datetime.now()
        self.rating = []



