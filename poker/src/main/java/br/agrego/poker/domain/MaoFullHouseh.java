package br.agrego.poker.domain;

import java.util.Set;

/**
 * 3 cartas do mesmo valor e 2 cartas de mesmo valor. Quando as mãos forem iguais ganha quem tiver o trio mais alto.
 */
public class MaoFullHouseh extends Mao {

	@Override
	public Mao avalia(Set<Carta> cartas) {
		Integer trinca=0;
		Integer duque=0;
		Carta cAnterior=null;
		for (Carta carta : cartas) {
			if (cAnterior==null || cAnterior.getValor()!=carta.getValor()) cAnterior = carta;
			if (cAnterior.getValor())
			
			trinca = 1;
			duque = 1;
			for (Carta cAtual : cartas) {
				if (cAnterior.getValor()==cAtual.getValor()) {
					trinca++;
					duque++;
				}
			}
		}
		
		if (trinca==3 && duque==2)return this;
		
		
		return mao.avalia(cartas);
	}
	
	@Override
	public String toString() {
		return "Full Househ";
	}

}
