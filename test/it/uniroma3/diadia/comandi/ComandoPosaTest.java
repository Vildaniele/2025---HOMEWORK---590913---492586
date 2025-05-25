package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class ComandoPosaTest {
    
    private static final String ATTREZZO_DA_POSARE = "AttrezzoDaPosare";
    private AbstractComando comandoPosa;
    private Partita partita;
    private Labirinto labirinto;
    
    @BeforeEach
    void setUp() {
        this.comandoPosa = new ComandoPosa();
        this.comandoPosa.setIO(new IOConsole());
        this.labirinto = new LabirintoBuilder()
            .addStanzaIniziale("iniziale")
            .getLabirinto();
        this.partita = new Partita(this.labirinto);
        Borsa borsa = partita.getGiocatore().getBorsa();
        Attrezzo attrezzoNuovo = new Attrezzo(ATTREZZO_DA_POSARE, 1);
        borsa.addAttrezzo(attrezzoNuovo);
    }

    @Test
    void testEseguiAttrezzoPresente() {
        this.comandoPosa.setParametro(ATTREZZO_DA_POSARE);
        this.comandoPosa.esegui(partita);
        assertTrue(partita.getStanzaCorrente().hasAttrezzo(ATTREZZO_DA_POSARE));
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_DA_POSARE));
    }
    
    @Test
    void testEseguiAttrezzoNonPresente() {
        String nonPresente = "attrezzoNonPresente";
        this.comandoPosa.setParametro(nonPresente);
        this.comandoPosa.esegui(partita);
        assertFalse(partita.getStanzaCorrente().hasAttrezzo(nonPresente));
        assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_DA_POSARE));
    }
    
    @Test
    void testEseguiStanzaPiena() {
        Stanza stanzaCorrente = partita.getStanzaCorrente();
        for(int i = 0; i < Stanza.NUMERO_MASSIMO_ATTREZZI; i++) {
            stanzaCorrente.addAttrezzo(new Attrezzo("attrezzo"+i, 1));
        }
        this.comandoPosa.setParametro(ATTREZZO_DA_POSARE);
        this.comandoPosa.esegui(partita);
        assertFalse(stanzaCorrente.hasAttrezzo(ATTREZZO_DA_POSARE));
        assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_DA_POSARE));
    }
}
