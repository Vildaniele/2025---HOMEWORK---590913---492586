package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {

	private static final String ATTREZZO = "attrezzoSemplice";
	private Borsa borsa;
	private static final int PESO_MAX_BORSA = 20;
	
	@Before
	public void setUp() {
		this.borsa = new Borsa(PESO_MAX_BORSA);
	}

	@Test
	public void testAddAttrezzo() {
		Attrezzo attrezzo = creaAttrezzoAggiungiBorsa(this.borsa , ATTREZZO , 1);
		assertEquals(attrezzo, this.borsa.getAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testAddAttrezzoTroppoPesante() {
		Attrezzo attrezzoPesante = new Attrezzo("attrezzoPesante" , PESO_MAX_BORSA+1);
		assertFalse(this.borsa.addAttrezzo(attrezzoPesante));
	}
	
	@Test
	public void testRemoveAttrezzo() {
		creaAttrezzoAggiungiBorsa(this.borsa, ATTREZZO , 1);
		this.borsa.removeAttrezzo(ATTREZZO);
		assertFalse(this.borsa.hasAttrezzo(ATTREZZO));
	}
	
	private Attrezzo creaAttrezzoAggiungiBorsa(Borsa borsa , String nomeAttrezzo , int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo , peso);
		borsa.addAttrezzo(attrezzo);
		return attrezzo;
	}

}
