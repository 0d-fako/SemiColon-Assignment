def unsorted(numbers:list)->list:
	pairs = []
	for index in range(len(numbers)):
		for second_index in range(len(numbers)-1):
			if  numbers[index] - numbers[second_index] == 3 :
				if [numbers[second_index],numbers[index]] in pairs:continue
				else:pairs.append([numbers[second_index],numbers[index]] )
	return pairs






print(unsorted([1,5,2,2,2,5,5,4]))
		