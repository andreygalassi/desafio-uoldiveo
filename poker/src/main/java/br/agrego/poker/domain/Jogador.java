package br.agrego.poker.domain;

import java.util.Set;
import java.util.TreeSet;

public class Jogador {

	private final String nome;
	private final Set<Carta> cartas;
	
	public Jogador(String nome) {
		this.nome = nome;
		this.cartas = new TreeSet<Carta>();
	}
	
	public void addCarta(Carta carta) {
		if(cartas.size()<=5) {
			cartas.add(carta);
		}
	}

	public String getNome() {
		return nome;
	}

	public Set<Carta> getCartas() {
		return cartas;
	}
}
