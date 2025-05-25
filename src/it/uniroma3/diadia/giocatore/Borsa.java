package it.uniroma3.diadia.giocatore;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import it.uniroma3.diadia.ConfigurazioniIniziali;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = ConfigurazioniIniziali.getPesoMax();
	private Map<String , Attrezzo> nomeAttrezzo;
	private int pesoMax;
	private int pesoAttuale;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.nomeAttrezzo = new HashMap<>();		
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.nomeAttrezzo.put(attrezzo.getNome(), attrezzo);
		this.pesoAttuale += attrezzo.getPeso();
		return true;
	}
	public int getPesoMax() {
		return pesoMax;
	}
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.nomeAttrezzo.get(nomeAttrezzo);
	}
	public int getPeso() {
		return this.pesoAttuale;
	}
	public boolean isEmpty() {
		return this.nomeAttrezzo.isEmpty();
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		if(this.nomeAttrezzo.containsKey(nomeAttrezzo))
			this.pesoAttuale = this.pesoAttuale - this.nomeAttrezzo.get(nomeAttrezzo).getPeso();
		return this.nomeAttrezzo.remove(nomeAttrezzo);
	}
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			s.append(this.nomeAttrezzo.values().toString());
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> attrezziPerPeso = new LinkedList<Attrezzo>(this.nomeAttrezzo.values());
		Collections.sort(attrezziPerPeso , new ComparatoreAttrezziPerPeso());
		return attrezziPerPeso;
	}
	
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		return new TreeSet<>(this.nomeAttrezzo.values());
	}
	
	public Map<Integer , Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer , Set<Attrezzo>> attrezzi = new HashMap<>();
		for(Attrezzo  attrezzo: this.nomeAttrezzo.values()) {
			Set<Attrezzo> attrezziPeso = attrezzi.get(attrezzo.getPeso()); 
			if(attrezziPeso==null) {
				attrezziPeso = new HashSet<>();
				attrezzi.put(attrezzo.getPeso(), attrezziPeso);
			}
			attrezziPeso.add(attrezzo);
		}
		return attrezzi;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> attrezziPerPeso = new TreeSet<>(new ComparatoreAttrezziPerPeso());
		attrezziPerPeso.addAll(this.nomeAttrezzo.values());
		return attrezziPerPeso;
	}
	
	

}
