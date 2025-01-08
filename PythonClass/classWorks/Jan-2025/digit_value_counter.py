QUIT_COMMAND = "q"


def sum_of_pos_and_neg(numbers):
    positive_sum = 0
    negative_sum = 0
    zero_sum = 0

    for number in numbers:
        if number > 0:
            positive_sum += 1
        elif number < 0:
            negative_sum += 1
        else:
            zero_sum += 1

    return {
        "positive_sum": positive_sum,
        "negative_sum": negative_sum,
        "zero_sum": zero_sum,
    }


def print_sums(numbers):
    sums = sum_of_pos_and_neg(numbers)
    print(
        f"Positive numbers: {sums['positive_sum']}, Negative numbers: {sums['negative_sum']}, Zeroes: {sums['zero_sum']}")


def main():
    my_list = []
    while True:  # Infinite loop, break using QUIT_COMMAND
        try:
            input_value = input("Enter a number (or 'q' to quit): ").strip()
            if input_value.lower() == QUIT_COMMAND:
                break
            my_list.append(int(input_value))
            print_sums(my_list)
        except ValueError:
            print("Invalid input! Please enter a valid integer.")

main()
