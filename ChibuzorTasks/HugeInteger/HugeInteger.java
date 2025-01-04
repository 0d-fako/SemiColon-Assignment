package HugeInteger;

import java.math.BigInteger;
import java.util.ArrayList;


public class HugeInteger{

	private final ArrayList<Integer> numbers = new ArrayList<>();

	public HugeInteger(String numbers){
		if (numbers == null) {
			throw new IllegalArgumentException("Input cannot be null");
		}
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

	public boolean isEqualTo(HugeInteger other){
		return this.toString().equals(other.toString());
	}

	public boolean isNotEqualTo(HugeInteger other){
		return !(this.toString().equals(other.toString()));
	}

	public boolean isGreaterThan(HugeInteger other) {
		if (this.numbers.size() != other.numbers.size()) {
			return this.numbers.size() > other.numbers.size();
		}

		for (int i = 0; i < this.numbers.size(); i++) {
			if (!this.numbers.get(i).equals(other.numbers.get(i))) {
				return this.numbers.get(i) > other.numbers.get(i);
			}
		}
		return false;
	}

	public boolean isZero() {
		for (int digit : this.numbers) {
			if (digit != 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String... args){
		
		HugeInteger hugeInteger = new HugeInteger("10");



		System.out.println(hugeInteger.toString());
	

	}


}