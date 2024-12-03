import random

print("You will be assked to gues the sum of two random number between 1 and 100")

first_number = random.randint(1, 99)
second_number = random.randint(1, 99)

sum_of_numbers = first_number + second_number
answer = int(input(f"enter the sum of  {first_number} + {second_number}: "))
if answer == sum_of_numbers:
    print(True)
else:
    print(False)