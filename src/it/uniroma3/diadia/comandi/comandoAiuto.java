package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class comandoAiuto extends AbstractComando {
	

	private final static String NOME = "aiuto";
	
	static final private String[] elencoComandi = {"vai" , "aiuto" , "fine" , "prendi" , "posa" , "guarda"};
	
	public comandoAiuto(String[] elencoComandi) {
		super.setNome(NOME);
	}
	
	@Override
	public void esegui(Partita partita) {
		for (int i = 0 ; i < elencoComandi.length ; i++) {
			super.getIO().mostraMessaggio(elencoComandi[i]+ " ");
		}
		super.getIO().mostraMessaggio("");
	}
	
}
