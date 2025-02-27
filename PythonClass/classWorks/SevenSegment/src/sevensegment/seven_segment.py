class SevenSegmentDisplay:
    def validate_input(self, binary_letters):
        if len(binary_letters) != 8:
            raise ValueError("Input must be 8 digits")
        for c in binary_letters:
            if c != '0' and c != '1':
                raise ValueError("Input must contain only binary characters ('0' or '1').")
        return True

    def is_on(self, binary_letters):
        return binary_letters[7] == '1'

    def convert_string_to_array_of_integers(self, binary_letters):
        converted_array = []
        for index in range(len(binary_letters) - 1):
            converted_array.append(1 if binary_letters[index] == '1' else 0)
        return converted_array

    def create_display_array(self, convert_array):
        display = [[' ' for _ in range(4)] for _ in range(5)]

        if convert_array[0] == 1:
            for index in range(4):
                display[0][index] = '#'

        if convert_array[1] == 1:
            for index in range(3):
                display[index][3] = '#'

        if convert_array[2] == 1:
            for index in range(2, 5):
                display[index][3] = '#'

        if convert_array[3] == 1:
            for index in range(4):
                display[4][index] = '#'

        if convert_array[4] == 1:
            for index in range(2, 5):
                display[index][0] = '#'

        if convert_array[5] == 1:
            for index in range(3):
                display[index][0] = '#'

        if convert_array[6] == 1:
            for j in range(4):
                display[2][j] = '#'

        return display

    def display(self, display):
        for row in range(len(display)):
            for column in range(len(display[row])):
                print(display[row][column], end='')
            print()