import java.util.ArrayList;


public class HugeInteger{

	public static ArrayList<Integer> numbers = new ArrayList<>;

	public HugeInteger(String numbers){
		parse(numbers);
	}



	public void parse(String numbers){
		if (numbers.length() > 40) {
			throw new IllegalArgumentException("HugeInteger: Number is too long");
		}
		
	}
	public static void main(String... args){
		
		int[] newHuge = {1,2,3,4,5};

		System.out.println(Arrays.toString(newHuge));

		for (int i = 0; i < newHuge.length; i++){
			System.out.print(newHuge[i]);
		}
	

	}


}