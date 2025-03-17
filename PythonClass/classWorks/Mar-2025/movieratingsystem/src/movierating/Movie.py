from datetime import datetime


class Movie:
    def __init__(self, title):
        self.movie_title = title
        self.movie_date = datetime.now()
        self.rating = []



    def get_movie_title(self):
        return self.movie_title

    def get_movie_date(self):
        return self.movie_date

    def get_average_rating(self):
        if self.rating is None: return 0
        return sum(self.rating) / len(self.rating)

    def to_dict(self):
        return {
            'Movie Title': self.movie_title,
            'Movie Date': self.movie_date,
            'Average Rating': self.get_average_rating()
        }