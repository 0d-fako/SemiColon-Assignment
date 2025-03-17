from Movie import Movie

class MovieApp:
    def __init__(self):
        self.movies = {}


    def create_new_movie(self, movie_title):
        if movie_title in self.movies:
            raise NameError("Movie '{}' already exists".format(movie_title))
        movie = Movie(movie_title)
        self.movies[movie_title] = movie


    def rate_movie(self, movie_title, movie_rating):
        if movie_title not in self.movies:
            raise NameError("Movie '{}' doesn't exist".format(movie_title))
        movie = self.movies[movie_title]
        movie.rating.append(movie_rating)


    def view_average_rating(self, movie_title):
        if len(self.movies) == 0:
            raise NameError("No Movies exists")
        movie = self.movies[movie_title]
        rating = movie.get_average_rating()
        return rating


    def view_all_average_rating(self):
        if len(self.movies) == 0:
            raise NameError("No Movies exists")
        for movie in self.movies:
            movie = self.movies[movie]
            rating = movie.get_average_rating()
        return f'{movie.movie_title}: {rating}'
