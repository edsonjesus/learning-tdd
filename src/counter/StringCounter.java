package counter;

public class StringCounter {

	public int amountChar(String sentence, String letter) {
		int amountChar = 0;
		
		char[] characters = sentence.toCharArray();
		
		for (int i = 0; i < characters.length; i++)
			if(Character.toString(characters[i]).equals(letter))
				amountChar++;
		
		return amountChar;
	}

}
