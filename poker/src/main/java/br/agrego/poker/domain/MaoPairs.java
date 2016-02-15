package br.agrego.poker.domain;

import java.util.Set;

public class MaoPairs extends Mao {
	
	@Override
	public Mao avalia(Set<Carta> cartas) {
		
		for (Carta carta1 : cartas) {
			for (Carta carta2 : cartas) {
				if (carta1!=carta2 && carta1.getValor()==carta2.getValor()) {
					return this;
				}
			}
		}

		return mao.avalia(cartas);
	}
	
	@Override
	public String toString() {
		return "Pairs";
	}

}
