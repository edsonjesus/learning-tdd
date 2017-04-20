import java.util.HashMap;
import java.util.Map;

public class Tradutor {

	private Map<String, String> dicionario = new HashMap<>();

	public boolean estaVazio() {
		return (dicionario == null || dicionario.isEmpty());
	}

	public void adicionarTraducao(String palavra, String traducao) {
		if(dicionario.containsKey(palavra))
			traducao = traduzir(palavra) + ", " + traducao;
		
		dicionario.put(palavra, traducao);
	}
	
	public String traduzir(String palavra) {
		return dicionario.get(palavra);
	}

	public String traduzirFrase(String frase) {
		String fraseTraduzida = "";
		String[] palavras = frase.split(" ");
		
		for (String palavra : palavras)
			fraseTraduzida += " " + primeiraTraducao(palavra);
		
		return fraseTraduzida.trim();
	}

	private String primeiraTraducao(String palavra) {
		return traduzir(palavra).split(",")[0];
	}
}
