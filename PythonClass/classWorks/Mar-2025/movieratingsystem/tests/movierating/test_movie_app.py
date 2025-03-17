from unittest import TestCase

from src.movierating.MovieApp import MovieApp


class TestMovie(TestCase):

    def test_that_movie_can_be_created(self):
        app = MovieApp()
        self.assertEqual(0, app.get_total_amount_of_movies())
