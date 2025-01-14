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

def  get_class_average(school_records):
    for class in school_records:
        for student in school_records[class]:

print(get_dict_details())