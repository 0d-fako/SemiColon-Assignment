import java.util.Scanner;

public class PizzaWahala {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

       
        String[] pizzaTypes = {"Sapa size", "Small Money", "Big boys", "Odogwu"};
        int[] slicesPerBox = {4, 6, 8, 12};
        int[] pricePerBox = {2500, 2900, 4000, 5200};
        System.out.println("Hello, Welcome to the Pizza ordering app");
       
        System.out.print("Enter number of people: ");
        int numberOfPeople = input.nextInt();
        input.nextLine();

        
        System.out.println("Available Pizza Types:");
        for (int i = 0; i < pizzaTypes.length; i++) {
            System.out.printf("%d. %s\n", i + 1, pizzaTypes[i]);
        }

       
        System.out.print("Select pizza type (1-4): ");
        int pizzaChoice = input.nextInt() - 1;

        
        int slicesPerBoxSelected = slicesPerBox[pizzaChoice];
        int boxesNeeded = (int) Math.ceil((double) numberOfPeople / slicesPerBoxSelected);
        int totalSlices = boxesNeeded * slicesPerBoxSelected;
        int leftoverSlices = totalSlices - numberOfPeople;
        int totalPrice = boxesNeeded * pricePerBox[pizzaChoice];

        System.out.println("\n--- Pizza Order Summary ---");
        System.out.println("Pizza Type: " + pizzaTypes[pizzaChoice]);
        System.out.println("Number of people: " + numberOfPeople);
        System.out.println("Number of boxes to buy: " + boxesNeeded + " boxes");
        System.out.println("Total slices in boxes: " + totalSlices);
        System.out.println("Leftover slices: " + leftoverSlices);
        System.out.println("Total Price: N" + totalPrice);

        
    }
}