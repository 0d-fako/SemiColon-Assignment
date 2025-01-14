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


print(get_dict_details())