package sevensegmentdisplay;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SevenSegmentDisplay sevenSegmentDisplay = new SevenSegmentDisplay();

        boolean running = true;
        while (running) {
            try {
                System.out.println("Enter a string of 8 digits (binary numbers only): ");
                String binaryLetters = input.nextLine();

                if(sevenSegmentDisplay.validateInput(binaryLetters)){
                    running = false;
                }

                if(sevenSegmentDisplay.isOn(binaryLetters)) {
                    sevenSegmentDisplay.display(sevenSegmentDisplay.createDisplayArray(sevenSegmentDisplay.convertStringToArrayOfIntegers(binaryLetters)));
                }
                else {
                    System.out.println("Display is Off");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }




    }
}
