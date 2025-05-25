package it.uniroma3.diadia.personaggi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

class CaneTest {

    private Cane cane;
    private Partita partita;
    private Attrezzo osso;
    private Attrezzo pallina;
    private Attrezzo bastone;
    private Stanza stanza;

    @BeforeEach
    void setUp() {
        osso = new Attrezzo("osso", 1);
        pallina = new Attrezzo("pallina", 1);
        bastone = new Attrezzo("bastone", 2);
        
        Labirinto labirinto = new LabirintoBuilder()
                .addStanzaIniziale("iniziale")
                .getLabirinto();
        
        cane = new Cane("Fido", "Un cane feroce", "osso", pallina);
		partita = new Partita(labirinto);
        stanza = new Stanza("Stanza Test");
        partita.setStanzaCorrente(stanza);
    }

    @Test
    void testAgisci() {
        int cfuIniziali = partita.getCfu();
        String msg = cane.agisci(partita);
        
        assertEquals("Il cane ci ha morso", msg);
        assertEquals(cfuIniziali - 1, partita.getCfu());
    }

    @Test
    void testRiceviRegaloCiboPreferito() {
        int cfuIniziali = partita.getCfu();
        String msg = cane.riceviRegalo(osso, partita);
        
        assertEquals("Il cane accetta il cibo e lascia cadere un attrezzo", msg);
        assertTrue(stanza.hasAttrezzo("pallina"));
        assertEquals(cfuIniziali, partita.getCfu());
    }

    @Test
    void testRiceviRegaloNonPreferito() {
        int cfuIniziali = partita.getCfu();
        String msg = cane.riceviRegalo(bastone, partita);
        
        assertEquals("Il cane non accetta il tuo regalo e ti morde", msg);
        assertTrue(stanza.hasAttrezzo("bastone"));
        assertEquals(cfuIniziali - 1, partita.getCfu());
    }

    @Test
    void testGetNome() {
        assertEquals("Fido", cane.getNome());
    }


    @Test
    void testHaSalutato() {
        assertFalse(cane.haSalutato());
        cane.saluta();
        assertTrue(cane.haSalutato());
    }
}
