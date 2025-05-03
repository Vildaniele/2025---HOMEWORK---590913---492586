package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	
	private Labirinto labirinto;

	@Before
	public void setUp() {
		this.labirinto = new Labirinto();
	}
	
	@Test
	public void testGetStanzaIniziale(){
		assertNotNull(this.labirinto.getStanzaIniziale());
	}
	
	@Test
	public void TestGetStanzaVincente() {
		assertNotNull(this.labirinto.getStanzaVincente());
	}

}
