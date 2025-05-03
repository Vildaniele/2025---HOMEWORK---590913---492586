package it.uniroma3.diaida;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	private Partita partita;
	
	@Before
	public void setUp() {
		this.partita = new Partita();
	}
	
	@Test
	public void testGetStanzaVincenteNotNull() {
		assertNotNull(this.partita.getStanzaVincente());
	}
	
	@Test
	public void testVintaSeStanzaCorrenteEVincente() {
		Stanza nonVincente = new Stanza("Non vincente");
		this.partita.setStanzaCorrente(nonVincente);
		assertFalse(this.partita.vinta());
	}
	
	@Test
	public void testFinitaSeVinta() {
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		assertTrue(this.partita.isFinita());
	}
	

}
