package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {

	private static final String ATTREZZO = "attrezzoSemplice";
	private static final String SECONDO_ATTREZZO = "secondoAttrezzo";
	private Borsa borsa;
	private static final int PESO_MAX_BORSA = 20;

	@Before
	public void setUp() {
		this.borsa = new Borsa(PESO_MAX_BORSA);
	}

	@Test
	public void testAddAttrezzo() {
		Attrezzo attrezzo = creaAttrezzoAggiungiBorsa(this.borsa, ATTREZZO, 1);
		assertEquals(attrezzo, this.borsa.getAttrezzo(ATTREZZO));
	}
	
	@Test
	public void testAddAttrezzoTroppoPesante() {
		Attrezzo attrezzoPesante = new Attrezzo("attrezzoPesante", PESO_MAX_BORSA+1);
		assertFalse(this.borsa.addAttrezzo(attrezzoPesante));
	}
	
	@Test
	public void testRemoveAttrezzo() {
		creaAttrezzoAggiungiBorsa(this.borsa, ATTREZZO, 1);
		this.borsa.removeAttrezzo(ATTREZZO);
		assertFalse(this.borsa.hasAttrezzo(ATTREZZO));
	}
	
	@Test 
	public void testGetContenutoOrdinatoPerPeso() {
		creaAttrezzoAggiungiBorsa(this.borsa, SECONDO_ATTREZZO, 2);
		creaAttrezzoAggiungiBorsa(this.borsa, ATTREZZO, 1);
		List<Attrezzo> atteso = Arrays.asList(new Attrezzo(ATTREZZO, 1), new Attrezzo(SECONDO_ATTREZZO, 2));
		assertEquals(atteso, this.borsa.getContenutoOrdinatoPerPeso());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome() {
		creaAttrezzoAggiungiBorsa(this.borsa, SECONDO_ATTREZZO, 2);
		creaAttrezzoAggiungiBorsa(this.borsa, ATTREZZO, 1);
		Set<Attrezzo> atteso = new TreeSet<>(Arrays.asList(new Attrezzo(ATTREZZO, 1), new Attrezzo(SECONDO_ATTREZZO, 2)));
		assertEquals(atteso, this.borsa.getContenutoOrdinatoPerNome());
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		creaAttrezzoAggiungiBorsa(this.borsa, SECONDO_ATTREZZO, 2);
		creaAttrezzoAggiungiBorsa(this.borsa, ATTREZZO, 1);
		Map<Integer, Set<Attrezzo>> atteso = new HashMap<>();
		atteso.put(1, Collections.singleton(new Attrezzo(ATTREZZO, 1)));
		atteso.put(2, Collections.singleton(new Attrezzo(SECONDO_ATTREZZO, 2)));
		assertEquals(atteso, this.borsa.getContenutoRaggruppatoPerPeso());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso() {
		creaAttrezzoAggiungiBorsa(this.borsa, SECONDO_ATTREZZO, 2);
		creaAttrezzoAggiungiBorsa(this.borsa, ATTREZZO, 1);
		Set<Attrezzo> atteso = new TreeSet<>(Arrays.asList(new Attrezzo(ATTREZZO, 1), new Attrezzo(SECONDO_ATTREZZO, 2)));
		assertEquals(atteso, this.borsa.getSortedSetOrdinatoPerPeso());
	}
	
	private Attrezzo creaAttrezzoAggiungiBorsa(Borsa borsa, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		borsa.addAttrezzo(attrezzo);
		return attrezzo;
	}
}