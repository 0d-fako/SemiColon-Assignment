public class TaskEightWhile {
    public static void main(String[] args) {
        int sum = 0;
	int i = 4;
        while (i <= 10) {
            sum += i + i*i + i*i*i + i*i*i*i + i*i*i*i*i;
	i += 4;
        }
        System.out.printf("%d", sum);
    }
}