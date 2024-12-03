def sum_all_digits():
    number = int(input("Provide a number between 0 and 1000 to get the sum of all digits: "))
    if number < 0:
        return "invalid input, number below zero"
    total = 0
    while number > 0:
        remainder = number % 10
        total += remainder
        number //= 10
    return total
    
print(sum_all_digits())