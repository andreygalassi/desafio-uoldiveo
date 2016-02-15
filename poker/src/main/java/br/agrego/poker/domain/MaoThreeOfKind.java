package br.agrego.poker.domain;

import java.util.Set;

public class MaoThreeOfKind extends Mao {

	@Override
	public Mao avalia(Set<Carta> cartas) {
		boolean trio = false;
		for (Carta carta1 : cartas) {
			trio = false;
			for (Carta carta2 : cartas) {
				if (carta1!=carta2 && carta1.getValor()==carta2.getValor()&&!trio) {
					trio = true;
				}else if(carta1!=carta2 && carta1.getValor()==carta2.getValor()&&trio) {
					return this;
				}
			}
		}
		return mao.avalia(cartas);
	}
	
	@Override
	public String toString() {
		return "Three of Kind";
	}


}
