def future_day_number():
    day_number = int(input("enter today number: "))
    future_number = int(input("enter number of days elapsed since: "))
    total = day_number + future_number
    if total < 7 and total >= 0:
        future_day = decide_day(total)
        today = decide_day(day_number)
        print(f"today is {today} and the future day is {future_day}")
    else:
        total = total % 7
        future = decide_day(total)
        today = decide_day(day_number)
        print(f"today is {today} and the future day is {future}")


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

future_day_number()