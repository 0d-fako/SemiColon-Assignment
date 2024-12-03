import random
import datetime


counter = 1
score = 0

start_time = datetime.datetime.now()

print("You will the asked to provide the answer to 100 substraction questions. \nTry to answer as much questions correctly as possible in the shortest time possible")



while counter <= 10:
    first_number = random.randrange(100)
    second_number = random.randrange(100)
    correct_answer = 0
    if second_number > first_number:
        print(f"Question {counter}: {second_number} - {first_number}")
        correct_answer = second_number - first_number
    else:
        print(f"Question {counter}: {first_number} - {second_number}")
        correct_answer = first_number - second_number
    answer = int(input("Answer >>>>>> "))
    if answer == correct_answer:
        score += 1
    counter += 1
end_time = datetime.datetime.now()
print(f"your start time: {start_time}\nYour end time: {end_time}\nyou scored {score} / 10")