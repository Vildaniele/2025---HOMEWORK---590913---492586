package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Fixture {
	public static IOSimulator creaSimulazionePartitaEGioca(Labirinto labirinto, String... righeDaLeggere) {
		IOSimulator io = new IOSimulator(righeDaLeggere);
		new DiaDia(io , labirinto).gioca();
		return io;
	}
	
	public static Attrezzo creaAttrezzoEAggiungiAStanza(Stanza stanzaDaRiempire , String nomeAttrezzo , int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo , peso);
		stanzaDaRiempire.addAttrezzo(attrezzo);
		return attrezzo;
		
	}
}
