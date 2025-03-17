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


    def test_that_multiple_movies_can_be_created(self):
        app = MovieApp()
        self.assertEqual(0, app.get_total_amount_of_movies())
        app.create_new_movie('The Movie')
        app.create_new_movie('The Movie 2')
        self.assertEqual(2, app.get_total_amount_of_movies())


    def test_that_created_movie_can_be_rated(self):
        app = MovieApp()
        app.create_new_movie('The Movie')
        self.assertEqual(1, app.get_total_amount_of_movies())
        app.rate_movie('The Movie', 5)
        self.assertEqual(5, app.view_average_rating('The Movie'))


    def test_that_created_movie_can_be_rated_multiple_times(self):
        app = MovieApp()
        app.create_new_movie('The Movie')
        self.assertEqual(1, app.get_total_amount_of_movies())
        app.rate_movie('The Movie', 5)
        app.rate_movie('The Movie', 4)
        app.rate_movie('The Movie', 3)
        self.assertEqual(4.0, app.view_average_rating('The Movie'))


    def test_that_created_movie_can_return_average_of_multiple_ratings(self):
        app = MovieApp()
        app.create_new_movie('The Movie')
        self.assertEqual(1, app.get_total_amount_of_movies())
        app.rate_movie('The Movie', 5)
        app.rate_movie('The Movie', 4)
        app.rate_movie('The Movie', 3)
        self.assertEqual(4.0, app.view_average_rating('The Movie'))



    def test_that_incorrect_rating_will_throw_exception(self):
        app = MovieApp()
        app.create_new_movie('The Movie')
        with self.assertRaises(NameError):
            app.rate_movie('The Movie', 16)