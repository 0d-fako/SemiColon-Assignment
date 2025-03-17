from MovieApp import MovieApp


def main():
    app = MovieApp()
    while True:
        print("\n=== Movie Rating Main Menu ===")
        print("1. Add A Movie")
        print("2. Rate A Movie")
        print("3. Get Average Rating")
        print("4. View All Movies ratings")
        print("5. Exit")
        choice = input("Enter choice: ")

        if choice == '1':
            movie_title = input("Please enter new movie name: ")
            app.create_new_movie(movie_title)
        elif choice == '2':
            try:
                movie_title = input("Please enter a movie title to rate: ")
                movie_rating = int(input("Please enter a rating (1-5): "))
                app.rate_movie(movie_title, movie_rating)
                print("Movie '{}' has been rated!".format(movie_title))
            except NameError as e:
                print(e)
        elif choice == '3':
            try:
                movie_title = input("Please enter a movie to view average rating: ")
                print(app.view_average_rating(movie_title))
            except NameError as e:
                print(e)
        elif choice == '4':
            app.view_all_average_rating()
        elif choice == '5':
            break
        else:
            print("Invalid choice!")


if __name__ == "__main__":
    main()