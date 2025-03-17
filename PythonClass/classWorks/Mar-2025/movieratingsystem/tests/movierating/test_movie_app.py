from unittest import TestCase

from src.movierating.MovieApp import MovieApp


class TestMovie(TestCase):
    def setUp(self):
        self.app = MovieApp()

    def test_that_movie_can_be_created(self):
        self.assertEqual(0, self.app.get_total_amount_of_movies())
        self.app.create_new_movie('The Movie')
        self.assertEqual(1, self.app.get_total_amount_of_movies())


    def test_that_duplicate_movies_cant_be_created(self):
        self.assertEqual(0, self.app.get_total_amount_of_movies())
        self.app.create_new_movie('The Movie')
        self.assertEqual(1, self.app.get_total_amount_of_movies())
        with self.assertRaises(NameError):
            self.app.create_new_movie('The Movie')


    def test_that_multiple_movies_can_be_created(self):
        self.assertEqual(0, self.app.get_total_amount_of_movies())
        self.app.create_new_movie('The Movie')
        self.app.create_new_movie('The Movie 2')
        self.assertEqual(2, self.app.get_total_amount_of_movies())


    def test_that_created_movie_can_be_rated(self):
        self.app.create_new_movie('The Movie')
        self.assertEqual(1, self.app.get_total_amount_of_movies())
        self.app.rate_movie('The Movie', 5)
        self.assertEqual(5, self.app.view_average_rating('The Movie'))


    def test_that_created_movie_can_be_rated_multiple_times(self):
        self.app.create_new_movie('The Movie')
        self.assertEqual(1, self.app.get_total_amount_of_movies())
        self.app.rate_movie('The Movie', 5)
        self.app.rate_movie('The Movie', 4)
        self.app.rate_movie('The Movie', 3)
        self.assertEqual(4.0, self.app.view_average_rating('The Movie'))


    def test_that_created_movie_can_return_average_of_multiple_ratings(self):
        self.app.create_new_movie('The Movie')
        self.assertEqual(1, self.app.get_total_amount_of_movies())
        self.app.rate_movie('The Movie', 5)
        self.app.rate_movie('The Movie', 4)
        self.app.rate_movie('The Movie', 3)
        self.assertEqual(4.0, self.app.view_average_rating('The Movie'))


    def test_that_incorrect_rating_will_throw_exception(self):
        self.app.create_new_movie('The Movie')
        with self.assertRaises(NameError):
            self.app.rate_movie('The Movie', 16)


    def test_that_rating_a_non_existing_movie_will_throw_exception(self):
        self.app.create_new_movie('The Movie')
        with self.assertRaises(NameError):
            self.app.rate_movie('Movie', 3)

    def test_view_all_average_rating(self):
        self.app.create_new_movie('Movie 2')
        self.app.create_new_movie('The Movie')
        self.app.rate_movie('The Movie', 5)
        self.app.rate_movie('Movie 2', 3)
        self.assertEqual(4.0, self.app.view_all_average_rating())


    def test_empty_movie_title(self):
        with self.assertRaises(NameError):
            self.app.create_new_movie('')
