package br.agrego.poker.domain;

import java.util.Set;

public class MaoStraight extends Mao {

	@Override
	public Mao avalia(Set<Carta> cartas) {
		Carta cAnterior=null;
		for (Carta cAtual : cartas) {
			if (cAnterior==null) {
				cAnterior = cAtual;
				continue;
			}
			if (cAtual.getValor().getValor()==cAnterior.getValor().getValor()+1) {
				cAnterior = cAtual;
				continue;
			}else {
				return mao.avalia(cartas);
			}
		}
		return this;
	}
	
	@Override
	public String toString() {
		return "Straight";
	}

}
