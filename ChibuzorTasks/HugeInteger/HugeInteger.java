package HugeInteger;

import java.math.BigInteger;
import java.util.ArrayList;


public class HugeInteger{

	private final ArrayList<Integer> numbers = new ArrayList<>();

	public HugeInteger(String numbers){
		parse(numbers);
	}


	public void parse(String numbers) {
		if (numbers.length() > 40) {
			throw new IllegalArgumentException("HugeInteger: Number is too long");
		} else {
			this.numbers.clear();
			for (char digit : numbers.toCharArray()) {
				if (!Character.isDigit(digit)) {
					throw new IllegalArgumentException("Invalid character: " + digit);
				}
				this.numbers.add(Character.getNumericValue(digit));
			}
		}
	}

	private BigInteger getValue(){
		return new BigInteger(toString());
	}
	@Override
	public String toString(){
		StringBuilder numberToString = new StringBuilder();

		for (Integer number : this.numbers ){
			numberToString.append(number);
		}
		return numberToString.toString();

	}

	public Boolean isEqualTo(HugeInteger other){
		return this.toString().equals(other.toString());
	}

	public Boolean isNotEqualTo(HugeInteger other){
		return !(this.toString().equals(other.toString()));
	}

	public static void main(String... args){
		
		HugeInteger hugeInteger = new HugeInteger("10");



		System.out.println(hugeInteger.toString());
	

	}


}