public class FirstLetterCapital{
	public static String capitalize(String sentence){

		String[] words = sentence.split(" ");
		StringBuilder capitalizedSentence = new StringBuilder();
		
		for (String word : words) {
			if (!word.isEmpty()) {
				capitalizedSentence.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
			}
		}
		
		return capitalizedSentence.toString().trim();



	}

	public static void main(String[] args){
		System.out.println(capitalize("Great is he who sees greatness in himself"));




	}






}