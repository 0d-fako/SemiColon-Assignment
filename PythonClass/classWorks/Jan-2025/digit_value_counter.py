def sum_of_pos_and_neg(numbers):
    pos_count = 0
    neg_count = 0
    zero_count = 0
    for i in numbers:
        if i > 0:
            pos_count += i
        elif i < 0:
            neg_count += i
        else:
            zero_count += i
    return pos_count, neg_count, zero_count

def print_sums(numbers):
    pos_count,neg_count,zero_count = sum_of_pos_and_neg(numbers)
    print(f"Positive numbers: {pos_count}, Negative numbers: {neg_count}, Zeroes: {zero_count}")


def main():
    QUIT_COMMAND = "q"
    my_list = []
    list_item = int(input("Enter a number: "))

    while response != QUIT_COMMAND:
        try:
            my_list.append()
        except ValueError:
            print("Please enter a valid number!")
            continue
        response = input(f"Enter '{QUIT_COMMAND}' to quit: ").strip()  # Strip unwanted whitespace
        print_sums(my_list)


main()