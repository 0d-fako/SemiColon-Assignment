repeat = "yes"
while repeat == "yes":
	first_number = float(input("Enter the first number: "))
	second_number = float(input("Enter the second number: "))
	
	sum = first_number + second_number
	print(f"The sum of the number is: {sum}")

	print("do you want to continue")
	repeat = input("yes/no : ")

else: 
	print("Thank You")

	
	