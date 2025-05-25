package it.uniroma3.diadia.ambienti;
import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {

	public static LabirintoBuilder newBuilder() {
		return new LabirintoBuilder();
	}

	private Stanza stanzaVincente;
	private Stanza stanzaIniziale;

	/*Metodi Getter*/

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public Stanza getStanzaIniziale() {
		return stanzaIniziale;
	}

	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale= stanzaIniziale;	
	}

	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;	
	}
	public static class LabirintoBuilder{

		private Labirinto labirinto;
		private Stanza ultimaAggiunta;
		private Map<String , Stanza> nomeStanza;

		public LabirintoBuilder() {
			this.labirinto = new Labirinto();
			this.nomeStanza = new HashMap<String, Stanza>();
		}

		public LabirintoBuilder addStanzaIniziale(String nomeStanzaIniziale) {
			Stanza iniziale = new Stanza(nomeStanzaIniziale);
			this.labirinto.setStanzaIniziale(iniziale);
			this.aggiungiAMappaEAggiornaUltima(iniziale);
			return this;
		}

		public LabirintoBuilder addStanzaVincente(String nomeStanzaVincente) {
			Stanza vincente = new Stanza(nomeStanzaVincente);
			this.labirinto.setStanzaVincente(vincente);
			this.aggiungiAMappaEAggiornaUltima(vincente);
			return this;
		}

		public LabirintoBuilder addAdiacenza(String partenza , String adiacente , String direzione) {
			Stanza stanzaPartenza = this.nomeStanza.get(partenza);
			Stanza stanzaAdiacente = this.nomeStanza.get(adiacente);
			stanzaPartenza.impostaStanzaAdiacente(Direzione.valueOf(direzione.toUpperCase()) ,stanzaAdiacente);
			return this;
		}

		public LabirintoBuilder addAttrezzo(String nome , int peso) {
			Attrezzo a  = new Attrezzo(nome ,peso);
			this.ultimaAggiunta.addAttrezzo(a);
			return this;
		}

		public LabirintoBuilder addStanza(String nome) {
			Stanza stanza = new Stanza(nome);
			this.aggiungiAMappaEAggiornaUltima(stanza);
			return this;
		}

		public LabirintoBuilder addStanzaMagica(String nome) {
			Stanza stanza = new StanzaMagica(nome);
			this.aggiungiAMappaEAggiornaUltima(stanza);
			return this;
		}

		public LabirintoBuilder addStanzaBuia(String nome , String attrezzoPerVedere) {
			Stanza stanza = new StanzaBuia(nome , attrezzoPerVedere);
			this.aggiungiAMappaEAggiornaUltima(stanza);
			return this;
		}

		public LabirintoBuilder addStanzaBloccata(String nome , String attrezzoSbloccante , String direzioneBloccata) {
			Stanza stanza = new StanzaBloccata(nome , attrezzoSbloccante , Direzione.valueOf(direzioneBloccata.toUpperCase()));
			this.aggiungiAMappaEAggiornaUltima(stanza);
			return this;
		}

		public Labirinto getLabirinto() {
			return this.labirinto;
		}

		private void aggiungiAMappaEAggiornaUltima(Stanza stanza) {
			this.ultimaAggiunta = stanza;
			this.nomeStanza.put(stanza.getNome(), stanza);
		}
	}

}
