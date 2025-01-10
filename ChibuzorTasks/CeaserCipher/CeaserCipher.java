package CeaserCipher;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CeaserCipher {
    private static final int ALPHABET_LENGTH = 26;
    private String text;
    private int shift;

    public CeaserCipher() {

    }

    public String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + shift) % ALPHABET_LENGTH;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    public String decrypt(String text, int shift){
        return encrypt(text, ALPHABET_LENGTH - (shift % ALPHABET_LENGTH));
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CeaserCipher cipher = new CeaserCipher();
        System.out.println("Welcome to the Ceaser Cipher App");

        try {
        System.out.println("Would you like to encrypt or decrypt a text?\n1. Encrypt\n2. Decrypt: ");
        int response = input.nextInt();
        input.nextLine();
        if(response == 1) {
            System.out.print("Please enter the text you want to encrypt: ");
            cipher.text = input.nextLine().toLowerCase();
            System.out.print("Please enter the key: ");
            cipher.shift = input.nextInt();
            String encryptedText = cipher.encrypt(cipher.text, cipher.shift);
            System.out.println("Encrypted Text: " + encryptedText);
        } else if(response == 2) {
            System.out.print("Please enter the text you want to decrypt: ");
            cipher.text = input.nextLine().toLowerCase();
            System.out.print("Please enter the key: ");
            cipher.shift = input.nextInt();
            String decryptedText = cipher.decrypt(cipher.text, cipher.shift);
            System.out.println("Decrypted Text: " + decryptedText);
        } else {
            System.out.println("Invalid response");
            main(new String[0]);
        }


        System.out.println("Would you like to perform another action (Y/N)? : ");
        String continueResponse = input.next().toLowerCase();
        if(continueResponse.equals("y")){
            main(new String[0]);
        } else if(continueResponse.equals("n")){
            System.exit(0);
        } else{
            System.out.println("Invalid response");
            main(new String[0]);
            }
        }
        catch (Exception e) {
            throw new InputMismatchException();
        }

    }
}
