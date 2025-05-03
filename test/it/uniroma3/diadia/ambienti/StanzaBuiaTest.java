package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Fixture;

class StanzaBuiaTest {
	
	private static final String ATTREZZO_LUCE_TEST = "attrezzoLucetest";
	private StanzaBuia stanzaBuia;
	private static final String DESCRIZIONE_STANZA = "Stanza buia/n" + "Uscite:/n" + "Attrezzi bella stanza: attrezzoLuceTest (1kg)";

	@BeforeEach
	void setUp() throws Exception {
		this.stanzaBuia = new StanzaBuia("stanzaBuia" , ATTREZZO_LUCE_TEST);
	}

	@Test
	void testGetDescrizioneLuceNonPresente() {
		assertEquals(StanzaBuia.DESCRIZIONE_STANZA_BUIA , this.stanzaBuia.getDescrizione());
	}
	
	@Test
	void testGetDescrizioneConLuce() {
		Fixture.creaAttrezzoEAggiungiAStanza(this.stanzaBuia , ATTREZZO_LUCE_TEST , 1);
		assertEquals(StanzaBuia.DESCRIZIONE_STANZA_BUIA , this.stanzaBuia.getDescrizione());
	}
	
	@Test
	public void testGetAttrezzoInesistente() {
		Fixture.creaAttrezzoEAggiungiAStanza(this.stanzaBuia , "attrezzoDiTest" , 1);
		assertNull(this.stanzaBuia.getAttrezzo("inesistente"));
	}

}
