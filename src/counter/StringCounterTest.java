package counter;

import static org.junit.Assert.assertEquals;

import javax.naming.directory.InvalidAttributesException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCounterTest {

	private StringCounter counter;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void initializeEnvironment() {
		counter = new StringCounter();
	}
	
	@Test
	public void letterAtSimpleSentence() throws InvalidAttributesException {
		assertEquals(2, counter.countOccurrences("Tester", "e"));
	}
	
	@Test
	public void letterAtComplexSentence() throws InvalidAttributesException {
		assertEquals(7, counter.countOccurrences("Honorificabilitudinitatibus", "i"));
	}
	
	@Test
	public void letterAtMoreThanOneSentence() throws InvalidAttributesException {
		assertEquals(3, counter.countOccurrences("Nothing else matters", "e"));
	}
	
	@Test
	public void letterWithTwoCharsAtValidSentence() throws InvalidAttributesException {
		thrown.expect(InvalidAttributesException.class);
		thrown.expectMessage("The letter must have only one character.");
		counter.countOccurrences("Technology", "ec");
	}
	
	@Test
	public void letterWithThreeCharsAtValidSentence() throws InvalidAttributesException {
		thrown.expect(InvalidAttributesException.class);
		thrown.expectMessage("The letter must have only one character.");
		counter.countOccurrences("Responsibilities", "eos");
	}
	
	@Test
	public void nullLetterAtValidSentence() throws InvalidAttributesException {
		thrown.expect(InvalidAttributesException.class);
		thrown.expectMessage("The letter can't be null.");
		counter.countOccurrences("Chaos", null);
	}
	
	@Test
	public void emptyLetterAtValidSentence() throws InvalidAttributesException {
		thrown.expect(InvalidAttributesException.class);
		thrown.expectMessage("The letter must have only one character.");
		counter.countOccurrences("Love", "");
	}
	
	@Test
	public void anyLetterAtNullSentence() throws InvalidAttributesException {
		thrown.expect(InvalidAttributesException.class);
		thrown.expectMessage("The sentence can't be null.");
		counter.countOccurrences(null, "a");
	}
	
	@Test
	public void anyLetterAtEmptySentence() throws InvalidAttributesException {
		thrown.expect(InvalidAttributesException.class);
		thrown.expectMessage("The sentence can't be empty.");
		counter.countOccurrences("", "bc");
	}
}
