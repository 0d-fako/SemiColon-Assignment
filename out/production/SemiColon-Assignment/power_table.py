print("a	b	pow(a, b)")
for a in range(1, 6):
    b = a + 1
    result = int(a ** b)
    print(f"{a}	{b}	{result}")