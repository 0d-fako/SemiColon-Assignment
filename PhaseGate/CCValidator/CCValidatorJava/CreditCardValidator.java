import java.util.Scanner;

public class CreditCardValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter credit card number: ");
        String cardNumber = scanner.nextLine();
        
        if (!isValidLength(cardNumber)) {
            System.out.println("Invalid: Card number must be between 13 and 16 digits");
            return;
        }
        
        String cardType = getCardType(cardNumber);
        if (cardType.equals("Unknown")) {
            System.out.println("Invalid: Unrecognized card type");
            return;
        }
        
        boolean isValid = isValidNumber(cardNumber);
        
        System.out.println("Card Type: " + cardType);
        System.out.println("Validity: " + (isValid ? "Valid" : "Invalid"));
        
        scanner.close();
    }
    
    private static boolean isValidLength(String cardNumber) {
        int length = cardNumber.length();
        return length >= 13 && length <= 16;
    }
    
    private static String getCardType(String cardNumber) {
        if (cardNumber.startsWith("4")) {
            return "Visa";
        } else if (cardNumber.startsWith("5")) {
            return "MasterCard";
        } else if (cardNumber.startsWith("37")) {
            return "American Express";
        } else if (cardNumber.startsWith("6")) {
            return "Discover";
        }
        return "Unknown";
    }
    
    private static boolean isValidNumber(String cardNumber) {
        int sumEven = 0;
        int sumOdd = 0;   
        
        
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(cardNumber.charAt(i));
            
            if ((cardNumber.length() - i) % 2 == 1) {
                sumOdd += digit;
            } else {
                int doubledDigit = digit * 2;
                sumEven += doubledDigit > 9 ? (doubledDigit % 10 + 1) : doubledDigit;
            }
        }
        
       
        int totalSum = sumEven + sumOdd;
        
        
        return totalSum % 10 == 0;
    }
}