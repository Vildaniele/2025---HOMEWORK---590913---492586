package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class comandoPrendi extends AbstractComando {
	
	private String nomeAttrezzo;
	private static final String NOME = "prendi";
	
	public comandoPrendi() {
		super.setNome(NOME);
	}

	@Override
	public void esegui(Partita partita) {
		if(!partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			super.getIO().mostraMessaggio("attrezzo" + nomeAttrezzo + "non presente nella stanza");
			return;
		}
		Attrezzo attrezzoDaPrendere = partita.getStanzaCorrente().getAttrezzo(this.nomeAttrezzo);
		boolean attrezzoPreso = partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPrendere);
		if(!attrezzoPreso) {
			super.getIO().mostraMessaggio("non c'è più spazio per nuovi attrezzi nella borsa");
			return;
		}
		partita.getStanzaCorrente().removeAttrezzo(attrezzoDaPrendere);
		super.getIO().mostraMessaggio("Attrezzo " + this.nomeAttrezzo + "preso!");
	}

}
