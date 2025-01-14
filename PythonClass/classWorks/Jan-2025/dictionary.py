def get_dict_details():
    details = {
        "name" : input("Enter your name: "),
        "phone_number" : input("Enter your phone number: "),
        "email" : input("Enter your email: "),
    }
    return details



school_records = {
     "class_1":{
         "students":[
             {"name": "Harry", "scores": {"Math":88,"English":76}},
              {"name": "Solomon", "scores": {"Math":95,"English":89}},
        ]
     },
     "class_2":{
         "students": [
             {"name": "Daniel", "scores": {"Math": 78, "English": 72}},
              {"name": "Samuel", "scores": {"Math": 85, "English": 80}},
        ]

     }
}

def get_class_average(school_records):
    class_averages = {}

    for class_name, class_data in school_records.items():
        total_scores = {"Math": 0, "English": 0}
        total_students = len(class_data["students"])

        for student in class_data["students"]:
            for subject, score in student["scores"].items():
                total_scores[subject] += score

        averages = {subject: total / total_students for subject, total in total_scores.items()}
        class_averages[class_name] = averages

    return class_averages



averages = get_class_average(school_records)
print(averages)
print(get_dict_details())