package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Fixture;

class StanzaBloccataTest {
	
	private static final String STANZA_ADIACENTE_LIBERA = "stanzaAdiacenteLibera";
	private static final String STANZA_ADIACENTE_BLOCCATA = "stanza AdiacenteBloccata";
	private static final String DIREZIONE_BLOCCATA = "DirBloccata";
	private static final String DIREZIONE_LIBERA = "DirLibera";
	private static final String CHIAVE_TEST = "chiaveTest";
	private static final String STANZA_BLOCCATA = "StanzaBloccata";
	
	private StanzaBloccata stanzaBloccata;
	
	@BeforeEach
	void setUp() throws Exception {
		StanzaBloccata stanzaBloccata = new StanzaBloccata(STANZA_BLOCCATA, CHIAVE_TEST, DIREZIONE_BLOCCATA);
		this.stanzaBloccata = stanzaBloccata;
	}
	
	private void setStanzaAdiacenti(Stanza stanzaBloccata) {
		Stanza stanzaAdiacenteLibera = new Stanza(STANZA_ADIACENTE_LIBERA);
		Stanza stanzaAdiacenteBloccata = new Stanza(STANZA_ADIACENTE_BLOCCATA);
		stanzaBloccata.impostaStanzaAdiacente(DIREZIONE_BLOCCATA, stanzaAdiacenteBloccata);
		stanzaBloccata.impostaStanzaAdiacente(DIREZIONE_LIBERA, stanzaAdiacenteLibera);
	}

	@Test
	public void testGetStanzaAdiacenteBloccata() {
		setStanzaAdiacenti(this.stanzaBloccata);
		assertEquals(this.stanzaBloccata , this.stanzaBloccata.getStanzaAdiacente(DIREZIONE_BLOCCATA));
	}
	
	@Test
	public void testGetStanzaAdiacenteSbloccata() {
		setStanzaAdiacenti(this.stanzaBloccata);
		assertEquals(STANZA_ADIACENTE_BLOCCATA , this.stanzaBloccata.getStanzaAdiacente(DIREZIONE_BLOCCATA));
	}
	
	@Test
	public void testGetStanzaAdiacenteLibera() {
		setStanzaAdiacenti(this.stanzaBloccata);
		assertEquals(STANZA_ADIACENTE_LIBERA , this.stanzaBloccata.getStanzaAdiacente(DIREZIONE_LIBERA));
	}
	
	@Test
	public void testGetAttrezzoInesistente() {
		Fixture.creaAttrezzoEAggiungiAStanza(this.stanzaBloccata , "attrezzoDiTest" , 1 );
		assertNull(this.stanzaBloccata.getAttrezzo("inesistente"));
	}

}
