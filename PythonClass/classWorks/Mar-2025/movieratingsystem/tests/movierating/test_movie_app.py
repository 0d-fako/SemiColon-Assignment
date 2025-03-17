from unittest import TestCase

from src.movierating.MovieApp import MovieApp


class TestMovie(TestCase):

    def test_that_movie_can_be_created(self):
        app = MovieApp()
        self.assertEqual(0, app.get_total_amount_of_movies())
        app.create_new_movie('The Movie')
        self.assertEqual(1, app.get_total_amount_of_movies())


    def test_that_duplicate_movies_cant_be_created(self):
        app = MovieApp()
        self.assertEqual(0, app.get_total_amount_of_movies())
        app.create_new_movie('The Movie')
        self.assertEqual(1, app.get_total_amount_of_movies())
        with self.assertRaises(NameError):
            app.create_new_movie('The Movie')
