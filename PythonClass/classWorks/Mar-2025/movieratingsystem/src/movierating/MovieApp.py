from src.movierating.Movie import Movie


class MovieApp:
    def __init__(self):
        self.movies = {}


    def create_new_movie(self, movie_title):
        if movie_title in self.movies:
            raise NameError("Movie '{}' already exists".format(movie_title))
        movie = Movie(movie_title)
        self.movies[movie_title] = movie
        print(f"New movie created: {movie_title}")


    def rate_movie(self, movie_title, movie_rating):
        if movie_title not in self.movies:
            raise NameError("Movie '{}' does not exist".format(movie_title))
        if movie_rating < 1 or movie_rating > 5:
            raise NameError("Movie '{}' is out of range".format(movie_title))
        movie = self.find_movie_by_title(movie_title)
        movie.rating.append(movie_rating)


    def view_average_rating(self, movie_title):
        if len(self.movies) == 0 or movie_title not in self.movies:
            raise NameError("Movie does not exists")
        movie = self.movies[movie_title]
        rating = movie.get_average_rating()
        return rating

    def view_all_average_rating(self):
        if not self.movies:
            raise ValueError("No movies exist")
        average_ratings = [
            movie.get_average_rating()
            for movie in self.movies.values()
            if movie.get_average_rating() > 0  # Exclude movies with no ratings
        ]
        if not average_ratings:
            return 0  # No rated movies

        return sum(average_ratings) / len(average_ratings)

    def find_movie_by_title(self, movie_title):
        if movie_title in self.movies:
            return self.movies[movie_title]
        raise NameError(f"Movie '{movie_title}' doesn't exist")

    def get_total_amount_of_movies(self):
        return len(self.movies)