def get_dict_details():
    details = {
        "name" : input("Enter your name: "),
        "phone_number" : input("Enter your phone number: "),
        "email" : input("Enter your email: "),
    }
    return details


print(get_dict_details())