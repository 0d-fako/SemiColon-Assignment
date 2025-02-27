from src.sevensegment.seven_segment import SevenSegmentDisplay


class Main:
    def run(self):
        seven_segment = SevenSegmentDisplay()


        binary_input = input("Enter an 8-digit binary string: ")

        try:
            if seven_segment.validate_input(binary_input):
                if seven_segment.is_on(binary_input):
                    converted_array = seven_segment.convert_string_to_array_of_integers(binary_input)
                    display_array = seven_segment.create_display_array(converted_array)
                    seven_segment.display(display_array)
                else:
                    print("The display is off")

        except ValueError as e:
            print(e)



if __name__ == "__main__":
    main = Main()
    main.run()
