print("Welcome to the Semicolon Store!")


customer_name = input("What is your name? ")


products = []

while len(products) == 0:
    product_name = input("What did the user buy? ")
    product_quantity = int(input("How many pieces? "))
    product_price = float(input("How much per unit? "))
    products.append({"name": product_name, "quantity": product_quantity, "price": product_price})

    another_product = input("Do you want to add another item? (yes/no) ").lower()
    if another_product != "yes":
        break

subtotal = sum(product["quantity"] * product["price"] for product in products)
vat = subtotal * 0.075
total = subtotal + vat


print("SEMICOLON STORE")
print("INVOICE")
print("----------------------------")
for product in products:
    line_total = product["quantity"] * product["price"]
    print(f"{product['name']:<15} {product['quantity']:3d} x {product['price']:6.2f} {line_total:8.2f}")
print("----------------------------")
print(f"{'Subtotal:':<20} {subtotal:10.2f}")
print(f"{'VAT (7.5%):':<20} {vat:10.2f}")
print(f"{'Total:':<20} {total:10.2f}")