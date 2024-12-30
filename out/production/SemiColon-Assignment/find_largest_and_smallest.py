largest = 0
smallest = 0
repeat =""

firstNumber = int(input("Enter your First Number: "))
secondNumber = int(input("Enter your second Number: "))	

if(firstNumber > secondNumber):
	largest = firstNumber
	smallest = secondNumber
else :
	largest = secondNumber
	smallest = firstNumber

		
while True:
	repeat = input("Would you like to enter another number (yes/no): ")
	if (repeat != "yes"):
		break 
	
	anotherNumber = int(input("Enter your Another Number: "))
	if(anotherNumber > firstNumber ): 
		largest = anotherNumber
	elif(anotherNumber < secondNumber):
		smallest = anotherNumber
					
print(f"The Largest number is : {largest}")
print(f"The Smallest number is : {smallest}")