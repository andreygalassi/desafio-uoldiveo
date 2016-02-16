package br.agrego.poker.domain;

import java.util.Iterator;

/**
 * High Card: Mãos que não se encaixam qualquer categoria superior são classificado pelo valor de sua carta mais alta. 
 * Se o maior carta têm o mesmo valor, o valor eh definida pela próximo carta mais elevada, e assim por diante.
 */
public class MaoHighCard extends Mao{

	public MaoHighCard(Integer ponto) {
		super(ponto);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Mao executa() {
		return this;
	}
	
	@Override
	public String toString() {
		return "High Card";
	}

	@Override
	public int desempate(Mao other) {
		for (Iterator<Carta> iThis = this.getCartas().iterator(), iOther = other.getCartas().iterator(); iThis.hasNext(); iOther.hasNext()) {
			Carta cartaThis = iThis.next(); 
			Carta cartaOther = iOther.next();
			if (cartaThis.getValor()==cartaOther.getValor()) continue;
			if (cartaThis.getValor().getValor()>cartaOther.getValor().getValor()) return 1;
			if (cartaThis.getValor().getValor()<cartaOther.getValor().getValor()) return -1;
			
		}
		
		return 0;
	}

}