package it.uniroma3.diaida;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Labirinto.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	private Partita partita;
	private LabirintoBuilder labirinto;
	
	@Before
    public void setUp() {
        this.labirinto = Labirinto.newBuilder();
            .addStanzaIniziale("iniziale")
            .addStanzaVincente("vincente")
            .addAdiacenza("iniziale", "vincente", "nord")
            .getLabirinto();
        this.partita = new Partita(this.labirinto);
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
