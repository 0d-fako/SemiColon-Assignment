def convert_string_to_dictionary(string:str)->dict:
    dictionary = {}
    if string not in [str]:
        raise ValueError('Must be a valid string')
    for character in string:
        counter = 0
        for second_character in string:
            if character == second_character:
                counter = counter + 1
                dictionary[character] = counter
    return dictionary


print(convert_string_to_dictionary('semicolon.africa'))
