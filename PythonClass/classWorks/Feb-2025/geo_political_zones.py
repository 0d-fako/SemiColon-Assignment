from enum import Enum


class GeoPoliticalZones(Enum):
    NORTH_CENTRAL = ["benue", "kogi", "kwara", "nasarawa", "niger", "plateau"]
    NORTH_EAST = ["adamawa", "bauchi", "borno", "gombe", "taraba", "yobe"]
    NORTH_WEST = ["jigawa", "kaduna", "kano", "katsina", "kebbi", "sokoto", "zamfara"]
    SOUTH_EAST = ["abia", "anambra", "ebonyi", "enugu", "imo"]
    SOUTH_SOUTH = ["akwa ibom", "bayelsa", "cross river", "delta", "edo", "rivers"]
    SOUTH_WEST = ["ekiti", "lagos", "ogun", "ondo", "osun", "oyo"]


print("enter you state and get your political zone")

state = input("enter your state: ")
print()
for zone in GeoPoliticalZones:
    if state.lower() in zone.value:
        print("political zone: " + zone.name)
        break
else:
    print("no matching state")