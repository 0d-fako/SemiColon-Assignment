first_number = int(input("Enter the first number: "))
exponent = int(input("Enter an exponent to raise the first number by: "))

result = first_number
for i in range(1,exponent) :
	result *= first_number

print(f"{first_number} raised to the power of {exponent} is {result}")