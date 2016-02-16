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
	public Mao executa() {
		Integer qtValorDiferente=0;
		Carta cAnterior=null;
		for (Carta carta : getCartas()) {
			if (cAnterior==null) cAnterior = carta;
			if (cAnterior.getValor()!=carta.getValor()) {
				cAnterior = carta;
				qtValorDiferente++;
			}
		}
		
		if (qtValorDiferente==1)return this;

		return proximo().avalia(getCartas());
	}
	
	@Override
	public String toString() {
		return "Full House";
	}

	@Override
	public int desempate(Mao other) {
		Carta cartaThis = getCartaTrinca(getCartas());
		Carta cartaOther = getCartaTrinca(other.getCartas());

		if (cartaThis.getValor().getValor()>cartaOther.getValor().getValor()) return 1;
		if (cartaThis.getValor().getValor()<cartaOther.getValor().getValor()) return -1;
		
		return 0;
	}

	private Carta getCartaTrinca(Set<Carta> cartas) {
		Carta cartaAux=null;
		int i=0;
		for (Carta carta : getCartas()) {
			if (cartaAux==null) {
				cartaAux = carta;
				i++;
				continue;
			}
			if (carta.getValor()==cartaAux.getValor()) {
				i++;
			}else {
				i=0;
			}
			if (i==3)break;
			
		}
		return cartaAux;
		
	}


}
