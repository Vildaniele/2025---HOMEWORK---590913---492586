package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {

	public AbstractComando costruisciComando1(String istruzione, IO io) throws Exception{
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomecomando = null;
		String parametro = null;
		AbstractComando comando = null;
		if(scannerDiParole.hasNext())
			nomecomando = scannerDiParole.next();
		if(scannerDiParole.hasNext())
			nomecomando = scannerDiParole.next();
		StringBuilder nomeClasse = new StringBuilder("it.uniroma£.diadia.comandi.Comando");
		nomeClasse.append(Character.toUpperCase(nomecomando.charAt(0)));
		nomeClasse.append(nomecomando.substring(1));
		comando = (AbstractComando)Class.forName(nomeClasse.toString()).newInstance();
		comando.setIO(io);
		comando.setParametro(parametro);
		return comando;
	}
	@Override
	public AbstractComando costruisciComando(String istruzione, IO io) {
		return null;
	}
	
}
