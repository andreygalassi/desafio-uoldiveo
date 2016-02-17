package br.agrego.poker.domain;

import java.util.Set;

/**
 * Three of Kind: Três das cartas na mão têm a mesmo valor. Quando as mãos forem iguais ganha quem tiver o trio mais alto.
 */
public class MaoThreeOfKind extends Mao {

	public MaoThreeOfKind(Integer ponto) {
		super(ponto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Mao executa() {
		boolean trio = false;
		for (Carta carta1 : getCartas()) {
			trio = false;
			for (Carta carta2 : getCartas()) {
				if (carta1!=carta2 && carta1.getValor()==carta2.getValor()&&!trio) {
					trio = true;
				}else if(carta1!=carta2 && carta1.getValor()==carta2.getValor()&&trio) {
					return this;
				}
			}
		}
		return proximo().avalia(getCartas());
	}
	
	@Override
	public String toString() {
		return "Three of Kind: ";
	}

	@Override
	public int desempate(Mao other) {
		Carta cartaThis = getCartaTrinca(getCartas());
		Carta cartaOther = getCartaTrinca(other.getCartas());
		
		if (cartaThis.getValor().getValor()>cartaOther.getValor().getValor()) {
			setValorDesempate(cartaThis.getValor());
			return 1;
		}
		if (cartaThis.getValor().getValor()<cartaOther.getValor().getValor()) {
			setValorDesempate(cartaOther.getValor());
			return -1;
		}
		setValorDesempate(cartaThis.getValor());
		return 0;
	}
	
	private Carta getCartaTrinca(Set<Carta> cartas) {
		boolean trio = false;
		for (Carta carta1 : getCartas()) {
			trio = false;
			for (Carta carta2 : getCartas()) {
				if (carta1!=carta2 && carta1.getValor()==carta2.getValor()&&!trio) {
					trio = true;
				}else if(carta1!=carta2 && carta1.getValor()==carta2.getValor()&&trio) {
					return carta1;
				}
			}
		}
		return null;
	}



}
