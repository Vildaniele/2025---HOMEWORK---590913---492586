package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {
	static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " + 
            "con una mia magica azione,troverai un nuovo oggetto per il tuo borsone!";
	
	static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho più nulla...";
	
	private Attrezzo attrezzo;
	
	public Mago(String nome , String presentazione, Attrezzo attrezzo) {
		super(nome , presentazione);
		this.attrezzo = attrezzo;
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		if(this.attrezzo!=null) {
			partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo = null;
			msg = MESSAGGIO_DONO;
		}else {
			msg = MESSAGGIO_SCUSE;
		}
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo regalo, Partita partita) {
		int nuovoPeso = regalo.getPeso() / 2 ;
		regalo.setPeso(nuovoPeso);
		partita.getStanzaCorrente().addAttrezzo(regalo);
		return "ho dimezzato il peso di " + regalo.getNome();
	}
}
