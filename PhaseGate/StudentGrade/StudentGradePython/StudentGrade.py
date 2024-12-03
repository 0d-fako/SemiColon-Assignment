def get_number_of_students_and_subjects(num_students, num_subjects):
    return [num_students, num_subjects]
    
def collect_scores(numbers):
    return [[0 for index in range(numbers[1])] for index in range(numbers[0])]
    
def ask_questions_for_students(numbers):
    for row in range(len(numbers)):
        print(f"\nPlease provide scores for student {row + 1}")
        for col in range(len(numbers[row])):
            while True:
                answer = int(input(f"Score for subject {col + 1}: "))
                if 0 <= answer <= 100:
                    numbers[row][col] = answer
                    break
                else:
                    print("Error: Score must be between 0 and 100.")
    return numbers
    
def display_summary(numbers):
    averages = [sum(row) / len(row) for row in numbers]
    positions = list(range(1, len(numbers) + 1))
    
    for i in range(len(averages) - 1):
        for j in range(len(averages) - i - 1):
            if averages[j] < averages[j + 1]:
                averages[j], averages[j + 1] = averages[j + 1], averages[j]
                positions[j], positions[j + 1] = positions[j + 1], positions[j]
    
    print("=" * 105)
    display_header(numbers)
    print("=" * 105)
    
    for row in range(len(numbers)):
        total = sum(numbers[row])
        average = total / len(numbers[row])
        position = positions.index(row + 1) + 1
        
        print(f"Student {row + 1}\t", end="")
        for score in numbers[row]:
            print(f"{score}\t\t", end="")
        print(f"{total}\t\t{average:.2f}\t\t  {position}")
    
    print("=" * 105)
    print("\n")
    subject_summary(numbers)

def display_header(numbers):
    print("Students\t", end="")
    for col in range(len(numbers[0])):
        print(f"Subject {col + 1}\t", end="")
    print("TOTAL\t\tAVERAGE\t\tPOSITION")
    
def subject_summary(numbers):
    print("=" * 59)
    print("Subject summary")
    for col in range(len(numbers[0])):
        decide_for_each_subject(col, numbers)
    
def decide_for_each_subject(col, numbers):
    scores = [row[col] for row in numbers]
    highest = max(scores)
    highest_index = scores.index(highest)
    lowest = min(scores)
    lowest_index = scores.index(lowest)
    total = sum(scores)
    average = total / len(numbers)
    
    print(f"Subject {col + 1}")
    print(f"highest scoring is:   student {highest_index + 1} scoring: {highest}")
    print(f"lowest scoring is:    student {lowest_index + 1} scoring: {lowest}")
    print(f"Total score: {total}\nAverage score: {average:.2f}")
    
    passes = sum(1 for score in scores if score >= 50)
    fails = len(scores) - passes
    print(f"Number of passes: {passes}\nNumber of fails: {fails}")
    print("=" * 59)
    
def number_of_passes(col, numbers):
    scores = [row[col] for row in numbers]
    passes = sum(1 for score in scores if score >= 50)
    fails = len(scores) - passes
    return [passes, fails, col]

def main():
    print("Welcome to the Student Grade App")
    
    num_students = int(input("Please enter how many students are in your class: "))
    num_subjects = int(input("Please enter how many subjects are taught in your class: "))
    
    numbers = get_number_of_students_and_subjects(num_students, num_subjects)
    students = collect_scores(numbers)
    results = ask_questions_for_students(students)
    display_summary(results)

main()