package CeaserCipher;
import java.util.Scanner;

public class CeaserCipher {
    private static final int ALPHABET_LENGTH = 26;
    private String text;
    private int shift;

    public CeaserCipher() {

    }

    public String encrypt(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder();
        for (char alphabet : text.toCharArray()) {
            if (Character.isUpperCase(alphabet)) {
                encryptedText.append((char) ((alphabet - 'A' + shift) % ALPHABET_LENGTH + 'A'));
            } else if (Character.isLowerCase(alphabet)) {
                encryptedText.append((char) ((alphabet - 'a' + shift) % ALPHABET_LENGTH + 'a'));
            } else {
                encryptedText.append(alphabet);
            }
        }
        return encryptedText.toString();
    }
    public String decrypt(String text, int shift){
        StringBuilder decryptedText = new StringBuilder();
        for (char alphabet : text.toCharArray()) {
            if (Character.isUpperCase(alphabet)) {
                decryptedText.append((char) ((alphabet - 'A' - shift) % ALPHABET_LENGTH + 'A'));
            } else if (Character.isLowerCase(alphabet)) {
                decryptedText.append((char) ((alphabet - 'a' - shift) % ALPHABET_LENGTH + 'a'));
            } else {
                decryptedText.append(alphabet);
            }
        }
        return decryptedText.toString();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CeaserCipher cipher = new CeaserCipher();
        System.out.println("Welcome to the Ceaser Cipher App");

        System.out.println("Would you like to encrypt or decrypt a text?\n1. Encrypt\n2. Decrypt ");
        int response = input.nextInt();
        input.nextLine();
        if(response == 1) {
            System.out.print("Please enter the text you want to encrypt: ");
            cipher.text = input.nextLine();
            System.out.print("Please enter the key: ");
            cipher.shift = input.nextInt();
            String encryptedText = cipher.encrypt(cipher.text, cipher.shift);
            System.out.println("Encrypted Text: " + encryptedText);
        } else if(response == 2) {
            System.out.print("Please enter the text you want to decrypt: ");
            cipher.text = input.nextLine();
            System.out.print("Please enter the key: ");
            cipher.shift = input.nextInt();
            String decryptedText = cipher.decrypt(cipher.text, cipher.shift);
            System.out.println("Decrypted Text: " + decryptedText);
        } else {
            System.out.println("Invalid response");
        }


        System.out.println("Would you like to perform another action (Y/N)? : ");
        String continueResponse = input.next().toLowerCase();
        if(continueResponse.equals("y")){
            main(args);
        } else if(continueResponse.equals("n")){
            System.exit(0);
        } else{
            System.out.println("Invalid response");
        }


    }
}
