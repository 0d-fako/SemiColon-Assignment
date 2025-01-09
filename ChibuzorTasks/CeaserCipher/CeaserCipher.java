package CeaserCipher;
import java.util.Scanner;

public class CeaserCipher {
    private static final int ALPHABET_LENGTH = 26;
    private String text;
    private int shift;

    public CeaserCipher() {

    }

    public static String encrypt(String text, int shift) {
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
    public static String decrypt(String text, int shift){
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

        System.out.println("Would you like to encrypt to decrypt a text:Please enter the text you want to encrypt: ");
        
        cipher.text = input.nextLine();

        System.out.print("Please enter the shift value: ");
        cipher.shift = input.nextInt();

        String encryptedText = cipher.encrypt(cipher.text, cipher.shift);

        System.out.println("Encrypted Text: " + encryptedText);
    }
}
