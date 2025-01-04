package HugeInteger;

import java.util.ArrayList;


public class HugeInteger{

	private ArrayList<Integer> numbers = new ArrayList<>;

	public HugeInteger(String numbers){
		parse(numbers);
	}



	public void parse(String numbers){
		if (numbers.length() > 40) {
			throw new IllegalArgumentException("HugeInteger: Number is too long");
		} else {
			for(Integer number : numbers.toCharArray()){

			}
		}

	}
	private
	public String ToString(){
		StringBuilder numberToString = new StringBuilder();

		for (Integer number : this.numbers ){
			numberToString.append(number);
		}
		return numberToString.toString();


	}

	public Boolean isEqualTo(HugeInteger other){
		return this.ToString().equals(other.ToString());
	}

	public Boolean isNotEqualTo(HugeInteger other){
		return !(this.ToString().equals(other.ToString()));
	}

	public static void main(String... args){
		
		HugeInteger hugeInteger = new HugeInteger("10");



		System.out.println(hugeInteger.toString(number));

		for (int i = 0; i < newHuge.length; i++){
			System.out.print(newHuge[i]);
		}
	

	}


}