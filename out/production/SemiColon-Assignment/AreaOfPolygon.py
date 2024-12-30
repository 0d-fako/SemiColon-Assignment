

numberOfSides = int(input("Enter the number of sides on the polygon: "))

	
lengthOfSide = int(input("Enter the length of one side of the polygon: "))
	
pi = 3.14

areaOfThePolygon  = (numberOfSides*(lengthOfSide**2))/(4 * tan(pi/numberOfSides));

print(f"Area of the polygon {areaOfThePolygon}");
