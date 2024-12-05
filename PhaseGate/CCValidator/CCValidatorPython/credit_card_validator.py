def is_valid_length(card_number: str) -> bool:
    length = len(card_number)
    return 13 <= length <= 16

def get_card_type(card_number: str) -> str:
    if card_number.startswith('4'):
        return "Visa"
    elif card_number.startswith('5'):
        return "MasterCard"
    elif card_number.startswith('37'):
        return "American Express"
    elif card_number.startswith('6'):
        return "Discover"
    return "Unknown"

def is_valid_number(card_number: str) -> bool:
    sum_even = 0 
    sum_odd = 0

    for i in range(len(card_number) - 1, -1, -1):
        digit = int(card_number[i])
        if (len(card_number) - i) % 2 == 1:
            sum_odd += digit
        else:
            doubled_digit = digit * 2
            sum_even += (doubled_digit % 10 + 1) if doubled_digit > 9 else doubled_digit

    total_sum = sum_even + sum_odd
    
    return total_sum % 10 == 0

def main():
   card_number = input("Enter credit card number: ").strip()
    
    if not card_number.isdigit():
        print("Invalid: Card number must contain only digits")
        return

    if not is_valid_length(card_number):
        print("Invalid: Card number must be between 13 and 16 digits")
        return

    card_type = get_card_type(card_number)
    if card_type == "Unknown":
        print("Invalid: Unrecognized card type")
        return
    
    is_valid = is_valid_number(card_number)
    
    
    print(f"Card Type: {card_type}")
    print(f"Validity: {'Valid' if is_valid else 'Invalid'}")


main()