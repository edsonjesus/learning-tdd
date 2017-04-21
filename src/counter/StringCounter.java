package counter;

import javax.naming.directory.InvalidAttributesException;

public class StringCounter {

	public int countOccurrences(String sentence, String letter) throws InvalidAttributesException {
		validateParameters(sentence, letter);
		
		int amountChar = 0;
		char letterChar = letter.charAt(0);
		
		for (int i = 0; i < sentence.length(); i++)
			if(sentence.charAt(i) == letterChar)
				amountChar++;
		
		return amountChar;
	}

	private void validateParameters(String sentence, String letter) throws InvalidAttributesException {
		if (sentence == null)
			throw new InvalidAttributesException("The sentence can't be null.");
		
		if (sentence.isEmpty())
			throw new InvalidAttributesException("The sentence can't be empty.");
		
		if (letter == null)
			throw new InvalidAttributesException("The letter can't be null.");
		
		if (letter.length() != 1)
			throw new InvalidAttributesException("The letter must have only one character.");
	}

}
