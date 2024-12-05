def sum_all_digits(number):
    if number < 0 or number > 1000:
        return "Invalid input: number must be between 0 and 1000"
    total = 0
    while number > 0:
        total += number % 10
        number //= 10
    return total


print(sum_all_digits(932))