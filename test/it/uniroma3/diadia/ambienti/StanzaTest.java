package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class StanzaTest {
	private static final String STANZA = "StanzaTest";
	private static final String STANZA_ADIACENTE = "StanzaAdiacente";
	private static final Direzione NORD = Direzione.NORD;
	
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
	
	

	/*Metodo di utilità*/
	private Stanza creaStanzaEImpostaAdiacente(Stanza stanzaDiPartenza , String nomeStanzaAdiacente, Direzione direzione) {
		Stanza stanzaAdiacente = new Stanza(nomeStanzaAdiacente);
		stanzaDiPartenza.impostaStanzaAdiacente(direzione, stanzaAdiacente);
		return stanzaAdiacente;
	}

}
