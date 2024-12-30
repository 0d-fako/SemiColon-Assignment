print("Enter five numbers between 1 to 30")

numbers = []
for i in range(5):
    while True:
        num = int(input(f"Enter number {i+1}: "))
        if 1 <= num <= 30:
            numbers.append(num)
            break
        else:
            print("Number must be between 1 and 30. Try again.")

print("\nBar Chart:")
for num in numbers:
    print("*" * num)