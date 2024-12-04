def unsorted(numbers:list)->list:
	pairs = []
	for index in range(len(numbers)):
		for second_index in range(3, len(numbers)-1):
			if numbers[index] == numbers[second_index]:
				if numbers[index] in pairs:continue
				else:pairs.append(numbers[index])
	return[sorted(pairs),[numbers[0],numbers[-1]]]






print(unsorted([1,5,2,2,2,5,5,4]))
		