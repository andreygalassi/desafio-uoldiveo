package br.agrego.poker.domain;

import java.util.Set;

/**
 * Straight Flush: 5 cartas do mesmo naipe com consecutiva de naipes iguais. Quando as mãos forem iguais ganha quem tiver a sequencia mais alta.
 */
public class MaoStraightFlush extends Mao {
	
	@Override
	public Mao avalia(Set<Carta> cartas) {
		Carta cAnterior=null;
		for (Carta cAtual : cartas) {
			if (cAnterior==null) {
				cAnterior = cAtual;
				continue;
			}
			if (cAnterior.getNaipe()!=cAtual.getNaipe()) return mao.avalia(cartas);
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
		return "Straight Flush";
	}

}
