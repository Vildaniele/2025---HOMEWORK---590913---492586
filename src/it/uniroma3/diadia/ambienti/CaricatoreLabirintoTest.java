package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import java.io.StringReader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CaricatoreLabirintoTest {

	private static final String DESCRIZIONE_LABIRINTO =
			"Stanze:\n"
			+ "N10\n"
			+ "Biblioteca"
			+ "Estremi:\n"
			+ "N10\n"
			+ "Biblioteca"
			+ "Attrezzi:\n"
			+ "Osso 5 N10\n"
			+ "Uscite:\n"
			+ "N10 nord Biblioteca"
			+ "Biblioteca sud N10";

	@Test
	public void testCarica() throws FormatoFileNonValidoException {
		CaricatoreLabirinto caricatore = new CaricatoreLabirinto(new StringReader(DESCRIZIONE_LABIRINTO));
		caricatore.carica();
		assertEquals("N10", caricatore.getStanzaIniziale().getNome());
		assertEquals("Biblioteca", caricatore.getStanzaVincente().getNome());
		assertEquals("Osso", caricatore.getStanzaIniziale().getAttrezzo("Osso").getPeso());
		assertEquals(5, caricatore.getStanzaIniziale().getAttrezzo("Osso").getPeso());
		
		
	}

}
