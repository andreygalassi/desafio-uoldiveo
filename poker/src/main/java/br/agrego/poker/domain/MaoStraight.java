package br.agrego.poker.domain;

import java.util.Set;

/**
 * Straight: Mão contém 5 cartas consecutiva de naipes diferentes. Quando as mãos forem iguais ganha quem tiver o quarteto mais alto.
 */
public class MaoStraight extends Mao {

	public MaoStraight(Integer ponto) {
		super(ponto);
		// TODO Auto-generated constructor stub
	}

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
