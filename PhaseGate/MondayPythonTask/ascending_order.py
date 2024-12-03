first_number = int(input("enter first number: "))
second_number = int(input("enter second number: "))
third_number = int(input("enter third number: "))
numbers = [first_number, second_number, third_number]
numbers.sort()
print(f"{numbers[0]}, {numbers[1]}, {numbers[2]}")