package br.agrego.poker.domain;

import java.util.Set;

/**
 * 3 cartas do mesmo valor e 2 cartas de mesmo valor. Quando as mãos forem iguais ganha quem tiver o trio mais alto.
 */
public class MaoFullHouse extends Mao {

	public MaoFullHouse(Integer ponto) {
		super(ponto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Mao avalia(Set<Carta> cartas) {
		Integer qtValorDiferente=0;
		Carta cAnterior=null;
		for (Carta carta : cartas) {
			if (cAnterior==null) cAnterior = carta;
			if (cAnterior.getValor()!=carta.getValor()) {
				cAnterior = carta;
				qtValorDiferente++;
			}
		}
		
		if (qtValorDiferente==1)return this;

		return mao.avalia(cartas);
	}
	
	@Override
	public String toString() {
		return "Full House";
	}

	@Override
	public int desempate(Set<Carta> cartas1, Set<Carta> cartas2) {
		// TODO Auto-generated method stub
		return 0;
	}



}
