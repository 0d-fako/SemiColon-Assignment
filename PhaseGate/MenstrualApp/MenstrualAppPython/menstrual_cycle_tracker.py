import random

def isLeapYear(year):
    return year % 4 == 0 and year % 100 != 0 or year % 400 == 0

def getDaysInMonth(month, year):
    if month == 2:
        return 29 if isLeapYear(year) else 28
    if month in [4, 6, 9, 11]:
        return 30
    return 31

def isValidDate(day, month, year):
    if year < 1900 or year > 2100:
        return False
    if month < 1 or month > 12:
        return False
    if day < 1 or day > getDaysInMonth(month, year):
        return False
    return True

def addDays(day, month, year, daysToAdd):
    daysInMonths = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    
    if isLeapYear(year):
        daysInMonths[1] = 29
    
    for _ in range(daysToAdd):
        day += 1
        if day > daysInMonths[month - 1]:
            day = 1
            month += 1
            if month > 12:
                month = 1
                year += 1
                if isLeapYear(year):
                    daysInMonths[1] = 29
                else:
                    daysInMonths[1] = 28
    
    return [day, month, year]

def main():
    name = ""
    day, month, year = 0, 0, 0
    while True:
        name = input("Please provide your name: ")
        day = int(input("Enter last period start date (day(DD)):"))
        month = int(input("Enter last period start date (month (MM)):"))
        year = int(input("Enter last period start date (year(YYYY)):"))
        
        if not isValidDate(day, month, year):
            print("Invalid date. Please try again.")
        else:
            break
    
    print("Hello " + name)
    print("\n--- Period Flow Dates (5 days) ---")
    currentDay, currentMonth, currentYear = day, month, year
    for i in range(5):
        print(f"Day {i+1}: {currentDay:02d}-{currentMonth:02d}-{currentYear}")
        
        nextDate = addDays(currentDay, currentMonth, currentYear, 1)
        currentDay, currentMonth, currentYear = nextDate[0], nextDate[1], nextDate[2]
    
    unsafeStart = addDays(day, month, year, 12)
    unsafeEnd = addDays(day, month, year, 16)
    
    print("\n--- Unsafe (Ovulation) Period ---")
    print(f"Start: {unsafeStart[0]:02d}-{unsafeStart[1]:02d}-{unsafeStart[2]}")
    print(f"End: {unsafeEnd[0]:02d}-{unsafeEnd[1]:02d}-{unsafeEnd[2]}")
  
    nextPeriod = addDays(day, month, year, 28 + int(random.random() * 3))
    
    print("\n--- Next Period Prediction ---")
    print(f"Predicted Date: {nextPeriod[0]:02d}-{nextPeriod[1]:02d}-{nextPeriod[2]}")

main()