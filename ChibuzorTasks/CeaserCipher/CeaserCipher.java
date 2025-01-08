package CeaserCipher;
import java.util.Scanner;

public class CeaserCipher {
    private static final int ALPHABET_LENGTH = 26;
    private String text;
    private int shift;

    public CeaserCipher() {

    }

    public static String encrypt(String text, int shift) {

    }
    public static String decrypt(String text, int shift){

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CeaserCipher cipher = new CeaserCipher();
        System.out.print("Welcome to the Ceaser Cipher App");

        System.out.print("Please enter the text you want to encrypt: ");
        cipher.text = input.nextLine();

        System.out.print("Please enter the shift value: ");
        cipher.shift = input.nextInt();



    }
}
