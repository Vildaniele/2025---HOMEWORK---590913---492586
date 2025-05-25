package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.Fixture;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

class ComandoVaiTest {
    
    private static final String NOME_STANZA_PARTENZA = "Partenza";
    private static final Direzione direzione_NORD = Direzione.NORD;
    private static final String NORD = "nord";
    private Partita partita;
    private AbstractComando comandoVai;
    private Stanza partenza;
    private Labirinto labirinto;
    
    @BeforeEach
    public void setUp() throws Exception {
        this.comandoVai = new ComandoVai();
        this.comandoVai.setIO(new IOConsole());
        this.labirinto = new LabirintoBuilder()
            .addStanzaIniziale(NOME_STANZA_PARTENZA)
            .getLabirinto();
        this.partita = new Partita(labirinto);
        this.partenza = this.partita.getStanzaCorrente();
    }

    @Test
    void testVaiStanzaNonPresente() {
        this.comandoVai.setParametro(NORD);
        this.comandoVai.esegui(this.partita);
        assertEquals(NOME_STANZA_PARTENZA, this.partita.getStanzaCorrente().getNome());
    }
    
    @Test
    void testVaiStanzaPresente() {
        Stanza destinazione = new Stanza("Destinazione");
        this.partenza.impostaStanzaAdiacente(direzione_NORD, destinazione);
        this.comandoVai.setParametro(NORD);
        this.comandoVai.esegui(partita);
        assertEquals("Destinazione", this.partita.getStanzaCorrente().getNome());
    }
    
    @Test
    void testStanzaPresenteInDirezioneSbagliata() {
        Stanza destinazione = new Stanza("Destinazione");
        this.partenza.impostaStanzaAdiacente(Direzione.SUD, destinazione);
        this.comandoVai.setParametro(NORD);
        this.comandoVai.esegui(partita);
        assertEquals(NOME_STANZA_PARTENZA, this.partita.getStanzaCorrente().getNome());
    }
    
    @Test
    void testPartitaConComandoVai() {
        String[] comandiDaEseguire = {"vai sud", "fine"};
        Labirinto labirinto = new LabirintoBuilder()
            .addStanzaIniziale("iniziale")
            .addStanza("Aula N10")
            .addAdiacenza("iniziale", "Aula N10", "sud")
            .getLabirinto();
        IOSimulator io = Fixture.creaSimulazionePartitaEGioca(labirinto, comandiDaEseguire);
        assertTrue(io.hasNextMessaggio());
        assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio().trim());
        assertTrue(io.hasNextMessaggio());
        assertContains("Aula N10", io.nextMessaggio());
        assertTrue(io.hasNextMessaggio());
    }

    private static void assertContains(String expected, String interaRiga) {
        assertTrue(interaRiga.contains(expected), 
            "La stringa [" + interaRiga + "] dovrebbe contenere [" + expected + "]");
    }
}