package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {
	
	private static final String NOME = "comando_non_valido";
	
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		
		this.io.mostraMessaggio("Comando non valido!");

	}

	@Override
	public void setParametro(String parametro) {
		
	}

	@Override
	public void setIO(IO io) {
		this.io = io ;

	}

	@Override
	public String getParametro() {
		return NOME;
	}

	@Override
	public String getNome() {
		return null;
	}

}
