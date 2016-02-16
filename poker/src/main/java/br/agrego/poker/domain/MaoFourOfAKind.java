package br.agrego.poker.domain;

import java.util.Set;

/**
 * Four of a kind: 4 cartas com o mesmo valor. Quando as mãos forem iguais ganha quem tiver as 4 cartas maiores.
 */
public class MaoFourOfAKind extends Mao {

	public MaoFourOfAKind(Integer ponto) {
		super(ponto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Mao avalia(Set<Carta> cartas) {
		Integer quadra;
		for (Carta cAnterior : cartas) {
			quadra = 0;
			for (Carta cAtual : cartas) {
				if (cAnterior.getValor()==cAtual.getValor()) {
					quadra++;
				}
			}
			if (quadra==4)return this;
		}
		return mao.avalia(cartas);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int desempate(Set<Carta> cartas1, Set<Carta> cartas2) {
		// TODO Auto-generated method stub
		return 0;
	}


}
