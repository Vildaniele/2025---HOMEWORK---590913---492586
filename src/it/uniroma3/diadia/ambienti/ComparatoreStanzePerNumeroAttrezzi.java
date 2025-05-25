package it.uniroma3.diadia.ambienti;

import java.util.Comparator;

public class ComparatoreStanzePerNumeroAttrezzi implements Comparator<Stanza> {

	@Override
	public int compare(Stanza arg0, Stanza arg1) {
		return arg0.getAttrezzi().size() - arg1.getAttrezzi().size();
	}
	

}
