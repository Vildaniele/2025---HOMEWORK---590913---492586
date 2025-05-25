package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.ConfigurazioniIniziali;

public class Giocatore {
	
	static final public int CFU_INIZIALI = 20;
	
    /*Ogni giocatore ha la sua borsa*/
	private Borsa borsa;
	private int cfu;
	
	public Giocatore() {
		this.cfu = ConfigurazioniIniziali.getCFU();
		this.borsa = new Borsa();
	}
	
	public Borsa getBorsa() {
		return borsa;
	}
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}
	public int getCfu() {
		return cfu;
	}
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	
	
}
