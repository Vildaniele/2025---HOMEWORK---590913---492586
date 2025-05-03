package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StanzaTest {
	private static final String STANZA = "StanzaTest";
	private static final String STANZA_ADIACENTE = "StanzaAdiacente";
	private static final String NORD = "nord";
	
	protected Stanza stanza;
	
	@Before
	public void setUp() {
		this.stanza = new Stanza(STANZA);
	}
	
	/*Vogliamo testare che viene impostata una stanza adiacente.
	 * Noi richiamando il metodo this.stanza.getStanzaAdiacente() ci
	 * deve restituire la stanza adiacente che abbiamo impostato*/
	@Test
	public void testImpostaStanzaAdiacenteSingola() {
		Stanza adiacente = creaStanzaEImpostaAdiacente(this.stanza, STANZA_ADIACENTE, NORD);
		assertEquals(adiacente,this.stanza.getStanzaAdiacente(NORD));
	}
	
	@Test
	public void testCambiaStanzaAdiacente() {
		creaStanzaEImpostaAdiacente(this.stanza, STANZA_ADIACENTE, NORD);
		Stanza nuova = creaStanzaEImpostaAdiacente(this.stanza, "Nuova Adiacente" , NORD);
		assertEquals(nuova, this.stanza.getStanzaAdiacente(NORD));
	}
	
	@Test
	public void impostaMassimo4Stanze(){
		Stanza adiacente = new Stanza(STANZA_ADIACENTE);
		/*possibile scrivere anche come: String[] direzioni = {"nord" , "sud" , "est" , "ovest"};*/
		String[] direzioni = new String[] {"nord" , "sud" , "est" , "ovest"};
		for(String direzione: direzioni)
			this.stanza.impostaStanzaAdiacente(direzione, adiacente);
		
		String direzioneNuova = "nord-ovest";
		creaStanzaEImpostaAdiacente(this.stanza, "Da non inserire" , direzioneNuova);
		
		assertNotCointains(this.stanza.getDirezioni() , direzioneNuova);
	}
	
	private void assertNotCointains(String[] direzioni, String direzioneNuova) {
		boolean contiene = false;
		for(String direzione: direzioni)
			if(direzione!=null && direzione.equals(direzioneNuova)){
				contiene = true;
			}
		assertFalse(contiene);
	}

	/*Metodo di utilità*/
	private Stanza creaStanzaEImpostaAdiacente(Stanza stanzaDiPartenza , String nomeStanzaAdiacente, String direzione) {
		Stanza stanzaAdiacente = new Stanza(nomeStanzaAdiacente);
		stanzaDiPartenza.impostaStanzaAdiacente(direzione, stanzaAdiacente);
		return stanzaAdiacente;
	}

}
