def future_day_number(day_number, future_number):
    if not 0 <= day_number <= 6:
        return "Invalid input: day number must be between 0-6"
    total = (day_number + future_number) % 7
    today = decide_day(day_number)
    future = decide_day(total)
    return f"Today is {today} and the future day is {future}


def decide_day(number):
    if number == 1:
        return "monday"
    elif number == 2:
        return "tuesday"
    elif number == 3:
        return "wednesday"
    elif number == 4:
        return "thursday"
    elif number == 5:
        return "friday"
    elif number == 6:
        return "saturday"
    else:
        return "sunday"

future_day_number(1,5)