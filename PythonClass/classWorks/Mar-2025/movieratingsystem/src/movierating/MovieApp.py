from Movie import Movie

class MovieApp:
    def __init__(self):
        self.movies = {}


    def create_new_movie(self, movie_title):
        movie = Movie(movie_title)
        self.movies[movie_title] = movie


    def rate_movie(self, movie_title):
        movie = self.movies[movie_title]
        movie.rating = movie.rating + 1
        movie.save()


    def view_average_rating(self, movie_title):
        movie = self.movies[movie_title]