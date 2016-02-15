package br.agrego.poker.domain;

import java.util.Set;

public class MaoTwoPairs extends Mao {
	
	@Override
	public Mao avalia(Set<Carta> cartas) {
		EValor primeiroPar = null;
		for (Carta carta1 : cartas) {
			for (Carta carta2 : cartas) {
				if (carta1!=carta2 && carta1.getValor()==carta2.getValor() && primeiroPar!=carta1.getValor()) {
					if (primeiroPar==null) {
						primeiroPar = carta1.getValor();						
					}else {
						return this;
					}
				}
			}
		}
		return mao.avalia(cartas);
	}
	
	@Override
	public String toString() {
		return "Two Pairs";
	}

}
