def differentiate(coefficients, exponents):
    differentiated_coefficients = [
        coefficients[i] * i for i in range(1, len(coefficients))
    ]
    return differentiated_coefficients



coefficients = [4, 1, 2, 3]
result = differentiate(coefficients)
print(result)
