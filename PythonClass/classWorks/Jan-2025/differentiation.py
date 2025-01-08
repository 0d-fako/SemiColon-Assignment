def differentiate(equation):
    diff_array = equation.split("+" or "-")


    differentiated_coefficients = [
        coefficients[i] * i for i in range(1, len(coefficients))
    ]
    return differentiated_coefficients



def main():
    equation =  input("Enter the equation: ")

    result = differentiate(equation)
print(result)
