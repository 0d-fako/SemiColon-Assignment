from MovieApp import MovieApp


def main():
    app = MovieApp()
    while True:
        print("\n=== Movie Rating Main Menu ===")
        print("1. Add A Movie")
        print("2. Rate A Movie")
        print("3. Get Average Rating")
        print("4. View All Movies")
        print("5. Exit")
        choice = input("Enter choice: ")

        if choice == '1':
            movie_title = input("Please enter : ")
            app.create_new_movie()
        elif choice == '2':
            movie_title = input("Please enter a movie title to rate: ")

            app.rate_a_movie(movie_title)
        elif choice == '3':
            StudentDashboard.enroll_in_course(student)
        elif choice == '4':
            StudentDashboard.view_course_grades(student)
        elif choice == '5':
            break
        else:
            print("Invalid choice!")

