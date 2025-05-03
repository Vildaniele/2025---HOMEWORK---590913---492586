package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.Fixture;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.comandi.ComandoFine;

class ComandoFineTest {

	@Test
	void test() {
		String[] righeDaLeggere = {"fine"};
		IOSimulator io = Fixture.creaSimulazionePartitaEGioca(righeDaLeggere);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO , io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE, io.nextMessaggio());
	}

}
