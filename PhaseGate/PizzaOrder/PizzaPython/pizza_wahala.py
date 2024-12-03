import math

def main():
    pizza_types = ["Sapa size", "Small Money", "Big boys", "Odogwu"]
    slices_per_box = [4, 6, 8, 12]
    price_per_box = [2500, 2900, 4000, 5200]
    
    print("Hello, Welcome to the Pizza ordering app")
    
    number_of_people = int(input("Enter number of people: "))
    
    print("Available Pizza Types:")
    for i, pizza in enumerate(pizza_types):
        print(f"{i + 1}. {pizza}")
    
    pizza_choice = int(input("Select pizza type (1-4): ")) - 1
    
    slices_per_box_selected = slices_per_box[pizza_choice]
    boxes_needed = math.ceil(number_of_people / slices_per_box_selected)
    total_slices = boxes_needed * slices_per_box_selected
    leftover_slices = total_slices - number_of_people
    total_price = boxes_needed * price_per_box[pizza_choice]
    
    print("\n--- Pizza Order Summary ---")
    print(f"Pizza Type: {pizza_types[pizza_choice]}")
    print(f"Number of people: {number_of_people}")
    print(f"Number of boxes to buy: {boxes_needed} boxes")
    print(f"Total slices in boxes: {total_slices}")
    print(f"Leftover slices: {leftover_slices}")
    print(f"Total Price: ₦{total_price}")

main()