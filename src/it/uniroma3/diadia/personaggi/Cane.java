package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{
	
	private String ciboPreferito;
	private Attrezzo regaloCane;

	public Cane(String nome, String presentazione , String cibo , Attrezzo regalo) {
		super(nome, presentazione);
		this.ciboPreferito=cibo;
		this.regaloCane=regalo;
	}

	@Override
	public String agisci(Partita partita) {
		partita.setCfu(partita.getCfu()-1);
		return "Il cane ci ha morso";
	}

	@Override
	public String riceviRegalo(Attrezzo regalo, Partita partita) {
		if(regalo.getNome().equals(ciboPreferito)) {
			partita.getStanzaCorrente().addAttrezzo(this.regaloCane);
			return "Il cane accetta il cibo e lascia cadere un attrezzo";
		}else {
			partita.getStanzaCorrente().addAttrezzo(regalo);
			partita.setCfu(partita.getCfu()-1);
			return "Il cane non accetta il tuo regalo e ti morde";
		}
		
	}
	

}
