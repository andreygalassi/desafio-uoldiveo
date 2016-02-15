package br.agrego.poker.domain;

import java.util.Set;

public class MaoHighCard extends Mao{

	@Override
	public Mao avalia(Set<Carta> cartas) {
		return this;
	}
	
	@Override
	public String toString() {
		return "High Card";
	}
}