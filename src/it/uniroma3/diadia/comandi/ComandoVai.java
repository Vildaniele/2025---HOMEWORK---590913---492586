package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoVai extends AbstractComando {
	private String parametro;
	private final static String NOME = "vai";
	
	public ComandoVai() {
		super.setNome(NOME);
	}
		
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(this.parametro == null) {
			super.getIO().mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
			return;
		}
		Direzione direzione = Direzione.valueOf(super.getParametro().toUpperCase());
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);
		if(prossimaStanza == null) {
			super.getIO().mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		super.getIO().mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
		Giocatore giocatore=partita.getGiocatore();
		giocatore.setCfu(giocatore.getCfu() -1);
	}
}
