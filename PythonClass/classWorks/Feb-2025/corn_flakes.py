def convert_string_to_dictionary(string:str)->dict:
    dictionary = {}
    for character in string:
        counter = 0
        for second_character in string:
            if character == second_character:
                counter = counter + 1
                dictionary[character] = counter
    return dictionary


print(convert_string_to_dictionary('semicolon.africa'))


def accept_and_replace_first_character(first_string:str, second_string:str)->str:
    new_first_string = second_string[0] + first_string[1:]
    new_second_string = first_string[0] + second_string[1:]
    new_string = new_first_string + ' ' + new_second_string
    return new_string


def accept_string_and_add_parameter_to_middle_or_end(string:str, parameter:str)->str:
    if len(string) % 2 == 0:
        new_string = string[:len(string) // 2] + parameter + string[len(string) // 2:]
        return new_string
    else:
        new_string = string + parameter
        return new_string


def accept_mixed_case_string_and_move_upper_case_to_front(mixed_cases_string:str)->str:
    new_string = ""
    upper_case_chars = ""
    lower_case_chars = ""
    for character in mixed_cases_string:
        if character.isupper():
            upper_case_chars += character
        else:
            lower_case_chars += character

    new_string = upper_case_chars + lower_case_chars
    return new_string




def accept_string_and_param_return_count_of_param_in_string(string:str, param:str)->tuple:
    counter = 0
    output = ('o',)
    for character in string:
        if character == param:
            counter = counter + 1
    new_output = output + (counter,)
    return new_output



def accept_string_and_remove_special_characters(string:str)->str:
    new_string = ""
    for character in string:
        if character.isalpha():
            new_string += character
    return new_string


