package counter;

import javax.naming.directory.InvalidAttributesException;

public class StringCounter {

	public int countOccurrences(String sentence, String letter) throws InvalidAttributesException {
		if (sentence == null)
			throw new InvalidAttributesException("The sentence can't be null.");
		
		if (sentence.isEmpty())
			throw new InvalidAttributesException("The sentence can't be empty.");
		
		if (letter == null)
			throw new InvalidAttributesException("The letter can't be null.");
		
		if (letter.length() != 1)
			throw new InvalidAttributesException("The letter must have only one character.");
		
		int amountChar = 0;
		char[] characters = sentence.toCharArray();
		
		for (int i = 0; i < characters.length; i++)
			if(Character.toString(characters[i]).equals(letter))
				amountChar++;
		
		return amountChar;
	}

}
