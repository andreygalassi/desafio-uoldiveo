package br.agrego.poker.domain;

import java.util.Set;

/**
 * Flush: Mão contém 5 cartas do mesmo naipe. Quando as mãos forem iguais ganha quem tiver a carta mais alta.
 */
public class MaoFlush extends Mao {

	@Override
	public Mao avalia(Set<Carta> cartas) {
		Carta cAnterior=null;
		for (Carta cAtual : cartas) {
			if (cAnterior==null) {
				cAnterior = cAtual;
				continue;
			}
			if (cAnterior.getNaipe()!=cAtual.getNaipe()) return mao.avalia(cartas);
		}
		return this;
	}
	
	@Override
	public String toString() {
		return "Flush";
	}

}
