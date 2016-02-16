package br.agrego.poker.domain;

import java.util.Set;

public class MaoThreeOfKind extends Mao {

	public MaoThreeOfKind(Integer ponto) {
		super(ponto);
		// TODO Auto-generated constructor stub
	}

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

	@Override
	public int desempate(Set<Carta> cartas1, Set<Carta> cartas2) {
		// TODO Auto-generated method stub
		return 0;
	}



}
