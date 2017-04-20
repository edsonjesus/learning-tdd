package counter;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCounterTest {

	@Test
	public void stringComUmCharEmUmaSentencaSimples() {
		StringCounter counter = new StringCounter();
		assertEquals(2, counter.amountChar("Tester", "e"));
	}
}
