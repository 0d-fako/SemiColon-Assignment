import java.util.concurrent.ThreadLocalRandom;

public class RandomNumber {

	private static final int MIN = 1; // Minimum value for the random number
	private static final int MAX = 10; // Maximum value for the random number

	public static void main(String[] args) {
		int randomNumber = generateRandomNumber(MIN, MAX);
		System.out.println(randomNumber);
	}

	private static int generateRandomNumber(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max); // Generates a random number in the range [min, max)
	}
}