package translator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TranslatorTest {
	private Translator t;

	@Before
	public void prepararAmbienteDeTestes() {
		t = new Translator();
	}

	@Test
	public void tradutorSemPalavras() {
		assertTrue(t.estaVazio());
	}

	@Test
	public void umaTraducao() {
		t.adicionarTraducao("bom", "good");

		assertFalse(t.estaVazio());
		assertEquals("good", t.traduzir("bom"));
	}

	@Test
	public void duasTraducoes() {
		t.adicionarTraducao("ruim", "bad");
		t.adicionarTraducao("amigo", "friend");

		assertEquals("bad", t.traduzir("ruim"));
		assertEquals("friend", t.traduzir("amigo"));
	}

	@Test
	public void duasTraducoesDaMesmaPalavra() {
		t.adicionarTraducao("bom", "good");
		t.adicionarTraducao("bom", "nice");

		assertEquals("good, nice", t.traduzir("bom"));
	}
	
	@Test
	public void traduzirFrase() {
		t.adicionarTraducao("guerra", "war");
		t.adicionarTraducao("é", "is");
		t.adicionarTraducao("ruim", "bad");

		assertEquals("war is bad", t.traduzirFrase("guerra é ruim"));
	}
	
	@Test
	public void traduzirFraseComDuasTraducoesDaMesmaPalavra() {
		t.adicionarTraducao("amor", "love");
		t.adicionarTraducao("é", "is");
		t.adicionarTraducao("bom", "good");
		t.adicionarTraducao("bom", "nice");

		assertEquals("love is good", t.traduzirFrase("amor é bom"));
	}
}
