def get_largest(numbers: list):
    if type(numbers) is not list:
        raise TypeError("not a list")
        
    largest = numbers[0]
    for number in numbers:
        if number > largest:
            largest = number
    return largest
    
    
def reverse_a_list(numbers: list):
    if type(numbers) is not list:
        raise TypeError
        
    numbers.reverse()
    return numbers
    
    
def check_occurance(numbers: list, value):
    if type(numbers) is not list:
        raise TypeError
        
    for number in numbers:
        if number == value:
            return True
    return False
    
    
    
def print_odd_numbers(numbers: list):
    if type(numbers) is not list:
        raise TypeError
        
    for number in numbers:
        if number % 2 != 0:
            print(number)
            
            
def print_even_numbers(numbers: list):
    if type(numbers) is not list:
        raise TypeError
        
    for number in numbers:
        if number % 2 == 0:
            print(number)
            
            

def get_total(numbers: list):
    if type(numbers) is not list:
        raise TypeError
    total = 0
    for number in numbers:
        total += number
    return total
    
    
def isPalindrome(words: str):
    if type(words) is not str:
        raise TypeError
        
    reverse = ""
    for char in words:
        reverse = char + reverse
    if reverse == words:
        return True
    return False
    
    
def get_sum_of_numbers_list(numbers: list):
    if type(numbers) is not list:
        raise TypeError("not list")
        
    count = 0
    total = 0
    while count < len(numbers):
        total += numbers[count]
        count += 1
    return total
    
    
    
def get_sum_for(numbers: list):
    if type(numbers) is not list:
        raise TypeError("not list")
        
    total = 0
    for count in range(len(numbers)):
        total += numbers[count]
    return total 
    
    
def join_lists(first: list, second: list):
    if type(first) is not list or type(second) is not list:
        raise TypeError
    
    merged_array = first + second
    return merged_array
    

def take_elements(first: list, second: list):
    if type(first) is not list or type(second) is not list:
        raise TypeError
    for index in range(len(second)):
        first.insert((index + 1), second[index])
        index += 2
    return first
    

    
def seperate_numbers(numbers: int):
    if type(numbers) is not int:
        raise TypeError
        
    numbers = str(numbers)
    digits = []
    for number in numbers:
        digits.append(int(number))
    return digits
    
    
def is_prime(pnumber):
	if type(number) is int:
		if number <= 1: return False
	for number in range(2, pnumber):
		if pnumber % number == 0: return False
	return True

        