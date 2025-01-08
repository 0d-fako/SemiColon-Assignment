def array_search(my_list, target):
    for i in range(len(my_list)):
        if my_list[i] == target:
            return i
    return "Not available"


def main():
    my_list = []
    response = ""

    while response != "q":

        list_item = int(input("Enter a list item: "))
        if list_item == str:
            print("Invalid input")
            continue

        if list_item == "q":
            response = list_item
        my_list.append(list_item)




    print(my_list)

    print(array_search(my_list, int(input("Enter a number to search: "))))


    my_list = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    target = 3
    print(array_search(my_list, target))


main()
