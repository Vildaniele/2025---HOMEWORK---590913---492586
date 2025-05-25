package it.uniroma3.diadia.personaggi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;

class MagoTest {

    private Mago mago;
    private Partita partita;
    private Attrezzo bacchetta;
    private Attrezzo libro;
    private Stanza stanza;

    @BeforeEach
    void setUp() {
        bacchetta = new Attrezzo("bacchetta", 4);
        libro = new Attrezzo("libro", 3);
        
        Labirinto labirinto = new LabirintoBuilder()
            .addStanzaIniziale("Atrio")
            .getLabirinto();
        
        mago = new Mago("Merlino", "Un vecchio mago saggio", bacchetta);
        partita = new Partita(labirinto);
        stanza = new Stanza("Stanza Magica");
        partita.setStanzaCorrente(stanza);
    }


    @Test
    void testAgisciSenzaAttrezzo() {
        mago.agisci(partita); // Prima chiamata che consuma l'attrezzo
        String msg = mago.agisci(partita); // Seconda chiamata senza attrezzo
        
        assertEquals(Mago.MESSAGGIO_SCUSE, msg);
        assertFalse(stanza.hasAttrezzo("bacchetta")); // Già preso dalla prima chiamata
    }

    @Test
    void testRiceviRegalo() {
        String msg = mago.riceviRegalo(libro, partita);
        
        assertEquals("ho dimezzato il peso di libro", msg);
        assertTrue(stanza.hasAttrezzo("libro"));
        assertEquals(1, libro.getPeso()); // 3/2 = 1 (divisione intera)
    }

    @Test
    void testRiceviRegaloConPesoDispari() {
        Attrezzo pietra = new Attrezzo("pietra", 5);
        mago.riceviRegalo(pietra, partita);
        
        assertEquals(2, pietra.getPeso()); // 5/2 = 2 (divisione intera)
    }

    @Test
    void testGetNome() {
        assertEquals("Merlino", mago.getNome());
    }


    @Test
    void testHaSalutato() {
        assertFalse(mago.haSalutato());
        mago.saluta();
        assertTrue(mago.haSalutato());
    }

    // Test aggiuntivo per verificare il comportamento con attrezzo null nel costruttore
    @Test
    void testCostruttoreConAttrezzoNull() {
        Mago magoSenzaAttrezzo = new Mago("Gandalf", "Un mago grigio", null);
        assertEquals(Mago.MESSAGGIO_SCUSE, magoSenzaAttrezzo.agisci(partita));
    }
}
