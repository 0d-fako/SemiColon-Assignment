import random


def generate_question():
    num1 = random.randint(1, 20)
    num2 = random.randint(1, 20)
    operation = random.choice(['+', '-', '*', '/'])


    if operation == '/' and num2 == 0:
        num2 = 1

    question = f"{num1} {operation} {num2}"
    return question, evaluate_question(question)


def evaluate_question(question):
    return eval(question)


def math_quiz():
    print("Welcome to the Math Quiz!")
    score = 0
    total_questions = 0

    while True:

        question, correct_answer = generate_question()
        print(f"Question: {question}")


        try:
            user_answer = float(input("Your answer: "))
        except ValueError:
            print("Invalid input. Please enter a number!")
            continue


        if user_answer == correct_answer:
            print("Correct!")
            score += 1
        else:
            print(f"Wrong! The correct answer was {correct_answer:.2f}")

        total_questions += 1


        play_again = input("Do you want to play again? (yes/no): ").strip().lower()
        if play_again != 'yes':
            break

    print(f"Quiz Finished! You got {score}/{total_questions} questions right.)



if __name__ == "__main__":
    math_quiz()
